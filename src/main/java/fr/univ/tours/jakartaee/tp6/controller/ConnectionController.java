package fr.univ.tours.jakartaee.tp6.controller;

import fr.univ.tours.jakartaee.tp6.business.ConnectionService;
import fr.univ.tours.jakartaee.tp6.business.pojo.User;



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
	
	

	@PostMapping("/login")
    public String login(Model model, @RequestParam("email") String email, HttpSession session) {
        try {
            User user = connectService.connect(email); // TODO implement this assignment with the EJB
           
            session.setAttribute("user", user);
            session.setAttribute("isLogged", true);
            return "redirect:/home";
        } catch (Exception e){
            model.addAttribute("loginFailure", true);
            return "index";
        }
    }
}