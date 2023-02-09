package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.dto.UserDto;
import willydekeyser.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping("/users")
	public List<UserDto> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public UserDto getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
}
