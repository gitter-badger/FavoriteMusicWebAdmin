package mplanweb.music.web.login;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

	private MainDAO mainDao;

	public void setMainDao(MainDAO maindao) {
		this.mainDao = maindao;
	}

	public UserDetails loadUserByUsername(String mp_name)
			throws UsernameNotFoundException {
		
		// id, passwd
		String userPwd = mainDao.getUserPwd(mp_name);

		// "ROLE_USER 이름 권한 설정
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	
		// User => return 
		UserDetails user = new User(mp_name, userPwd, roles);
		return user;
	}

}
