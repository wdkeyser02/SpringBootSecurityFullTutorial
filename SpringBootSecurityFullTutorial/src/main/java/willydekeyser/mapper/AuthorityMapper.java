package willydekeyser.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import willydekeyser.dto.AuthorityDto;
import willydekeyser.model.Authority;

@Component
public class AuthorityMapper {

	public AuthorityDto authorityEntityToDto(Authority authority) {
		return new AuthorityDto(
				authority.getId(),
				authority.getAuthority());	
	}
	
	public List<AuthorityDto> authorityListEntityToDto(List<Authority> authorities) {
		return authorities.stream()
				.map(authority -> authorityEntityToDto(authority))
				.toList();
	}
		
	public Authority authorityDtoToEntity(AuthorityDto authority) {
		return new Authority(
				authority.id(),
				authority.authority());	
	}
	
	public List<Authority> authorityListDtoToEntity(List<AuthorityDto> authorities) {
		return authorities.stream()
				.map(authority -> authorityDtoToEntity(authority))
				.toList();
	}
}
