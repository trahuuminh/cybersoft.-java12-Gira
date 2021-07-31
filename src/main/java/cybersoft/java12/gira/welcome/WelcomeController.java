package cybersoft.java12.gira.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //trả về JSON
public class WelcomeController {
	@GetMapping("/Welcome")
	public Object welcome() {
		return "Welcome To Gira Application";
	}
}
