package willydekeyser.config;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MySecurityUser extends User {

	private static final long serialVersionUID = 1L;
	
	public MySecurityUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			String firstName, String lastName, String emailaddress, LocalDate birthdate) {
		super(username, password, enabled, accountNonExpired,credentialsNonExpired,accountNonLocked, authorities);
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullname = firstName + " " + lastName;
		this.emailaddress = emailaddress;
		this.birthdate = birthdate;
	}

	private String firstName;
	private String lastName;
	private String fullname;
	private String emailaddress;
	private LocalDate birthdate;;

	
	@Override
	public String toString() {
		return "MySecurityUser firstName=" + firstName + ", lastName=" + lastName + ", name=" + fullname + ", emailaddress=" + emailaddress + ", birthdate=" + birthdate
				+ "] " + super.toString();
	}
	
	
}