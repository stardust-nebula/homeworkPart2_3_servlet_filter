package by.tms.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"ChangePasswordServlet", "ChangePasswordServlet", "RemoveAccountServlet"})
public class UserChangeRequestFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (req.getSession().getAttribute("user") == null){
            chain.doFilter(req, res);
        }else {
            res.sendError(400);
        }
    }
}
