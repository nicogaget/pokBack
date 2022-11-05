package com.pc3v.back.servicesImpl;

import com.pc3v.back.models.User;
import com.pc3v.back.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pc3v.back.repository.UserRepository;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }


  @Override
  public List<User> findAll() {
    return null;
  }

  @Override
  public User findOne(int id) {
    return null;
  }

  @Override
  public User findByUsername(String username) {
    return null;
  }

  @Override
  public User save(User user) {
    return null;
  }
}
