import pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName SessionDemo01
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/6 23:28
 * @Version 1.0
 */
public class SessionDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //得到session
        HttpSession session = req.getSession();

        Person person = new Person("Nathan", 13);

        //给session存入东西
        session.setAttribute("name", person);

        //获取session的ID
        String id = session.getId();

        //判断session是不是新创建
        if (session.isNew()) {
            resp.getWriter().write("Session创建成功，ID:" + id);
        } else {
            resp.getWriter().write("session以及在服务器中存在了，ID" + id);
        }

    }
}
