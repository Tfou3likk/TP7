package fr.univ.tours.jakartaee.tp6.servlet;

import fr.univ.tours.jakartaee.tp6.business.VinylCollectionService;
import fr.univ.tours.jakartaee.tp6.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;
import fr.univ.tours.jakartaee.tp6.dao.VinylCollectionDAO;
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
	VinylCollectionService vinylCollectionService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User connectedUser = (User)req.getSession(false).getAttribute("user");
        List<Disk> collection = vinylCollectionService.listCollection(connectedUser); // TODO implement this assignment with the EJB
        req.setAttribute("collection", collection);
        req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }
}
