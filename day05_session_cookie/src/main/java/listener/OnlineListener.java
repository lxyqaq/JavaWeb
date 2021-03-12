package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName OnlineListener
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/12 15:20
 * @Version 1.0
 */
//统计session，统计网站在线人数
public class OnlineListener implements HttpSessionListener {

    //一旦创建Session就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent se) {

        ServletContext context = se.getSession().getServletContext();

        System.out.println(se.getSession().getId());

        Integer count = (Integer) context.getAttribute("count");

        if (count == null) {
            count = new Integer(1);
        } else {
            int num = count.intValue();
            count = new Integer(num + 1);
        }

        context.setAttribute("count", count);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

}
