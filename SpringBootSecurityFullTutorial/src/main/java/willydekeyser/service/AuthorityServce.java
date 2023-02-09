package willydekeyser.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import willydekeyser.dto.AuthorityDto;
import willydekeyser.mapper.AuthorityMapper;
import willydekeyser.model.Authority;
import willydekeyser.repository.AuthorityRepository;

@Service
@RequiredArgsConstructor
public class AuthorityServce {

	private final AuthorityRepository authorityRepository;
	private final AuthorityMapper authorityMapper;
	
	public AuthorityDto getAuthorityById(Integer id) {
		return authorityMapper.authorityEntityToDto(authorityRepository.findById(id).orElse(null));
	}
	
	public List<AuthorityDto> getAllAuthorities() {
		return authorityMapper.authorityListEntityToDto(authorityRepository.findAll());
	}
	
	public AuthorityDto createAuthority(Authority authority) {
		return authorityMapper.authorityEntityToDto(authorityRepository.save(authority));
	}
	
	public AuthorityDto updateAuthority(Authority authority) {
		return authorityMapper.authorityEntityToDto(authorityRepository.save(authority));
	}
	
	public void deleteAuthority(Authority authority) {
		authorityRepository.delete(authority);
	}
}
