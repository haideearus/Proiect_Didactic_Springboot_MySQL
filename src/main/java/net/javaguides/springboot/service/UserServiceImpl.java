//package net.javaguides.springboot.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import net.javaguides.springboot.model.User;
//import net.javaguides.springboot.repository.UserRepository;
//import net.javaguides.springboot.web.dto.UserRegistrationDto;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserServiceImpl implements UserService{
//
//	private UserRepository userRepository;
//
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	public UserServiceImpl(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}
//
//	@Override
//	public User save(UserRegistrationDto registrationDto) {
//		User user = new User(registrationDto.getFirstName(),
//				registrationDto.getLastName(), registrationDto.getEmail(),
//				passwordEncoder.encode(registrationDto.getPassword()), "USER");
//
//		return userRepository.save(user);
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByEmail(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("Invalid username or password.");
//		}
//
//		// Folosește un singur rol (șir simplu) într-o listă de GrantedAuthority
//		List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRol()));
//		System.out.println(authorities);
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
//	}
//
//	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
//		return Collections.singletonList(new SimpleGrantedAuthority(role));
//	}
//
//}
