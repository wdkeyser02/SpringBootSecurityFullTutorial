package willydekeyser.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import willydekeyser.dto.UserDto;
import willydekeyser.mapper.UserMapper;
import willydekeyser.model.User;
import willydekeyser.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	public UserDto getLoginUser() {
		return userMapper.userEntityToDto(userRepository.findLoginUser().orElse(null));
	}
	
	public UserDto getUserById(Integer id) {
		return userMapper.userEntityToDto(userRepository.findById(id).orElse(null));
	}
	
	public List<UserDto> getAllUsers() {
		return userMapper.userListEntityToDto(userRepository.findAll());
	}
	
	public UserDto createUser(User user) {
		return userMapper.userEntityToDto(userRepository.save(user));
	}
	
	public UserDto updateUser(User user) {
		return userMapper.userEntityToDto(userRepository.save(user));
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);;
	}
	
}
