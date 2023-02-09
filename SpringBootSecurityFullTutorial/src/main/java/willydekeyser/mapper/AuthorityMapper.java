package willydekeyser.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import willydekeyser.dto.AuthorityDto;
import willydekeyser.model.Authority;

@Component
public class AuthorityMapper {

	public AuthorityDto authorityEntityToDto(Authority authority) {
		return AuthorityDto.builder()
				.id(authority.getId())
				.authority(authority.getAuthority())
				.build();
	}
	
	public List<AuthorityDto> authorityListEntityToDto(List<Authority> authorities) {
		return authorities.stream()
				.map(authority -> authorityEntityToDto(authority))
				.toList();
	}
		
	public Authority authorityDtoToEntity(AuthorityDto authority) {
		return Authority.builder()
				.id(authority.id())
				.authority(authority.authority())
				.build();
	}
	
	public List<Authority> authorityListDtoToEntity(List<AuthorityDto> authorities) {
		return authorities.stream()
				.map(authority -> authorityDtoToEntity(authority))
				.toList();
	}
}
