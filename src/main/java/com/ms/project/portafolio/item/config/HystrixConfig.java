package com.ms.project.portafolio.item.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author German Vazquez Renteria
 * Date:  23 jul. 2019
 * Package Name: com.ms.project.portafolio.item.config
 * Project Name: ms-item
 */
@Configuration
@Controller
public class HystrixConfig {

	@GetMapping("/hystrix.stream")
	public String hystrixActuator() {
		return "redirect:/actuator/hystrix.stream";
	}

}
