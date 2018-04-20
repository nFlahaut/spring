package web.core.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Exercices {
	
	@RequestMapping(value="/ex1")
	public String post (Model model) {
		model.addAttribute("message1", "Bonjour : redirect");
		return "redirect:/test";
	}
	
	@RequestMapping(value="/ex2")
	public ModelAndView post1 (@RequestParam (value="name", required=false) String name, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("name", name);
		return new ModelAndView("redirect:/test");
	}

}
