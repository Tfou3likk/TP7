package fr.univ.tours.jakartaee.tp7.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.univ.tours.jakartaee.tp7.business.AddDiskService;
import fr.univ.tours.jakartaee.tp7.business.VinylCollectionService;
import fr.univ.tours.jakartaee.tp7.business.pojo.Disk;
import fr.univ.tours.jakartaee.tp7.business.pojo.DiskForm;
import fr.univ.tours.jakartaee.tp7.business.pojo.User;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AddDiskController {
	
	AddDiskService addDiskService;
	
	VinylCollectionService vinylCollectionService;
	
	

	public AddDiskController(AddDiskService addDiskService, VinylCollectionService vinylCollectionService) {
		super();
		this.addDiskService = addDiskService;
		this.vinylCollectionService = vinylCollectionService;
	}

	@GetMapping("/adddisk")
	public String ajoutDiskFormulaire(Model model) {
		List<Disk> listeDisk = addDiskService.listAllDisk();
		model.addAttribute("listeDisk", listeDisk);
		model.addAttribute("diskForm", new DiskForm());
		return"adddisk";
	}
	
	@PostMapping("/adddisk")
	public String ajoutDisk(Model model, HttpSession session, @Valid@ModelAttribute("diskForm") DiskForm form, BindingResult bindingResult, @RequestParam("action")String action) {
		
		switch(action) {
			case "add" ->{
				User connectedUser = (User)session.getAttribute("user");
		        if(bindingResult.hasErrors()) {
		        	model.addAttribute("listeDisk", addDiskService.listAllDisk());
		            return "adddisk";
		        }
				vinylCollectionService.addToCollectionbyId(connectedUser, form.getIdentificationCode());
				return "redirect:/home";
			}
			case"select" ->{
				Disk disk = addDiskService.getDiskById(form.getIdentificationCode());
				DiskForm formaffiche = new DiskForm();
				if (disk != null) {
					formaffiche.setIdentificationCode(disk.identificationCode());
	                formaffiche.setAlbum(disk.album());
	                formaffiche.setArtist(disk.artist());
	            }
				model.addAttribute("diskForm", formaffiche);
				model.addAttribute("listeDisk", addDiskService.listAllDisk());
				return"adddisk";
			}
		}
		
		return "redirect:/adddisk";
	}

}
