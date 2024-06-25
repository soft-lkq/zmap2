package com.ruoyi.sidebarTree.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.sidebarTree.domain.Breed2;
import com.ruoyi.sidebarTree.mapper.Breed2Mapper;
import com.ruoyi.sidebarTree.service.IBreed2Service;
import com.ruoyi.sidebarTree.utils.DownloadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author feidian
 * @date 2023-09-10
 */
@Service
public class Breed2ServiceImpl implements IBreed2Service
{
    @Autowired
    private Breed2Mapper breed2Mapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Breed2 selectBreed2ById(Long id)
    {
        return breed2Mapper.selectBreed2ById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param breed2 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Breed2> selectBreed2List(Breed2 breed2)
    {
        return breed2Mapper.selectBreed2List(breed2);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param breed2 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBreed2(Breed2 breed2)
    {
        breed2.setCreateTime(DateUtils.getNowDate());
        return breed2Mapper.insertBreed2(breed2);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param breed2 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBreed2(Breed2 breed2)
    {
        breed2.setUpdateTime(DateUtils.getNowDate());
        return breed2Mapper.updateBreed2(breed2);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBreed2ByIds(Long[] ids)
    {
        return breed2Mapper.deleteBreed2ByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBreed2ById(Long id)
    {
        return breed2Mapper.deleteBreed2ById(id);
    }

    @Override
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String wordUrl = breed2Mapper.getFileUrl(id);
        if (wordUrl == null || wordUrl.isEmpty()) {
            // 文件不存在，返回错误消息
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        String type = wordUrl.substring(wordUrl.lastIndexOf(".") + 1);
        File file = new File(wordUrl);
        String filename = "文档" + "." + type;
        DownloadFileUtil.downloadFile(filename, file, response, request);
    }

}
