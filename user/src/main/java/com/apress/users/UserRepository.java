package com.apress.users;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository implements com.apress.users.Repository<Users,String> {

    private Map<String, Users> users = new HashMap<>(){{
        put("ximena@email.com",Users.builder()
                .email("ximena@email.com")
                .name("Ximena")
                .gravatarUrl("https://www.gravatar.com/avatar/23bb62a7d0ca63c9a804908e57bf6bd4?d=wavatar")
                                .password("aw2s0meR!")
                                .role(UserRole.USER)
                                .active(true)
                                .build());
        put("norma@email.com",Users.builder()
                .name("Norma")
                .email("norma@email.com")
                .gravatarUrl("https://www.gravatar.com/avatar/f07f7e553264c9710105edebe6c465e7?d=wavatar")
                                .password("aw2s0meR!")
                                .role(UserRole.USER)
                                .role(UserRole.ADMIN)
                                .active(true)
                                .build());
    }};


    @Override
    public Users save(Users users) {
        if (users.getGravatarUrl() == null){
            users.setGravatarUrl("https://www.gravatar.com/avatar/f07f7e553264c9710105edebe6c465e7?d=wavatar");
        }
        if (users.getUserRoles() == null){
            users.setUserRoles(Collections.emptyList());
        }
        this.users.put(users.getEmail(), users);
        return users; // return the saved one, not the previous
    }


    @Override
    public Optional<Users> findById(String id) {
        return Optional.ofNullable(this.users.get(id));
    }


    @Override
    public Iterable<Users> findAll() {
        return this.users.values();
    }

    @Override
    public void deleteById(String id) {
        this.users.remove(id);
    }
}
