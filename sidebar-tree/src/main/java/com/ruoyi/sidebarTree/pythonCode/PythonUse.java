package com.ruoyi.sidebarTree.pythonCode;

import com.ruoyi.sidebarTree.domain.Breed;
import com.ruoyi.sidebarTree.domain.Breed2;
import com.ruoyi.sidebarTree.mapper.Breed2Mapper;
import com.ruoyi.sidebarTree.service.IGenotypeFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//import static com.ruoyi.common.utils.SecurityUtils.getUserId;
//import static com.ruoyi.common.utils.SecurityUtils.getUsername;
import static com.ruoyi.sidebarTree.pythonCode.UseParam.pythonCodeDict;
import static com.ruoyi.sidebarTree.pythonCode.UseParam.pythonEvn;

/**
 * Author jia wei
 * Date 2022/8/8 9:46
 */
@Component
public class PythonUse {

    @Autowired
    private Breed2Mapper breed2Mapper;

    public static String generatePDF(Breed breed) {

        if(breed.equals(null)){
            return null;
        }
        //调用方法
        return "";
    }

    /**
     * 苗盘超绿检测，使用的是checkGreen.py文件
     *
     * @param fileUrl 检测图片的url
     */
    public void checkGreen(String fileUrl) {
        File file = new File(fileUrl);
        String filePath = file.getParent();

        String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
        try {
            String[] args1 = new String[]{pythonEvn, pythonCodeDict+"\\checkGreen.py", filePath, fileName};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 苗盘穴孔检测
     *
     * @param fileUrl 检测图片的url
     */
    public void checkHole(String fileUrl) {
        File file = new File(fileUrl);
        String filePath = file.getParent();
        String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
        System.out.println("fileName"+fileName);
        try {
            String[] args1 = new String[]{pythonEvn, pythonCodeDict+"\\CheckHole.py", filePath, fileName};
            for(String str : args1) System.out.print(str+" ");
            System.out.println();
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cleanFile(File file){
        File[] list = file.listFiles();
        if(list.length==0){//如果长度为零则删除
            file.delete();
        }
        else{
            for (File childrenfile:list) {
                if(childrenfile.isDirectory())
                    cleanFile(childrenfile);//递归
                else
                    childrenfile.delete();//删除其他类型文件
                }
            }
        file.delete();
    }


    /**
     * 生长点预测
     * @param fileUrl
     * @return 图片链接
     */
    public String predictGrowPoint(String fileUrl,long treeId) {
        //这方法相较比较特殊，生成的图片到特定的文件夹中，因此处理前，先把文件夹清空
        File parentFile =new File("C:\\Users\\Administrator\\Desktop\\YOLOX-growpoint\\YOLOX_outputs\\yolox_voc_s\\vis_res");
        cleanFile(parentFile);
        parentFile.mkdirs();
        File file = new File(fileUrl);

        try {
            String[] args1 = new String[]{pythonEvn,
                    "demo.py",
                    "--path",
                    fileUrl
                    };
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            System.out.println("begin");
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        StringBuffer reslutUrl=new StringBuffer("");
        File path=new File("C:\\Users\\Administrator\\Desktop\\YOLOX-growpoint\\YOLOX_outputs\\yolox_voc_s\\vis_res");
        //列出该目录下所有文件和文件夹
        reslutUrl.append(path.getAbsoluteFile());
        File[] files = path.listFiles();
        //按照目录中文件最后修改日期实现倒序排序
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                return (int)(file2.lastModified()-file1.lastModified());
            }
        });
        //取最新修改的文件，get文件名
        if(files.length==0) return null;
        parentFile = files[0];
        parentFile.renameTo(new File("C:\\Users\\Administrator\\Desktop\\YOLOX-growpoint\\YOLOX_outputs\\yolox_voc_s\\vis_res\\"+treeId));
        reslutUrl.append("\\"+treeId);
        File newFile =new File(reslutUrl.toString());
        File[] files1 = newFile.listFiles();
        for(File f:files1){
            if(f.getName().contains(".jpg")||f.getName().contains(".png"))
                reslutUrl.append("\\"+f.getName());
        }
        return reslutUrl.toString();
    }

    /**
     * 叶片检测
     *
     * @param fileUrl 需要检测的图片文件地址
     */
    public int detectLeaf(String fileUrl) {
        File file = new File(fileUrl);
        String filePath = file.getParent();
        String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
        File file1 = new File(filePath);
        if(!file1.exists()) return 0;
        try {
            String[] args1 = new String[]{pythonEvn,  pythonCodeDict+ "\\DetectLeaf.py", filePath, fileName, filePath};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e){

            return 0;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return 1;
    }

//    /**
//     * 生长预测，用来对csv文件进行预测
//     *
//     * @param fileUrl csv文件所在的文件地址
//     * @return
//     */
    public void predictGrow(long fileName) {

        try {
            String fileDictory ="C:\\ruoyi\\uploadPath\\predictGrowPoint\\result";
            String predictFile="C:\\ruoyi\\uploadPath\\predictGrowPoint\\predict\\"+fileName+"\\predict.csv";
            String[] args1 = new String[]{pythonEvn,  "C:\\SeedlinManagement\\pythonCode\\LSTM_predict.py",
                    fileDictory, fileName+"", predictFile};
            Process proc = null;// 执行py文件
            proc = Runtime.getRuntime().exec(args1);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
//            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Autowired
    private IGenotypeFileService genotypeFileService;

    /**
     * PCA分析，使用的是01_vcf2csv.py和02_PCA.py文件
     */
    public void usePCA(String fileId) {
        try {
            String url = genotypeFileService.selectFileNameByFileId(fileId);//文件名实际是url最后一段
            String inurl[] = url.split("\\\\");
            String fileName = inurl[5];
            System.out.println(fileName);//csv用id避免改名和重复问题，但一开始找vcf文件要用文件名
            String[] args1 = new String[]{pythonEvn, pythonCodeDict+"\\01_vcf2csv.py", fileName,fileId};
//            String[] args1 = new String[]{"C:\\Users\\温镜蓉\\AppData\\Local\\Programs\\Python\\Python39\\python.exe", "D:\\yuzhong\\01_vcf2csv.py", fileName,fileId};
            Process proc1 = Runtime.getRuntime().exec(args1);// 执行py文件

            BufferedReader in1 = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
            System.out.println("begin1");
            String line;
            while ((line = in1.readLine()) != null) {
                System.out.println(line);
            }
            in1.close();
            proc1.waitFor();
            System.out.println("end1");

            String[] args2 = new String[]{pythonEvn, pythonCodeDict+"\\02_PCA.py", fileId};
//            String[] args2 = new String[]{"C:\\Users\\温镜蓉\\AppData\\Local\\Programs\\Python\\Python39\\python.exe", "D:\\yuzhong\\02_PCA.py", fileId};
            Process proc2 = Runtime.getRuntime().exec(args2);// 执行py文件

            BufferedReader in2 = new BufferedReader(new InputStreamReader(proc2.getInputStream()));
            System.out.println("begin2");
            while ((line = in2.readLine()) != null) {
                System.out.println(line);
            }
            in2.close();
            proc2.waitFor();
            System.out.println("end2");
        } catch (IOException | NullPointerException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    //将上传的vcf转换为CSV另外存储
    public void transToCSV(String url) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String command[] = new String[]{
                            "python",
                            "C:\\Users\\Administrator\\Desktop\\sdxx\\xm_2_1\\6210\\phe_platform\\code\\csv_add.py",
                            "--input",
                            url
                    };


                    for (String i : command) System.out.println(i);
                    // 创建ProcessBuilder对象来运行第一个Python脚本
                    ProcessBuilder processBuilder1 = new ProcessBuilder(
                            command
                    );

                    Process process = processBuilder1.start();

                    // 读取Python脚本的输出
                    BufferedReader reader1 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line1;
                    while ((line1 = reader1.readLine()) != null) {
                        System.out.println(line1);
                    }

                    // 等待完成
                    int exitCode1 = process.waitFor();
                    System.out.println("csv_add的退出代码：" + exitCode1);

                    if(exitCode1 != 0){
                        throw new Exception("csv_add处理vcf异常");
                    }
                } catch (Exception e) {
                    System.out.println("csv_add处理vcf异常");
                    e.printStackTrace();
                }
            }
        };
        threadPoolTaskExecutor.execute(task);
    }

    //获取处理后的CSV
    public void getCSV(String param,String flag, String gfUrl, String cyUrl, Breed2 breed2) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                StringBuilder msg = new StringBuilder();//记录执行信息
                long id = breed2.getId();
                String gfSavepath =  "C:\\Users\\Administrator\\Desktop\\sdxx\\xm_2_1\\6210\\jieguo\\csv0\\" + id +"\\"+ "gf.csv";
                String cySavepath =  "C:\\Users\\Administrator\\Desktop\\sdxx\\xm_2_1\\6210\\jieguo\\csv0\\" + id +"\\"+ "cy.csv";
                String txtSavepath = "C:\\Users\\Administrator\\Desktop\\sdxx\\xm_2_1\\6210\\jieguo\\csv0\\" + id + "\\"+"record.txt";

                String taskId = String.valueOf(breed2.getId());

                try {

                        String command[] = new String[]{
                                "python",
                                "C:\\Users\\Administrator\\Desktop\\sdxx\\xm_2_1\\6210\\phe_platform\\code\\main.py",
                                "--taskID",
                                taskId,
                                "--input",
                                param.length() == 0 ? "0" : param,
                                "--flag",
                                flag,
                                "--inputGf",
                                gfUrl.length() == 0 ? "0" : gfUrl,
                                "--inputCy",
                                cyUrl.length() == 0 ? "0" : cyUrl,
                                "--gfSavepath",
                                gfSavepath,
                                "--cySavepath",
                                cySavepath,
                                "--txtSavepath",
                                txtSavepath
                        };


                    for (String i : command) System.out.println(i);
                    // 创建ProcessBuilder对象来运行第一个Python脚本
                    ProcessBuilder processBuilder1 = new ProcessBuilder(
                            command
                    );

                    Process process1 = processBuilder1.start();

                    // 读取Python脚本的输出
                    BufferedReader reader1 = new BufferedReader(new InputStreamReader(process1.getInputStream()));
                    String line1;
                    while ((line1 = reader1.readLine()) != null) {
                        System.out.println(line1);
                        msg.append(line1);
                    }
                    System.out.println("执行信息msg:"+msg);

                    // 等待第一个进程完成
                    int exitCode1 = process1.waitFor();
                    System.out.println("wc_main函数的退出代码：" + exitCode1);

                    if(exitCode1 != 0){
                        throw new Exception("wc_main函数处理csv异常");
                    }

                    //传入之前的getPDF2方法进行预测
                    System.out.println("处理完毕，开始调用getPDF2进行预测...");
                    getPDF2(gfSavepath,cySavepath,txtSavepath,msg.toString(),breed2);
                } catch (Exception e) {
                    System.out.println("wc_main函数处理异常");
                    e.printStackTrace();
                    breed2.setInfo(msg.toString());
                    breed2.setStatus(2);
                    breed2Mapper.updateBreed2(breed2);
                }
            }
        };
        threadPoolTaskExecutor.execute(task);
    }

