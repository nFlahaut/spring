package web.core.annotation.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.core.annotation.entity.User;
import web.core.annotation.service.RoleService;
import web.core.annotation.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	RoleService serviceRole;
	
	@RequestMapping(value = "/userTable", method = RequestMethod.GET)
	public ModelAndView showUserTable(Model model) throws IOException {
		List<Object> list = service.getAllUser();
		model.addAttribute("listUser", list);
		return new ModelAndView("tableauUser", "userTable", list);
	}
	
	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public String showForm(Model model) throws IOException {
		User user = new User();
		return this.formUser(model, user);
	}
	
	public String formUser(Model model, User user) throws IOException {
		model.addAttribute("user", user);
		
		List<Object> listRole = listRole();
	    model.addAttribute("listRole", listRole);
	    
		if (user.getUserId() == null) {
			model.addAttribute("titre", "Create new User");
		} else
			model.addAttribute("titre", "Update User");
		return "formulaireUser";
	}
	
	private List<Object> listRole() throws IOException {
		List<Object> list = serviceRole.getAllRole();
		return list;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@Validated @ModelAttribute("newuser") User user, BindingResult result) throws Exception {
		if (result.hasErrors()) {
	         return "formulaireUser";
	      }
		service.saveOrUpdateUser(user);
		return "redirect:/userTable";
	}
	
	@RequestMapping("/editUser")
	public String editEmployee(Model model, @RequestParam(value="id", required = true) Integer id) throws SQLException, IOException {
		User user = null;
		if (id != null) {
			user = service.getUserById(id);
		} else
			return "redirect:/userTable";
		return formUser(model, user);
	}
	
	@RequestMapping(value="/deleteUser")
	public ModelAndView deleteEmployee(@RequestParam (value="id", required=true) Integer id, RedirectAttributes redirectAttributes) throws SQLException {
		redirectAttributes.addFlashAttribute("id", id);
		service.deleteUser(service.getUserById(id));
		return new ModelAndView("redirect:/userTable");
	}

}
