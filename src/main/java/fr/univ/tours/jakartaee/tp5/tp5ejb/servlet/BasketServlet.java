package fr.univ.tours.jakartaee.tp5.tp5ejb.servlet;

import fr.univ.tours.jakartaee.tp5.tp5ejb.business.BasketEJB;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp5.tp5ejb.business.pojo.User;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;
import javax.naming.NamingException;

@WebServlet(urlPatterns = "/basket")
public class BasketServlet extends HttpServlet {
	
	
	
	
	private BasketEJB getBasketEJB(HttpServletRequest req) {
		BasketEJB basketEJB = (BasketEJB) req.getSession().getAttribute("BasketEJB");
		try {
		if (basketEJB == null) {
		InitialContext ctx = new InitialContext();
		basketEJB = (BasketEJB) ctx.lookup("java:module/BasketEJB");
		req.getSession().setAttribute("BasketEJB", basketEJB);
		}
		} catch (NamingException e) {
		throw new RuntimeException(e);
		}
		return (BasketEJB) basketEJB;
	}
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<DiskToSold> currentBasket;
		try {
			
			currentBasket = getBasketEJB(req).getBasketDetail(); // TODO implement this assignment with the EJB
			 req.setAttribute("basket", currentBasket);
		     req.getRequestDispatcher("/basket.jsp").forward(req,resp);
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // TODO implement this assignment with the EJB
       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String diskReference = req.getParameter("diskReference");
        String basketAction = req.getParameter("action");
        boolean submitSuccess = false;
        switch (basketAction) {
            case "add" -> {
            	getBasketEJB(req).addToBasket(diskReference);
            } // TODO implement this assignment with the EJB
            case "remove" -> {
            	getBasketEJB(req).removeFromBasket(diskReference);
            } // TODO implement this assignment with the EJB
            case "submit" -> {
            	HttpSession session = req.getSession(false);
            	User buyer = (User) session.getAttribute("user");
            	try {
					submitSuccess = getBasketEJB(req).makeOrder(buyer);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            } // TODO implement this assignment with the EJB
            default -> throw new IllegalArgumentException("Unknown action: " + basketAction);
        }

        if("submit".equals(basketAction)){
            if (submitSuccess) {
                resp.sendRedirect(req.getContextPath() + "/home");
            } else {
                req.setAttribute("submitFailure", true);
                doGet(req, resp);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/marketplace");
        }
    }

}
