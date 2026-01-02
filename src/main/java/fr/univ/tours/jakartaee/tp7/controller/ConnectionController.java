package fr.univ.tours.jakartaee.tp7.controller;

import fr.univ.tours.jakartaee.tp7.business.ConnectionService;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import fr.univ.tours.jakartaee.tp7.entities.UserEntity;
import jakarta.servlet.http.HttpSession;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConnectionController{

    
	
	private ConnectionService connectService;
	
	public ConnectionController(ConnectionService connectService) {
		super();
		this.connectService = connectService;
	}
	
	@GetMapping({"/", "/login"})
	public String formulaireConnection() {
		return"index";
	}
	

	@PostMapping("/login")
    public String login(Model model, @RequestParam("email") String email, HttpSession session) {
        try {
            UserEntity user = connectService.connect(email); // TODO implement this assignment with the EJB
           
            session.setAttribute("user", user);
            session.setAttribute("isLogged", true);
            return "redirect:/home";
        } catch (Exception e){
            model.addAttribute("loginFailure", true);
            return "index";
        }
    }
}