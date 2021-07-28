package br.edu.ifpb.repository;

import br.edu.ifpb.domain.User;

import java.util.Optional;

public class UserRepository {

    public Optional<User> find(Long id) {
        User user = null;
        if (id == 1) {
            user = new User();
            user.setLogin("admin");
            user.setPassword("123");
        }

        return Optional.ofNullable(user);
    }

}
