package com.ruoyi.sidebarTree.utils;



import com.ruoyi.sidebarTree.exception.Campuso2oException;
import org.apache.commons.lang3.StringUtils;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Description: 下载文件的工具类
 * @Author: Mark
 * @CreateDate: 2019/2/23 16:29
 * @Version: 2.0
 * @Copyright : 豆浆油条个人非正式工作室
 */
public class DownloadFileUtil {

    /**
     * 下载文件
     * @param originalFileName ：下载文件的原始文件名
     * @param file             ：下载的文件
     * @param response         ：相应对象
     */
    public static void downloadFile(String originalFileName, File file, HttpServletResponse response, HttpServletRequest request) {
        // 数据校验
        checkParam(originalFileName,file);

        //相应头的处理
        //清空response中的输出流
        response.reset();
        //设置文件大小
        response.setContentLength((int) file.length());
        //设置Content-Type头
        response.setContentType("application/octet-stream;charset=UTF-8");
        //设置Content-Disposition头 以附件形式解析
        String encodedFilename = getEncodedFilename(request, originalFileName);
        response.addHeader("Content-Disposition", "attachment;filename=" + encodedFilename);

        //将来文件流写入response中
        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
            //获取文件输入流
            fileInputStream = new FileInputStream(file);
            //创建数据缓冲区
            byte[] buffers = new byte[1024];
            //通过response中获取ServletOutputStream输出流
            outputStream = response.getOutputStream();
            int length;
            while ((length = fileInputStream.read(buffers)) > 0) {
                //写入到输出流中
                outputStream.write(buffers, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *图片的预览
     */
    public String viewPicture(HttpServletResponse response,String filePath) {

        String format = filePath.substring(filePath.lastIndexOf(".") + 1);
        File file = new File( filePath);
        try {

            if (file.exists() && file.isFile()) {
                //读取图片文件流
                BufferedImage image = ImageIO.read(new FileInputStream(file));
                //将图片写到输出流
                ImageIO.write(image, format, response.getOutputStream());
                return null;
            } else {
                return "文件不存在";
            }

        } catch (IOException e) {
            return "预览失败";
        }

    }



    /**
     * 下载文件的参数的校验，如果参数不合法则抛出自定义异常
     * @param originalFileName ：文件原始文件名
     * @param file ：待下载的文件
     */
    private static void checkParam(String originalFileName, File file) {
        if(StringUtils.isBlank(originalFileName)){
            throw new Campuso2oException("输入的文件原始文件名为空");
        }
        if(file == null || !file.exists() ){
            throw new Campuso2oException("待在下载的文件不存在！");
        }
    }

    /**
     * 获取URL编码后的原始文件名
     * @param request ：客户端请求
     * @param originalFileName ：原始文件名
     * @return ：
     */
    private static String getEncodedFilename(HttpServletRequest request, String originalFileName) {
        String encodedFilename = null;
        String agent = request.getHeader("User-Agent");
        if(agent.contains("MSIE")){
            //IE浏览器
            try {
                encodedFilename = URLEncoder.encode(originalFileName, "utf-8");
                encodedFilename = encodedFilename.replace("+", " ");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else if(agent.contains("Firefox")){
            //火狐浏览器
            Base64.Encoder encoder = Base64.getEncoder();
            try {
                encodedFilename = "=?utf-8?B?" + encoder.encodeToString(encodedFilename.getBytes("utf-8")) + "?=";
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
            //其他浏览器
            try {
                encodedFilename = URLEncoder.encode(originalFileName, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return encodedFilename;
    }
}


