package willydekeyser.config;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import willydekeyser.model.User;
import willydekeyser.repository.UserRepository;

@RequiredArgsConstructor
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> userByUsername = userRepository.findByUsername(username);
		if (!userByUsername.isPresent()) {
			log.error("Could not find user with that username: {}", username);
            throw new UsernameNotFoundException("Invalid credentials!");
		}
		User user = userByUsername.get();
        if (user == null || !user.getUsername().equals(username)) {
        	log.error("Could not find user with that username: {}", username);
            throw new UsernameNotFoundException("Invalid credentials!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getAuthorities().stream().forEach(authority -> 
        grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority())));
        
        return new MySecurityUser(user.getUsername(), user.getPassword(), true, true, true, true, grantedAuthorities, 
        		user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getBirthdate());
	}
}
