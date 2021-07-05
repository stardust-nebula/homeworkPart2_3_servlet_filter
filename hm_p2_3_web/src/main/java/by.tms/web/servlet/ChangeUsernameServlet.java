package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeUsernameServlet", urlPatterns = "/change_username")
public class ChangeUsernameServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String newUsername = req.getParameter("newUsername");

        User byUsername = userService.findByUsername(username);

        if (byUsername == null) {
            resp.sendError(404, "Not found");
        }

        if (byUsername.getPassword().equals(password)) {
            userService.changeUsername(username, newUsername);
        } else {
            resp.sendError(403, "No access");
        }
    }
}
