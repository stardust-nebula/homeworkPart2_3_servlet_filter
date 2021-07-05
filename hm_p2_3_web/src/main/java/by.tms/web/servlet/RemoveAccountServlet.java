package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.storage.OperationStorage;
import by.tms.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveAccountServlet", urlPatterns = "/remove_account")
public class RemoveAccountServlet extends HttpServlet {

    private final UserService userService = new UserService();
    private final UserStorage userStorage = new UserStorage();
    private final OperationStorage operationStorage = new OperationStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean deleteAccount = false;

        if (userStorage.existByUsername(username)) {
            operationStorage.deleteOperationByUser(userService.findByUsername(username));
            deleteAccount = userService.deleteAccount(username, password);
        } else {
            resp.sendError(403, "No access");
        }

        if (deleteAccount) {
            resp.getWriter().print("The Account is removed");
        } else {
            resp.getWriter().print("Error");
        }
    }
}
