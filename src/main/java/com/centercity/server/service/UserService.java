package com.centercity.server.service;


import com.centercity.server.entity.Role;
import com.centercity.server.entity.User;
import com.centercity.server.repository.RoleRepository;
import com.centercity.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user_name = userRepository.findByUsername(username);
        User user_email = userRepository.findByEmail(username);

        if (user_name != null) {
            return user_name;
        }

        if (user_email != null) {
            return user_email;
        }

        if (user_name == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return null;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public int validForm(User user){
        User userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB != null) {
                return 1;
        }
        return 0;
    }

    public boolean saveUser(User user) {

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean updateUser(User user, Long userId) {

        User old_user = userRepository.findById(userId).get();

        old_user.setUsername(user.getUsername());
        old_user.setEmail(user.getEmail());
        old_user.setPone_number(user.getPone_number());
        old_user.setDriver_code(user.getDriver_code());
        old_user.setKurator(user.getKurator());
        userRepository.save(old_user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public User usergtList(Long idMin) {
        User user = userRepository.findById(idMin).get();
        return user;
    }

    public boolean updatePass(User user, Long id) {
        User old_user = userRepository.findById(id).get();
        old_user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(old_user);
        return true;
    }
}



