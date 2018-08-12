package com.neuedu.action;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = {"/fileup"})
public class FileUploadServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //构建一个工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建一个请求解析器
        ServletFileUpload sfu = new ServletFileUpload(factory);
        try {
            //使用请求解析器解析请求对象并且返回所有的表单域
            List<FileItem> itemList = sfu.parseRequest(req);
            for (FileItem fileItem : itemList) {
                //判断此fileItem是否是常规表单域
                if(fileItem.isFormField()){

                    /*System.out.println(fileItem.getFieldName());
                    System.out.println(fileItem.getString());*/
                }else {
                    //文件域
                    //1.获取服务器的根路径
                    String path = req.getServletContext().getRealPath("upload/");
                    File f = new File(path);
                    if (!f.exists()){
                        f.mkdirs();
                    }
                    String filePath = path + UUID.randomUUID().toString() + fileItem.getName().substring(fileItem.getName().indexOf("."));
                    //构建上传的文件路径
                    File file = new File(filePath);
                    //执行本地文件的输出流
                    OutputStream out = new FileOutputStream(file);
                    //从服务器获取输入流
                    InputStream in = fileItem.getInputStream();
                    byte[] b = new byte[8];
                    while (in.read(b) != -1){
                        out.write(b);
                    }
                    in.close();
                    out.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

}
