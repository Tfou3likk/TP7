package fr.univ.tours.jakartaee.tp6.controller;

import fr.univ.tours.jakartaee.tp6.business.ConnectionService;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {
	
	
	ConnectionService connectService;
	
	

    public SignupController(ConnectionService connectService) {
		super();
		this.connectService = connectService;
	}



	@PostMapping("/signup")
    public String sign(Model model, @RequestParam("email") String email, @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        try {
            User user = new User(email, firstname, lastname);
            // TODO implement this assignment with the EJB
            user = connectService.register(user);
            return "redirect:/home";
        } catch (Exception e){
            model.addAttribute("signupFailure", true);
            return "signup";
        }
    }
}
