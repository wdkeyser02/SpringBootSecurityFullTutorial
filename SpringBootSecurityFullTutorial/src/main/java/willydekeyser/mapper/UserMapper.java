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
		return UserDto.builder()
				.id(user.getId())
				.username(user.getUsername())
				.authorities(authorityMapper.authorityListEntityToDto(user.getAuthorities()))
				.accountNonExpired(user.getAccountNonExpired())
				.accountNonLocked(user.getAccountNonLocked())
				.credentialsNonExpired(user.getCredentialsNonExpired())
				.enabled(user.getEnabled())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.emailAddress(user.getEmailAddress())
				.birthdate(user.getBirthdate())
				.build();
	}
	
	public List<UserDto> userListEntityToDto(List<User> users) {
		return users.stream()
				.map(user -> userEntityToDto(user))
				.toList();
	}
	
	public User userDtoToEntity(UserDto user, String password) {
		return User.builder()
				.id(user.id())
				.username(user.username())
				.password(password)
				.authorities(authorityMapper.authorityListDtoToEntity(user.authorities()))
				.accountNonExpired(user.accountNonExpired())
				.accountNonLocked(user.accountNonLocked())
				.credentialsNonExpired(user.credentialsNonExpired())
				.enabled(user.enabled())
				.firstName(user.firstName())
				.lastName(user.lastName())
				.emailAddress(user.emailAddress())
				.birthdate(user.birthdate())
				.build();
	}

	public List<User> userListDtoToEntity(List<UserDto> users, String password) {
		return users.stream()
				.map(user -> userDtoToEntity(user, password))
				.toList();
	}
}
