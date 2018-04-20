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
import web.core.annotation.dao.IEmployeeDAO;
import web.core.annotation.entity.Employee;
import web.core.annotation.service.DepartmentService;
import web.core.annotation.service.EmployeeService;
import web.core.annotation.validator.EmployeeValidator;

@SuppressWarnings("unused")
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	DepartmentService serviceDept;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(employeeValidator);
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String showForm(Model model) throws IOException {
		Employee employee = new Employee();
		return this.formEmployee(model, employee);
	}
	
	public String formEmployee(Model model, Employee employee) throws IOException {
		model.addAttribute("employee", employee);
		
		List<Object> listDept = listDept();
	    model.addAttribute("listDept", listDept);
	    
		if (employee.getEmpId() == null) {
			model.addAttribute("titre", "Create new Employee");
		} else
			model.addAttribute("titre", "Update employee");
		return "formulaireEmployee";
	}
	
	private List<Object> listDept() throws IOException {
		List<Object> list = serviceDept.getAllDept();
		return list;
	}
	
//	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
//	public String addEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult result) throws Exception {
//		if (result.hasErrors()) {
//	         return "formulaireEmployee";
//	      }
//		if (employee.getEmpId() == null) {
//			service.saveEmp(employee);
//		} else 
//			service.updateEmp(employee);
//		return "redirect:/employeeTable";
//	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult result) throws Exception {
		if (result.hasErrors()) {
	         return "formulaireEmployee";
	      }
		service.saveOrUpdateEmp(employee);
		return "redirect:/employeeTable";
	}
	
	@RequestMapping("/editEmp")
	public String editEmployee(Model model, @RequestParam(value="id", required = true) Long id) throws SQLException, IOException {
		Employee employee = null;
		if (id != null) {
			employee = service.getById(id);
		} else
			return "redirect:/employeeTable";
		return formEmployee(model, employee);
	}
	
	@RequestMapping(value="/deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam (value="id", required=true) Long id, RedirectAttributes redirectAttributes) throws SQLException {
		redirectAttributes.addFlashAttribute("id", id);
		service.deleteEmp(service.getById(id));
		return new ModelAndView("redirect:/employeeTable");
	}
	
	@RequestMapping(value = "/employeeTable", method = RequestMethod.GET)
	public ModelAndView showEmployeeTable(Model model) throws IOException {
		List<Object> list = service.getAllEmp();
		model.addAttribute("listEmployee", list);
		return new ModelAndView("tableauEmployee", "employeeTable", list);
	}
	
}
