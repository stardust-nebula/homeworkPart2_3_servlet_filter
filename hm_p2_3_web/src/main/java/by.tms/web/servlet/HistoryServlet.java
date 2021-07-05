package by.tms.web.servlet;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalcService;
import by.tms.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HistoryServlet", urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {

    private CalcService calcService = new CalcService();
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        User byUsername = userService.findByUsername(username);
       //  User sessionByUser = req.getSession().getAttribute("user");
        User userSession = (User) req.getSession().getAttribute("user");


        List<Operation> allByUsername = calcService.findAllByUsername(userSession);

        for (Operation operation: allByUsername){
            resp.getWriter().print(operation);
        }
    }
}
