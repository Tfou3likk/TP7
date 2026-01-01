package fr.univ.tours.jakartaee.tp7.controller;

import fr.univ.tours.jakartaee.tp7.business.ConnectionService;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {
	
	
	ConnectionService connectService;
	
	

    public SignupController(ConnectionService connectService) {
		super();
		this.connectService = connectService;
	}

    @GetMapping("/signup")
	public String formulaireInscription() {
		return"signup";
	}

	@PostMapping("/signup")
    public String sign(Model model, @RequestParam("email") String email, @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, HttpSession session) {
        try {
            User user = new User(email, firstname, lastname);
            // TODO implement this assignment with the EJB
            user = connectService.register(user);
            
            session.setAttribute("isLogged", true);
            session.setAttribute("user", user);
            return "redirect:/home";
        } catch (Exception e){
            model.addAttribute("signupFailure", true);
            return "signup";
        }
    }
}
