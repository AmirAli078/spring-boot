package com.sts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/test")
	@ResponseBody
	public String testHandler() {
		return "This SpringBoot project is done through STS tool ";
	}

}
