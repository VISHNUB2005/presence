package com.vishnu.presence.service;

import com.vishnu.presence.entity.User;
import com.vishnu.presence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    // constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get all users
    public List<User> getAllUsers() {
    return userRepository.findByActiveTrue();
}


    // create user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // delete user
      public void deleteUser(Long id) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    user.setActive(false);   // soft delete
    userRepository.save(user);
}
  

}
