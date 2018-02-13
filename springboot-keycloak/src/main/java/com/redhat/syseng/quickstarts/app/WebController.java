package com.redhat.syseng.quickstarts.app;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping(path = "/")
	public String getPublic() {
		return "public";
	}
	
	@GetMapping(path = "/private")
	public String getPrivate(Principal principal, Model model) {
		model.addAttribute("username", principal.getName());
		return "private";
	}
	
}
