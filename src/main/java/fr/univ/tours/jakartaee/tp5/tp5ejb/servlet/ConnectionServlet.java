package fr.univ.tours.jakartaee.tp5.tp5ejb.servlet;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.ConnectionEJB;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.UserDao;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class ConnectionServlet extends HttpServlet {

    // TODO inject here the EJB
	@EJB
	ConnectionEJB connectEJB;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            String email = req.getParameter("email");
            User user = connectEJB.connect(email); // TODO implement this assignment with the EJB
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("isLogged", true);
            resp.sendRedirect(req.getContextPath() + "/home");
        } catch (Exception e){
            req.setAttribute("loginFailure", true);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}