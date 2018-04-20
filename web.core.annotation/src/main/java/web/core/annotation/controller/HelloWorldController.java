package web.core.annotation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("unused")
@Controller
public class HelloWorldController {

	@RequestMapping("/test")
	public String hello(Model model) {
		model.addAttribute("message1", "Bonjour SpringMVC");
		return "exemple";
	}
	
	@RequestMapping("/test1")
	public String hello1(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("message1", "Bonjour SpringMVC : request");
		return "exemple";
	}
	
	@RequestMapping("/index")
	public String goToIndex() {
		return "index";
	}

	@RequestMapping("/testMaV")
	public ModelAndView list1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "Bonjour");
		map.put("2", "Hello");
		// List<String> map = new ArrayList<String>();
		// map.add("Bonjour");
		// map.add("Hello");
		request.setAttribute("liste", map);
		return new ModelAndView("exemple");
	}

	@RequestMapping("/testMaV2")
	public ModelAndView list2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "Bonjour");
		map.put("2", "Hello");
		ModelAndView mav = new ModelAndView("exemple");
		mav.addObject("liste", map);
		return mav;
	}

	@RequestMapping("/accueil")
	public String handler(@RequestParam(value = "name", required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "exemple";
	}

//	@RequestMapping(value = "/addUtilisateur", method = RequestMethod.POST)
//	public String addUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur, BindingResult result,
//			ModelMap model) {
//		if (result.hasErrors()) {
//			return "errorUser";
//		}
//		model.addAttribute("name", utilisateur.getName());
//		return "utilisateurView";
//	}
//	
//	@RequestMapping(value = "/addUtilisateur", method = RequestMethod.POST)
//	public String addUtilisateur(@ModelAttribute("utilisateur") HttpServletRequest request, HttpServletResponse response) throws Exception {
//		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
//		EmployeeController controller = (EmployeeController) ctx.getBean("userController");
//    	Employee user = controller.getById(7938L);
//		if (user == null) {
//			return "errorUser";
//		} else
//		request.setAttribute("name", user.getEmpName());
//    	ctx.close();
//		return "utilisateurView";
//	}
	
	

}
