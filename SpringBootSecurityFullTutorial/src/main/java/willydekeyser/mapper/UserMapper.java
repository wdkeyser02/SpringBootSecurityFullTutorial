package willydekeyser.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import willydekeyser.dto.UserDto;
import willydekeyser.model.User;

@RequiredArgsConstructor
@Component
public class UserMapper {

	private final AuthorityMapper authorityMapper;
	
	public UserDto userEntityToDto(User user) {
		return new UserDto(
				user.getId(),
				user.getUsername(),
				authorityMapper.authorityListEntityToDto(user.getAuthorities()),
				user.getAccountNonExpired(),
				user.getAccountNonLocked(),
				user.getCredentialsNonExpired(),
				user.getEnabled(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmailAddress(),
				user.getBirthdate());
	}
	
	public List<UserDto> userListEntityToDto(List<User> users) {
		return users.stream()
				.map(user -> userEntityToDto(user))
				.toList();
	}
	
	public User userDtoToEntity(UserDto user, String password) {
		return new User(
				user.id(),
				user.username(),
				password,
				authorityMapper.authorityListDtoToEntity(user.authorities()),
				user.accountNonExpired(),
				user.accountNonLocked(),
				user.credentialsNonExpired(),
				user.enabled(),
				user.firstName(),
				user.lastName(),
				user.emailAddress(),
				user.birthdate());
	}

	public List<User> userListDtoToEntity(List<UserDto> users, String password) {
		return users.stream()
				.map(user -> userDtoToEntity(user, password))
				.toList();
	}
}
