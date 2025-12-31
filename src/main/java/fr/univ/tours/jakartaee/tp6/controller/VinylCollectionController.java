package fr.univ.tours.jakartaee.tp6.controller;

import fr.univ.tours.jakartaee.tp6.business.VinylCollectionService;
import fr.univ.tours.jakartaee.tp6.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;
import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VinylCollectionController {

   
	
	VinylCollectionService vinylCollectionService;
	
	

    public VinylCollectionController(VinylCollectionService vinylCollectionService) {
		super();
		this.vinylCollectionService = vinylCollectionService;
	}



	@GetMapping("/home")
    public String home(Model model, HttpSession session){
        User connectedUser = (User)session.getAttribute("user");
        List<Disk> collection = vinylCollectionService.listCollection(connectedUser); // TODO implement this assignment with the EJB
        model.addAttribute("collection", collection);
        return"home";
    }
}
