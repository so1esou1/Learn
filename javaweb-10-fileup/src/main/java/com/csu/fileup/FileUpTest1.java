package com.csu.fileup;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/*
文件上传的例子(不用记，用的时候看)
    https://blog.csdn.net/lq1759336950/article/details/87562166查看攻略

    一、文件的上传，需要下载apache的jar包才能实现:
    commons-io 、commons-fileupload

    二、文件上传的注意事项（调优方案）:
        1、为保证服务器安全，上传文件应该放在外界无法直接访问的目录下，比如放于WEB-INF目录下。
        2、为防止文件覆盖的现象发生，要为上传文件产生—个唯一的文件名
        (方案:txt、时间戳方案，都不安全，可以使用UUID、MD5加密、自己写位运算算法等方案)
        3、要限制上传文件的最大值。
        4、可以限制上传文件的类型，在收到上传文件名时，判断后缀名是否合法。

    三、需要了解4个类:
    (1)ServletFileUpload负责处理上传的文件数据,并将表单中每个输入项封装成一个(2)Fileltem对象，
    在使用ServletFileUpload对象解析请求时需要(3)DiskFileltemFactory对象。
    所以，我们需要在进行解析工作前构造好DiskFileltemFactory对象，通过ServletFileUpload对象的构造方法或
    setFileltemFactory()方法设置ServletFileUpload对象的(4)fileltemFactory属性。


 */
public class FileUpTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、判断上传的文件是普通表单还是文件表单
        if (!ServletFileUpload.isMultipartContent(req)){             //不是post请求的话就会报错
            return;         //终止方法运行，说明这是一个普通表单
        }

        String msg = "文件上传失败";
        //2、创建上传文件的保存路径，建议在WEB-INF下，用户无法直接访问上传的文件
        try {
            String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
            //判断路径上是否存在这个文件
            File uploadFile = new File(uploadPath);
            if (!uploadFile.exists()){
                //创建这个目录:
                uploadFile.mkdir();
            }
            //缓存或临时文件:
                //假如文件超于预期大小，试着把它放在一个临时文件中，过几天自动删除，或者提醒用户转存为永久
            String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
            File tmpFile = new File(tmpPath);
            if (!tmpFile.exists()){
                tmpFile.mkdir();        //创建临时目录
            }

            //使用apache的commons-fileupload实现:
            //3、创建DiskFileItemFactory对象，处理文件上传路径或者大小限制:
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //通过这个工厂设置一个缓冲区，当文件大于缓存区时，将它放到临时文件中(可写可不写，有默认值):
            factory.setSizeThreshold(1024*1024);    //缓冲区大小为1M
            factory.setRepository(tmpFile);


            //4、获取ServletFileUpload：
            ServletFileUpload upload = new ServletFileUpload(factory);
            //ServletFileUpload作用:
            // (1)监听文件上传进度:
            upload.setProgressListener(new ProgressListener() {
                @Override
                public void update(long l, long l1, int i) {    //l:以读取到的文件大小  l1:文件大小
                    System.out.println("总大小:" + l + "已上传" + l1);
                }
            });
            //(2)处理乱码问题:
            upload.setHeaderEncoding("UTF-8");
            //(3)设置单个文件的最大值:
            upload.setFileSizeMax(1024*1024*10);
            //(4)设置总共能上传文件的大小:
            upload.setSizeMax(1024*1024*10);


            //5、处理上传文件:
            //把前端请求解析，封装成一个FileItem对象,需要从ServletFileUpload对象中获取:
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem fileItem : fileItems) {       //fileItem:每一个表单对象
                //判断上传的文件是图片文件还是带文件的表单:
                if (fileItem.isFormField()){
                    //getFieldName指的是前端表单控件的name
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");     //处理乱码
                    System.out.println(name + ":" + value);
                }else {     //如果是正确的文件表单
                    //============处理文件=============
                    String uploadFileName = fileItem.getName();
                    //可能存在文件名不合法的情况:
                    if (uploadFileName.trim().equals("")|| uploadFileName==null){
                        continue;
                    }
                    //获得上传文件名:      /images/people/zhangsan.png
                    String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                    //获得文件后缀名
                    String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

                    //使用UUID(唯一识别的通用码,JDK原生)，保证文件名唯一:
                    //***网络传输的东西都需要序列化,POJO实体类记得要序列化
                    //Serializable:标记接口，JVM扫描到后做一些事情
                    String uuidPath = UUID.randomUUID().toString();

                    //============存放地址=============
                    //存到哪?uploadPath
                    //文件真实的存在路径:
                    String realPath = uploadPath + "/" + uuidPath;
                    //给每个文件创建一个对应的文件夹:
                    File realPathFile = new File(realPath);
                    if (!realPathFile.exists()){
                        realPathFile.mkdir();
                    }

                    //============文件传输=============
                    //获得文件上传的流:
                    InputStream inputStream = fileItem.getInputStream();
                    //创建一个文件输出流:
                    //realPath =  真实的文件夹
                    FileOutputStream fos = new FileOutputStream(realPath + "/" + fileName);

                    //创建一个缓冲区
                    byte[] buffer = new byte[1024*1024];

                    //判断是否读取完毕:
                    int len = 0;
                    //如果>0说明还在存数据:
                    while ((len = inputStream.read(buffer)) > -1){
                        fos.write(buffer,0,len);
                    }

                    //关闭流:
                    fos.close();
                    inputStream.close();


                    fileItem.delete();      //上传成功，清除临时文件
                    msg = "文件上传成功!";
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
