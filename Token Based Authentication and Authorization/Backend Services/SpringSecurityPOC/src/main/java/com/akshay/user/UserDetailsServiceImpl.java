package com.akshay.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private ApplicationUserRepository applicationUserRepository;

	public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
		this.applicationUserRepository = applicationUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
		if (applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), getAuthority(applicationUser));
	}

	private Set<SimpleGrantedAuthority> getAuthority(ApplicationUser user) {
		HashSet<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		List<String> arrayToList = CollectionUtils.arrayToList(user.getRoles());
		arrayToList.forEach((role) -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		});
		return authorities;
	}
}