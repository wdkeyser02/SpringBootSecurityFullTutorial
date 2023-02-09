package willydekeyser.controller;

import java.time.format.DateTimeFormatter;

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
		return """ 
				<h1>Welcome home!</h1>
				<a href="/user">User</a><br/>
				<a href="/admin">Admin</a><br/>
				<a href="/developer">Developer</a>
				""";
	}
	
	@GetMapping("/user")
	public String user(Authentication authentication) {
		UserDto user = userService.getLoginUser();
		return """ 
				<h1>Welcome User!</h1>
				<h2>%s</h2>
				<h3>%s</h3>
				""".formatted(authentication.getName(), user);
	}
	
	@GetMapping("/admin")
	public String admin(Authentication authentication) {
		MySecurityUser myUser = (MySecurityUser) authentication.getPrincipal();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return """ 
				<h1>Welcome Admin!</h1>
				<h2>%s</h2>
				<p>MyUser:<br/>
				User name: %s<br/>
				Full name: %s<br/>
				E-Mail: %s<br/>
				Birthday: %s<br/>
				Authorities: %s
				</p>
				""".formatted(
						authentication.getName(), 
						myUser.getUsername(),
						myUser.getFullname(),
						myUser.getEmailaddress(),
						myUser.getBirthdate().format(dateTimeFormatter),
						myUser.getAuthorities()
						);
		
	}
	
	@GetMapping("/developer")
	public String developer(Authentication authentication) {
		UserDto user = userService.getLoginUser();
		return """ 
				<h1>Welcome Developer!</h1>
				<h2>%s</h2>
				<h3>%s</h3>
				""".formatted(authentication.getName(), user);
	}
}
