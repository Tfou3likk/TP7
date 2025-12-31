package fr.univ.tours.jakartaee.tp6.servlet;

import fr.univ.tours.jakartaee.tp6.business.ConnectionService;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/signup")
public class SignupServlet extends HttpServlet {
	
	@EJB
	ConnectionService connectEJB;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = new User(req.getParameter("email"), req.getParameter("firstname"), req.getParameter("lastname"));
            // TODO implement this assignment with the EJB
            user = connectEJB.register(user);
            req.getRequestDispatcher("/login").forward(req,resp);
        } catch (Exception e){
            req.setAttribute("signupFailure", true);
            req.getRequestDispatcher("/signup.jsp").forward(req,resp);
        }
    }
}
