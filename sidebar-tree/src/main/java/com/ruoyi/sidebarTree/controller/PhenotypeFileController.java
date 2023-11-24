package com.ruoyi.sidebarTree.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.sql.SqlUtil;
import com.ruoyi.sidebarTree.domain.vo.PhenotypeDetailVO;
import com.ruoyi.sidebarTree.domain.vo.PhenotypeFileVO;
import com.ruoyi.sidebarTree.service.IGenotypeFileService;
import com.github.pagehelper.PageHelper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sidebarTree.domain.PhenotypeFile;
import com.ruoyi.sidebarTree.service.IPhenotypeFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 表型文件Controller
 *
 * @author ruoyi
 * @date 2023-07-02
 */
@RestController
@RequestMapping("/phenotypeFile")
public class PhenotypeFileController extends BaseController
{
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IPhenotypeFileService phenotypeFileService;

    @Autowired
    private IGenotypeFileService genotypeFileService;

    /**
     * 查询表型文件列表
     */
//    //@PreAuthorize("@ss.hasPermi('system:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(PhenotypeFile phenotypeFile,HttpServletRequest request)
    {
        //不是管理员或特权用户就只能看到自己上传的文件 1 admin 5 特权用户
        List<Long> collect = getLoginUser().getUser().getRoles().stream().mapToLong(SysRole::getRoleId).boxed().collect(Collectors.toList());
        if(!collect.contains(1L) && !collect.contains(5L)){
            phenotypeFile.setCreateBy(getUserId().toString());
        }

        String pageSize1 = request.getParameter("pageSize");
        System.out.println(pageSize1);
//        startPage();?
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pS = pageDomain.getPageSize();
        System.out.println(pS);
        Integer pageSize = 100010;
        if(pageSize1!=null)
            pageSize =Integer.valueOf(pageSize1);
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);


        List<PhenotypeFileVO> list = phenotypeFileService.selectPhenotypeFileVOList(phenotypeFile);
        TableDataInfo dataTable = getDataTable(list);
        //有tablename是查一个文件的历史记录
        if (StringUtils.isEmpty(phenotypeFile.getTableName()))
            dataTable.setTotal(phenotypeFileService.selectPhenotypeFileListCount(phenotypeFile));
        else
            dataTable.setTotal(phenotypeFileService.selectPhenotypeFileListCountByTableName(phenotypeFile.getTableName()));
        return dataTable;
    }

    /**
     * 导出表型文件列表
     */
//    //@PreAuthorize("@ss.hasPermi('system:file:export')")
    @Log(title = "表型文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PhenotypeFile phenotypeFile)
    {
        List<Long> collect = getLoginUser().getUser().getRoles().stream().mapToLong(SysRole::getRoleId).boxed().collect(Collectors.toList());
        if(!collect.contains(1L) && !collect.contains(5L)){
            phenotypeFile.setCreateBy(getUserId().toString());
        }
        List<PhenotypeFileVO> list = phenotypeFileService.selectPhenotypeFileVOList(phenotypeFile);
        ExcelUtil<PhenotypeFileVO> util = new ExcelUtil<>(PhenotypeFileVO.class);
        util.exportExcel(response, list, "表型文件数据");
    }

    /**
     * 获取表型文件详细信息
     */
//    //@PreAuthorize("@ss.hasPermi('system:file:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return AjaxResult.success(phenotypeFileService.selectPhenotypeFileByFileId(fileId));
    }

    /**
     * 上传
     *
     * @param treeId       树id
     * @param file         文件
     * @param status   是否公开
     * @param remark       备注
     * @param fileName     文件名称
     * @return {@link AjaxResult}
     */
    @PostMapping("/upload")//新建一个文件和表
    public AjaxResult upload(Long treeId, @RequestParam("file") MultipartFile file, int status, String remark, String fileName)throws Exception {
        phenotypeFileService.uploadFile(treeId, file, status, remark, fileName);

        return AjaxResult.success("上传成功");
    }


    /**
     * 修改表型文件详细信息（只能修改status,remark;其他数据全都为生成，不可修改）
     */
//    //@PreAuthorize("@ss.hasPermi('system:file:edit')")
    @Log(title = "表型文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PhenotypeFile phenotypeFile)
    {
        return toAjax(phenotypeFileService.updatePhenotypeFile(phenotypeFile));
    }

    /**
     * 删除表型文件
     */
//    //@PreAuthorize("@ss.hasPermi('system:file:remove')")
    @Log(title = "表型文件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(phenotypeFileService.deletePhenotypeFileByFileIds(fileIds));
    }

    @PostMapping("/download")
    public AjaxResult getPdf(Long fileId){
        PhenotypeFile phenotypeFile = phenotypeFileService.selectPhenotypeFileByFileId(fileId);
        return AjaxResult.success(phenotypeFile);
    }

    //无用
    /*获取所有地区数据*/
    @Log(title = "表型文件", businessType = BusinessType.GRANT)
    @GetMapping("/getAreaData")
    public AjaxResult getAreaData()
    {
        List areas = phenotypeFileService.getAreaData();
        return  AjaxResult.success(areas);
    }


    //无用
    @PostMapping("/updatePhenoTypeFile")
    public AjaxResult updatePhenoTypeFile(Long fileId, Long phenotypeId, HttpServletRequest request) {
        AjaxResult result = AjaxResult.success("更新成功");
        HashMap<String,String> map = getDataMap(request);
        phenotypeFileService.updatePhenoTypeFile(fileId,phenotypeId,map);
        return result;
    }





    private HashMap<String, String> getDataMap(HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        if(parameterMap.size()==0 || StringUtils.isEmpty(parameterMap)){
            return null;
        }

        HashMap<String,String> res =new HashMap<>();

        for(Map.Entry<String,String[]> map:parameterMap.entrySet()){
            String key = map.getKey();
            String[] value = map.getValue();
            if (key.contains("repeat") || key.contains("kind_id") ||
                    key.contains("kind_name") || key.contains("material_id") ||
                    key.contains("field_id") || key.contains("control_type") ||
                    key.contains("father") || key.contains("mother") ||
                    key.contains("remark") || key.contains("trait_id")) {
                if(key.contains("trait_id")) {
                    String[] s = key.split("_");
                    key = "trait_value_"+s[2];
                }
                res.put(key,value[0]);
            }
        }
        return res;
    }
}
