package com.users.user;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
    private Map<String , Users> usersMap = new HashMap<>(){{
       put("hello@test1.com", new Users("hello@test1.com","hello"));
       put("hello@test2.com", new Users("hello@test2.com","hello1"));
    }};

    @GetMapping
    private Collection<Users> getAll(){
        return this.usersMap.values();
    }

    @GetMapping("/{email}")
    private Users findUserByEmail(@PathVariable String email){
        return this.usersMap.get(email);
    }

    @PostMapping
    private Users save(@RequestBody Users user){
        this.usersMap.put(user.getEmail(), user);
        return user;
    }

    @DeleteMapping("/remove/{email}")
    private void deleteByEmail(@PathVariable String email){
        this.usersMap.remove(email);
    }


}
