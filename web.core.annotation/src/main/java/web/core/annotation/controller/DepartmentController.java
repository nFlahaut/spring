package web.core.annotation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.core.annotation.entity.Department;
import web.core.annotation.service.DepartmentService;
import web.core.annotation.validator.DepartmentValidator;

@SuppressWarnings("unused")
@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	@Autowired
	private DepartmentValidator departmentValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(departmentValidator);
	}
	
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public String showForm(Model model) {
		Department department = new Department();
		return this.formDepartment(model, department);
	}
	
	public String formDepartment(Model model, Department department) {
		model.addAttribute("department", department);
		if (department.getDeptId() == null) {
			model.addAttribute("titre", "Create new Department");
		} else
			model.addAttribute("titre", "Update department");
		return "formulaireDepartment";
	}
	
	//If ..., then Update / Else, then Save => fonctionne bien
//	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
//	public String addDepartment(@Validated @ModelAttribute("department") Department department, BindingResult result) throws Exception {
//		if (result.hasErrors()) {
//	         return "formulaireDepartment";
//	      }
//		Integer deptId = department.getDeptId();
//		if (deptId != null) {
//			Department dept = service.getDeptById(deptId);
//			if (dept != null) {
//				service.updateDept(department);
//				} else
//				service.saveDept(department);
//		return "redirect:/departmentTable";
//		} 
//		return "redirect:/departmentTable";
//	}
	
	//SaveOrUpdate => fonctionne bien
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public String addDepartment(@Validated @ModelAttribute("department") Department department, BindingResult result) throws Exception {
		if (result.hasErrors()) {
	         return "formulaireDepartment";
	      }
		service.saveOrUpdateDept(department);
		return "redirect:/departmentTable";
	}
	
	@RequestMapping("/editDept")
	public String editDepartment(Model model, @RequestParam(value="id", required = true) Integer id) throws SQLException {
		Department department = null;
		if (id != null) {
			department = service.getDeptById(id);
		} else
			return "redirect:/departmentTable";
		return formDepartment(model, department);
	}
	
	@RequestMapping(value="/deleteDepartment")
	public ModelAndView deleteDepartment(@RequestParam (value="id", required=true) int id, RedirectAttributes redirectAttributes) throws SQLException {
		redirectAttributes.addFlashAttribute("id", id);
		service.deleteDept(service.getDeptById(id));
		return new ModelAndView("redirect:/departmentTable");
	}
	
	@RequestMapping(value = "/departmentTable", method = RequestMethod.GET)
	public ModelAndView showDepartmentTable(Model model) throws IOException {
		List<Object> list = service.getAllDept();
		model.addAttribute("listDepartment", list);
		return new ModelAndView("tableauDepartment", "departmentTable", list);
	}
	
}
