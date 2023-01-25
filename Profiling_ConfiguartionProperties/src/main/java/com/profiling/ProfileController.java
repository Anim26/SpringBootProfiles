package com.profiling;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path="/profile")
public class ProfileController {
	@Autowired
	private ProfileConfiguration profileConfiguration;
	
	@GetMapping(path="/welcome")
	public String getMessage() {
		
		return profileConfiguration.getWelcomeMessage();
	}
	
	@GetMapping(path="/dynamic-configuration")
	public Map getMessageByConfiguartionProperties() {
		
		Map hm=new LinkedHashMap<>();
		hm.put("ID",profileConfiguration.getEmployeeId());
		hm.put("Name",profileConfiguration.getEmployeeName());
		hm.put("Age", profileConfiguration.getEmployeeAge());
		hm.put("Env", profileConfiguration.getEnv());
		return hm;
	}
	
}
