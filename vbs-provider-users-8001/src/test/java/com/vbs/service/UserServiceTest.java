package com.vbs.service;

import com.vbs.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void getUserById() {
        long id = 1;
        Optional<User> users = userService.getUserById(id);
        String username = users.orElseThrow(NullPointerException::new).getName();
        assertEquals("Admin", username);
    }

    @Test
    void saveUser() {
        User user = new User("test", "0999999999", "testLine", 0);
        boolean bool = userService.saveUser(user);
        assertTrue(bool);
    }

    @Test
    void deleteUserById() {
        long id = 1;
        boolean bool = userService.deleteUserById(id);
        assertTrue(bool);
    }

    @Test
    void updateUser() {
        long id = 1;
        User user = userService.getUserById(id).orElseThrow(NullPointerException::new);
        user.setLine("adminTestLine");
        userService.updateUser(user);

        //檢查是否有update進資料庫
        user = userService.getUserById(id).orElseThrow(NullPointerException::new);
        String line = user.getLine();
        assertEquals("adminTestLine", line);
    }

    @Test
    void listUser() {
        List<User> users = userService.listUser();
    }
}