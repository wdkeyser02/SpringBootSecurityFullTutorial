package willydekeyser.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.config.MySecurityUser;
import willydekeyser.dto.UserDto;
import willydekeyser.service.UserService;

@RestController
@RequiredArgsConstructor
public class HomeController {

	private final UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "<h1>Welcome home!</h1>";
	}
	
	@GetMapping("/user")
	public String user(Authentication authentication) {
		UserDto user = userService.getLoginUser();
		return "<h1>Welcome User!</h1><h2>" + authentication.getName() + "</h2><h3>" + user + "</h3>";
	}
	
	@GetMapping("/admin")
	public String admin(Authentication authentication) {
		MySecurityUser myUser = (MySecurityUser) authentication.getPrincipal();
		return "<h1>Welcome Admin!</h1><h2>" + authentication.getName() + "</h2><p>MyUser:<br>User name: " + myUser.getUsername()  
		+ "<br>Full name: " + myUser.getFullname() + "<br>E-Mail: " + myUser.getEmailaddress() + "<br>Birthday: " + myUser.getBirthdate()
		+ "<br>Authorities: " + myUser.getAuthorities();
	}
	
	@GetMapping("/developer")
	public String developer(Authentication authentication) {
		UserDto user = userService.getLoginUser();
		return "<h1>Welcome User!</h1><h2>" + authentication.getName() + "</h2><h3>" + user + "</h3>";
	}
}
