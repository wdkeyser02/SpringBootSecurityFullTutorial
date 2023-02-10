package willydekeyser.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import willydekeyser.dto.AuthorityDto;
import willydekeyser.service.AuthorityServce;

@Controller
@RequiredArgsConstructor
public class AuthorityController {
	
	private final AuthorityServce authorityServce;
	
	@GetMapping("/authorities")
	public String getauthorities(Model model) {
		List<AuthorityDto> authorities = authorityServce.getAllAuthorities();
		model.addAttribute("title", "Athorities");
		model.addAttribute("authorities", authorities);
		return "authorities";
	}

	@GetMapping("/authorities/{id}")
	public AuthorityDto getauthorityById(@PathVariable Integer id) {
		return authorityServce.getAuthorityById(id);
	}
}
