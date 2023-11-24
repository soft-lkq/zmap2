package com.ruoyi.sidebarTree.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.TokenService;

import com.ruoyi.sidebarTree.mapper.Breed2Mapper;
import com.ruoyi.sidebarTree.pythonCode.PythonUse;
import com.ruoyi.sidebarTree.pythonCode.UseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.sidebarTree.domain.Breed2;
import com.ruoyi.sidebarTree.service.IBreed2Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-09-10
 */
@RestController
@RequestMapping("/system/breed2")
public class Breed2Controller extends BaseController
{
    @Autowired
    private IBreed2Service breed2Service;

    @Autowired
    private PythonUse pythonUse;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private Breed2Mapper breed2Mapper;
    /**
     * 查询
     */
//    //@PreAuthorize("@ss.hasPermi('system:breed2:list')")
    @GetMapping("/list")
    public TableDataInfo list(Breed2 breed2)
    {
        //数据过滤
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();
        for (SysRole role : roles) {
            //超级管理员是1，特权角色是5
            if (role.getRoleId() != 1 && role.getRoleId() != 5) {
                breed2.setCreateBy(getUserId().toString());
            }
        }

        startPage();
        List<Breed2> list = breed2Service.selectBreed2List(breed2);
        return getDataTable(list);
    }

    /**
     * 导出
     */
//    //@PreAuthorize("@ss.hasPermi('system:breed2:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Breed2 breed2)
    {
        //数据过滤
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();
        for (SysRole role : roles) {
            //超级管理员是1，特权角色是5
            if (role.getRoleId() != 1 && role.getRoleId() != 5) {
                breed2.setCreateBy(getUserId().toString());
            }
        }

        List<Breed2> list = breed2Service.selectBreed2List(breed2);
        ExcelUtil<Breed2> util = new ExcelUtil<Breed2>(Breed2.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /*
    新加功能
    上传文件
    参数param是输入的材料名，后面是基因型文件vcf*/
    @PostMapping("/NewFile")
    public AjaxResult callPythonByNewFile(String param,String flag, MultipartFile genoFile,MultipartFile ceyanFile) throws InterruptedException {
//        AjaxResult result =new AjaxResult();
        //先将任务的初始信息插入数据库
        Integer count = breed2Mapper.selectMaxId();
        Integer id = null;
        if(StringUtils.isNull(count)) id = 1;
        else  id = count+1;
        Breed2 breed2 = new Breed2();
        breed2.setId(Long.valueOf(id));
        breed2.setStatus(0);//正在运行
        breed2.setCreateBy(getUserId().toString());
        breed2.setUpdateBy(getUserId().toString());
        breed2.setCreateTime(new Date());
        breed2.setUpdateTime(new Date());
        if(param.length() != 0){//param不为空
            breed2.setMaterialName(param);
        }
//        breed2Mapper.insertBreed2(breed2);//先把该任务插进数据库

        //接收文件
        File gf =null;
        File cy = null;
        String genoPath="";
        String ceyanPath="";
        //将文件写入uploadData里
        if(genoFile != null) {
            //下载上传文件
            String parentPath = UseParam.PHENOPATH + id + "/";
            new File(parentPath).mkdir();
            genoPath = parentPath + genoFile.getOriginalFilename();//文件存储的位置
            gf = new File(genoPath);
//            System.out.println("gf:" + gf);
            //将临时文件写入
            try {
                genoFile.transferTo(gf);//将临时文件保存到指定文件
                breed2.setGenofile(gf.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("基因型文件写入失败");
            }
        }

        if(ceyanFile != null) {
                //下载上传文件
                String parentPathcy = UseParam.PHENOPATH + id + "/";
                new File(parentPathcy).mkdir();
                ceyanPath = parentPathcy + ceyanFile.getOriginalFilename();//文件存储的位置
                cy = new File(ceyanPath);
                System.out.println("cy:" + cy);
                //将临时文件写入
                try {
                    ceyanFile.transferTo(cy);
                    breed2.setCeyanfile(cy.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("测验种文件写入失败");
                }
            }

            breed2Mapper.insertBreed2(breed2);//先把该任务信息插进数据库

            System.out.println("输入的材料名："+ param);
            System.out.println("输入的flag："+ flag);
            System.out.println("传入的基因型文件："+genoPath);
            System.out.println("传入的测验种文件："+ceyanPath);

            String gfUrl = gf == null ? "" : gf.getAbsolutePath();
            String cyUrl = cy == null ? "" : cy.getAbsolutePath();


            System.out.println("开始调用getCSV...................");
            System.out.println("调用getCSV的参数为：");
            System.out.println("param："+param);
            System.out.println("flag："+flag);
            System.out.println("gfUrl："+ gfUrl);
            System.out.println("cyUrl："+ cyUrl);
            pythonUse.getCSV(param,flag,gfUrl,cyUrl,breed2);

            return AjaxResult.success();

/*            // 判断文件后缀是vcf还是csv，如果是vsf就转换成csv格式调用getCSV,否则就直接调用getCSV
            String url = gf.getAbsolutePath();
            String csv = "";
            if(url.endsWith(".vcf")){
                //处理vcf文件
                System.out.println("准备将vcf转换为csv......");
                csv = convertVCFtoCSV(url);//创建了一个新的csv文件
                gf = new File(csv);
                if(!gf.exists()){
                    String msg = BreedPythonUser.transferVCF(url,csv);//输出就是这个csv文件
                    if(!msg.equals("OK")){
                        System.out.println("transferVCF异常");
                        return AjaxResult.error(msg);
                    }
                }
                Thread.sleep(1000);//wait for converting
                System.out.println("调用trasdns_csv.py处理vcf后的结果："+csv);
            }else{
                System.out.println("传入的是csv文件");
                csv = url;
            }*/


    }






    /**
     * 新增
     */
////    //@PreAuthorize("@ss.hasPermi('system:breed2:add')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(String param)
//    {
//        pythonUse.getPDF2(param,null,getUserId().toString(),"OK");
//        return AjaxResult.success();
//
//    }

    /**
     * 修改
     */
//    //@PreAuthorize("@ss.hasPermi('system:breed2:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Breed2 breed2)
    {
        return toAjax(breed2Service.updateBreed2(breed2));
    }

    /**
     * 删除
     */
//    //@PreAuthorize("@ss.hasPermi('system:breed2:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(breed2Service.deleteBreed2ByIds(ids));
    }



    @PostMapping("/getPdf")
    public AjaxResult getPdf(Long id){
        Breed2 breed2 = breed2Service.selectBreed2ById(id);
        return AjaxResult.success(breed2);
    }

    // 这是一个示例方法，用于将 VCF 内容转换为 CSV 内容
    private static String convertVCFtoCSV(String str) {
        // 找到最后一个 ".vcf" 的位置
        int lastIndex = str.lastIndexOf(".vcf");
        String outputFileName;
        // 如果找到了 ".vcf"，则进行替换
        if (lastIndex != -1) {
            // 使用 substring 分割字符串，替换最后一个 ".vcf" 为 ".csv"
            outputFileName = str.substring(0, lastIndex) + "_new.csv";
        } else {
            System.out.println("输入文件不是 .vcf 文件。");
            return "";
        }
        return outputFileName;
    }

}
