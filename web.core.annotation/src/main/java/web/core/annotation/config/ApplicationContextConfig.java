package web.core.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import web.core.annotation.convert.DepartmentConverter;
import web.core.annotation.convert.HireDateConvert;
import web.core.annotation.service.DepartmentService;

@Configuration
@ComponentScan("web.core.annotation.*")
public class ApplicationContextConfig extends WebMvcConfigurerAdapter{
	
	@Bean(name="viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	public void addFormatters(FormatterRegistry formatterRegistry) {
		formatterRegistry.addConverter(new HireDateConvert());
		formatterRegistry.addConverter(new DepartmentConverter(getDepartmentService()));
		super.addFormatters(formatterRegistry);
	}

	@Bean
	public DepartmentConverter getDepartmentConverter() {
		return new DepartmentConverter();
	}
	
	@Bean(name = "departmentService")
	public DepartmentService getDepartmentService() {
		return new DepartmentService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
}
