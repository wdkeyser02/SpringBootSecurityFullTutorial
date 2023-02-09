package willydekeyser.dto;

import java.time.LocalDate;
import java.util.List;

public record UserDto(
		Integer id,
		String username,
		List<AuthorityDto> authorities,
		Boolean accountNonExpired,
		Boolean accountNonLocked,
		Boolean credentialsNonExpired,
		Boolean enabled,
		String firstName,
		String lastName,
		String emailAddress,
		LocalDate birthdate) {}
