package fr.univ.tours.jakartaee.tp7.controller;

import fr.univ.tours.jakartaee.tp7.business.VinylCollectionService;
import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.entities.DiskEntity;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;
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
        UserEntity connectedUser = (UserEntity)session.getAttribute("user");
        List<DiskEntity> collection = vinylCollectionService.listCollection(connectedUser); // TODO implement this assignment with the EJB
        model.addAttribute("collection", collection);
        return"home";
    }
}
