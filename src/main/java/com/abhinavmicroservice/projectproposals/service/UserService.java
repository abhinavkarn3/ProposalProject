package com.abhinavmicroservice.projectproposals.service;


import com.abhinavmicroservice.projectproposals.entity.User;
import com.abhinavmicroservice.projectproposals.entity.Notification;
import com.abhinavmicroservice.projectproposals.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            List<Notification> notifications = notificationService.getUnreadNotifications(user.getId());
            // Display notifications to the user (implementation depends on your UI framework)
            notificationService.markNotificationsAsRead(notifications);
        }
        return user;
    }
}