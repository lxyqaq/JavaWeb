package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName FilterTest
 * @Description TODO
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/3/12 02:20
 * @Version 1.0
 */
public class FilterTest implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        System.out.println("过滤器执行前。。。");

        //让请求继续走，如果不写，程序到这里就别拦截停止
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("过滤器执行后。。。");

    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

}
