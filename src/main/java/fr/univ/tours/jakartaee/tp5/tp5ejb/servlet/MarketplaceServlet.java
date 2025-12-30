package fr.univ.tours.jakartaee.tp5.tp5ejb.servlet;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.DiskToSoldEJB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/marketplace")
public class MarketplaceServlet extends HttpServlet {
	
	@EJB
	DiskToSoldEJB diskToSoldEJB;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	
			req.setAttribute("stock", diskToSoldEJB.listAll());// TODO implement this assignment with the EJB
			req.getRequestDispatcher("/marketplace.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

        
    }
}
