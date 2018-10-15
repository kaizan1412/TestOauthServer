/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.ptap.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.id.ptap.entities.Role;
import co.id.ptap.entities.User;
import co.id.ptap.repositories.UserRepository;

/**
 *
 * @author developer
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo
                .findByUsername(username)
                .map(u -> new org.springframework.security.core.userdetails.User(
                u.getUsername(),
                u.getPassword(),
                u.isActive(),
                u.isActive(),
                u.isActive(),
                u.isActive(),
                AuthorityUtils.createAuthorityList(
                        u.getRoles()
                                .stream()
                                .map(r -> "ROLE_" + r.getName().toUpperCase())
                                .collect(Collectors.toList())
                                .toArray(new String[]{}))))
                .orElseThrow(() -> new UsernameNotFoundException("No user with "
                        + "the name " + username + "was found in the database"));
    }
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		org.springframework.security.core.userdetails.User userDetailsService = null;
//		// try {
//		User user = repo.findByUsername(username);
//		if (user != null) {
//			List<Role> roles = user.getRoles();
//			String[] rolesArray = (String[]) roles.toArray();
//
//			for (int i = 0; i < rolesArray.length; i++) {
//				rolesArray[i] = "ROLE_" + rolesArray[i].toUpperCase();
//			}
//
//			userDetailsService = new org.springframework.security.core.userdetails.User(user.getUsername(),
//					user.getPassword(), user.isActive(), user.isActive(), user.isActive(), user.isActive(),
//					AuthorityUtils.createAuthorityList(rolesArray));
//		} else {
//			throw new UsernameNotFoundException(
//					"No user with " + "the name " + username + "was found in the database.");
//		}
//		return userDetailsService;
//	}

}
