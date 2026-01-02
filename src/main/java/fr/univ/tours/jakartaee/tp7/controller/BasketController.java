package fr.univ.tours.jakartaee.tp7.controller;

import fr.univ.tours.jakartaee.tp7.business.BasketService;
import fr.univ.tours.jakartaee.tp7.business.pojo.DiskToSold;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.entities.DiskToSoldEntity;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;
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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasketController{
	
	private BasketService basketService;
	
	public BasketController(BasketService basketService) {
		super();
		this.basketService = basketService;
	}

	@GetMapping("/basket")
    public String affichagePanier(Model model){
        Collection<DiskToSoldEntity> currentBasket;
		
			
        currentBasket = basketService.getBasketDetail(); 
		model.addAttribute("basket", currentBasket);
		return"basket";
		     
		
    }

	@PostMapping("/basket")
    public String actionPanier(HttpSession session, Model model, @RequestParam(value = "diskReference", required = false)String diskReference, @RequestParam("action")String basketAction ){

        boolean submitSuccess = false;
        switch (basketAction) {
            case "add" -> {
            	basketService.addToBasket(diskReference);
            	return"redirect:/marketplace";
            } // TODO implement this assignment with the EJB
            case "remove" -> {
            	basketService.removeFromBasket(diskReference);
            	return"redirect:/marketplace";
            } // TODO implement this assignment with the EJB
            case "submit" -> {
            	UserEntity buyer = (UserEntity) session.getAttribute("user");
				submitSuccess = basketService.makeOrder(buyer);
				if (submitSuccess) {
	                return"redirect:/home";
	            } else {
	                model.addAttribute("submitFailure", true);
	                model.addAttribute("basket", basketService.getBasketDetail());
	                return"basket";
	            }
	            
		    } 
            default -> throw new IllegalArgumentException("Unknown action: " + basketAction);
        }
        
       
            
        
	}

}
