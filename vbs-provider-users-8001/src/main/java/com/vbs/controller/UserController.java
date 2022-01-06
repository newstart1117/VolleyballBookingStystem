package com.vbs.controller;

import com.vbs.model.CommonResult;
import com.vbs.model.User;
import com.vbs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommonResult commonResult;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/user/{id}")
    public CommonResult getUserById(@PathVariable("id") Long id) {
        log.info("userController: {}", "getUserById()");
        Optional<User> user = userService.getUserById(id);
        commonResult.setMsg("取得使用者");
        commonResult.setData(user);
        return commonResult;
    }

    @PostMapping("/user")
    public CommonResult saveUser(@RequestBody User user) {
        log.info("userController: {}", "saveUser()");
        boolean bool = userService.saveUser(user);
        commonResult.setMsg("新增使用者");
        commonResult.setData(bool);
        return commonResult;
    }

    @DeleteMapping("/user/{id}")
    public CommonResult deleteUser(@PathVariable("id") Long id) {
        log.info("userController: {}", "deleteUser()");
        boolean bool = userService.deleteUserById(id);
        commonResult.setMsg("刪除使用者");
        commonResult.setData(bool);
        return commonResult;
    }

    @PutMapping("/user/{id}")
    public CommonResult updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        log.info("userController: {}", "updateUser()");
        user.setUserId(id);
        boolean bool = userService.updateUser(user);

        commonResult.setMsg("更新使用者");
        commonResult.setData(bool);
        return commonResult;
    }

    @GetMapping("/user/list")
    public CommonResult listUser() {
        log.info("userController: {}", "listUser()");
        List<User> list = userService.listUser();

        commonResult.setMsg("使用者列表");
        commonResult.setData(list);
        return commonResult;
    }


}
