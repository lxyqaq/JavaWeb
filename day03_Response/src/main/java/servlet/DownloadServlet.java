package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * @ClassName DownloadServlet
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/4 23:30
 * @Version 1.0
 */
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //1.获取文件下载的路径
        String realPath = this.getServletContext().getRealPath("/time.png");
        System.out.println("下载的文件路径为:" + realPath);

        //2.获取下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);

        //3.设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西,中文文件名要改编码
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        //4.获取文件的下载流
        FileInputStream in = new FileInputStream(realPath);

        //5.创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];

        //6.获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();

        //7.将FileInputStream流写入buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端
        while ((len = in.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }

        in.close();
        outputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
