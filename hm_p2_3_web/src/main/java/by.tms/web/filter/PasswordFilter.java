package by.tms.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(servletNames = {"RegistrationServlet", "ChangePasswordServlet"})
public class PasswordFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String password = req.getParameter("password");
        Pattern passwordPattern = Pattern.compile("^[A-Za-z\\d\\!_@%]{8,10}$");

        boolean isPasswordMatchPattern = passwordPattern.matcher(password).find();

        if (isPasswordMatchPattern) {
            chain.doFilter(req, res);
        } else {
            res.sendError(400, "Invalid password length or format. Length 8-10 letters, numbers and !_@% symbol");
        }
    }
}
