package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.dto.AuthorityDto;
import willydekeyser.service.AuthorityServce;

@RestController
@RequiredArgsConstructor
public class AuthorityController {
	
	private final AuthorityServce authorityServce;
	
	@GetMapping("/authorities")
	public List<AuthorityDto> getauthorities() {
		return authorityServce.getAllAuthorities();
	}

	@GetMapping("/authorities/{id}")
	public AuthorityDto getauthorityById(@PathVariable Integer id) {
		return authorityServce.getAuthorityById(id);
	}
}
