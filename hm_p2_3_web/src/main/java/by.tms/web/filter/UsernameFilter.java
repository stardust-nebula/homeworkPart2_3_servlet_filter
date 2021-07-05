package by.tms.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(servletNames = {"RegistrationServlet", "ChangeUsernameServlet"})
public class UsernameFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = req.getParameter("username");
        Pattern userNamePattern = Pattern.compile("^[A-Za-z\\d\\_]{3,15}$");

        boolean isUsernameMatchPattern = userNamePattern.matcher(username).find();

        if (isUsernameMatchPattern){
            chain.doFilter(req, res);
        }else {
            res.sendError(400, "Invalid username length or format. Length 3-15 letters, numbers and _ symbol");
        }
    }
}
