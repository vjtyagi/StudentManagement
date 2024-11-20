package com.example.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.StudentManagement.entity.Role;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.repository.RoleRepository;
import com.example.StudentManagement.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin") == null) {
            Role adminRole = roleRepository.findByName("ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setName("ADMIN");
                roleRepository.save(adminRole);
            }
            User adminUser = new User();
            adminUser.setUsername("admin");
            String encodedPassword = passwordEncoder.encode("adminpassword");
            adminUser.setPassword(encodedPassword);
            adminUser.setEmail("admin@yourcompany.com");
            adminUser.addRole(adminRole);
            userRepository.save(adminUser);
            System.out.println("Admin user created");
        } else {
            System.out.println("Admin user already exists");
        }
    }
}