    //
    public void getPDF2(String gfPath,String cyPath,String txtPath,String msg, Breed2 breed2) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                /* Integer count = breed2Mapper.selectMaxId();
                Integer id = null;
                if(StringUtils.isNull(count)) id = 1;
                else  id = count+1;

                Breed2 breed2 = new Breed2();
                breed2.setId(Long.valueOf(id));
                breed2.setStatus(0);
                breed2.setCreateBy(username);
                breed2.setCreateTime(new Date());*/
                long id = breed2.getId();
                String savepath = "C:\\Users\\Administrator\\Desktop\\sdxx\\xm_2_1\\6210\\jieguo\\csv\\" + id + ".csv";
                //-------------------------------------predict.py------------------------------------------------
                try {
                        String command1[] = new String[]{
                                "python",
                                "C:\\Users\\Administrator\\Desktop\\sdxx\\xm_2_1\\6210\\predict.py",
                                "--cyPath",
                                cyPath,
                                "--txtPath",
                                txtPath,
                                "--savepath",
                                savepath
                        };
                    for (String i : command1) System.out.println(i);
                    // 创建ProcessBuilder对象来运行第一个Python脚本
                    ProcessBuilder processBuilder1 = new ProcessBuilder(
                            command1
                    );

                    Process process1 = processBuilder1.start();

                    // 读取Python脚本的输出
                    BufferedReader reader1 = new BufferedReader(new InputStreamReader(process1.getInputStream()));
                    String line1;
                    while ((line1 = reader1.readLine()) != null) {
                        System.out.println(line1);
                    }

                    // 等待第一个进程完成
                    int exitCode1 = process1.waitFor();
                    System.out.println("predict.py的退出状态码：" + exitCode1);
                    if(exitCode1 != 0) {
                        throw new Exception("predict.py业务异常");
                    }

//--------------------------------------------------------------pdf.py-------------------------------------------
                           String command2[] = new String[]{
                                   "python",
                                   "C:/Users/Administrator/Desktop/sdxx/xm_2_1/6210/pdf.py",
                                   "--gfPath",
                                   gfPath,
                                   "--txtPath",
                                   txtPath,
                                   "--csvpath",
                                   savepath,
                                   "--pdfname",
                                   "C:/Users/Administrator/Desktop/sdxx/xm_2_1/6210/jieguo/pdf/" + id + ".pdf"
                           };


                    Thread.sleep(3000);

                    for (String i : command2) System.out.println(i);

                    // 创建ProcessBuilder对象来运行第二个Python脚本
                    ProcessBuilder processBuilder2 = new ProcessBuilder(
                            command2
                    );

                    // 设置工作目录（如果有必要）
                    // processBuilder2.directory(new File("E:/word/yuzhong/xm_2/xm_2/"));

                    Process process2 = processBuilder2.start();
                    // 读取Python脚本的输出
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
                    String line2;
                    while ((line2 = reader2.readLine()) != null) {
                        System.out.println(line2);
                    }

                    // 等待第二个进程完成
                    int exitCode2 = process2.waitFor();
                    System.out.println("pdf.py的退出状态码：" + exitCode2);
                    if(exitCode2 != 0){
                        throw new Exception("pdf.py业务异常");
                    }
                    breed2.setStatus(1);
                    breed2.setInfo(msg);
                    breed2.setPdfpath("C:\\Users\\Administrator\\Desktop\\sdxx\\xm_2_1\\6210\\jieguo\\pdf\\" + id + ".pdf");
                } catch (Exception e) {
                    e.printStackTrace();
                    breed2.setStatus(2);
                    breed2.setInfo(msg);
                }finally {
                    breed2Mapper.updateBreed2(breed2);
                }
            }
        };
        threadPoolTaskExecutor.execute(task);
    }
}
