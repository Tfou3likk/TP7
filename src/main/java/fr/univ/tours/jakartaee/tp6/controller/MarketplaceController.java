package fr.univ.tours.jakartaee.tp6.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.univ.tours.jakartaee.tp6.business.DiskToSoldService;

@Controller
public class MarketplaceController {
	
	
	DiskToSoldService diskToSoldService;
	
    public MarketplaceController(DiskToSoldService diskToSoldService) {
		super();
		this.diskToSoldService = diskToSoldService;
	}

	@GetMapping("/marketplace")
    public String marketplace(Model model) {
       
        	
		model.addAttribute("stock", diskToSoldService.listAll());
		return "marketplace";
			
		

        
    }
}
