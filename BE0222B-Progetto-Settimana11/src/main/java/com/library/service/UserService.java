package com.library.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.model.Role;
import com.library.model.Roles;
import com.library.model.User;
import com.library.model.dto.UserDTO;
import com.library.repository.RoleRepository;
import com.library.repository.UserRepository;
import com.library.util.exception.LibraryException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public Optional<User> addUser(UserDTO newUserDTO) throws Exception {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

		if (userRepository.findByUserName(newUserDTO.getUserName().toLowerCase()).isPresent()
				|| userRepository.findByEmail(newUserDTO.getEmail()).isPresent()) {
			throw new LibraryException("Username or E-mail already exists!");
		}

		Set<Role> roles = new HashSet<>();
		User newUser = new User();
		if (newUserDTO.getRoles() != null && newUserDTO.getRoles().size() > 0) {
			for (String r : newUserDTO.getRoles()) {
				if (r.toLowerCase().equals("user")) {
					if (roleRepository.findByRoleName(Roles.ROLE_USER).isEmpty()) {
						roles.add(new Role(Roles.ROLE_USER));
					} else {
						roles.add(roleRepository.findByRoleName(Roles.ROLE_USER).get());
					}
				} else if (r.toLowerCase().equals("admin")) {
					if (roleRepository.findByRoleName(Roles.ROLE_ADMIN).isPresent()) {
						roles.add(roleRepository.findByRoleName(Roles.ROLE_ADMIN).get());
					} else {
						roles.add(new Role(Roles.ROLE_ADMIN));
					}
				}
			}
		}
		if (newUserDTO.getRoles() != null && roles.size() > 0) {
		} else {
			roles.add(new Role(Roles.ROLE_USER));
		}
		newUser.setUserName(newUserDTO.getUserName().toLowerCase());
		newUser.setPassword(bCrypt.encode(newUserDTO.getPassword()));
		newUser.setEmail(newUserDTO.getEmail());
		newUser.setRoles(roles);
		newUser.setActive(true);

		userRepository.save(newUser);
		return Optional.of(newUser);
	}

}
