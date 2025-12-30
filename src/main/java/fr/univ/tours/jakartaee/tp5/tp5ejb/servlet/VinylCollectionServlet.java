package fr.univ.tours.jakartaee.tp5.tp5ejb.servlet;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.VinylCollectionEJB;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import fr.univ.tours.jakartaee.tp5.tp5ejb.dao.VinylCollectionDAO;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class VinylCollectionServlet extends HttpServlet {

    // TODO inject here the EJB
	@EJB
	VinylCollectionEJB vinylCollectionEJB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User connectedUser = (User)req.getSession(false).getAttribute("user");
        List<Disk> collection = vinylCollectionEJB.listCollection(connectedUser); // TODO implement this assignment with the EJB
        req.setAttribute("collection", collection);
        req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }
}
