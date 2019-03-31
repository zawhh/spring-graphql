package com.brian.springgraphql.service;

import com.brian.springgraphql.model.User;
import com.brian.springgraphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class UserService {
    private UserRepository store;

    public UserService(UserRepository db) {
        this.store = db;
    }

    public List<User> getAllUsers() {
        return store.findAll();
    }

    public Optional<User> getUser(int id) {
        return store.findById(id);
    }

    public List<User> getUsers(int first, int last) {
        if ((last == 0) || (last < first)) {
            last = (int)store.count();
        }

        return store.findAllById(
                IntStream.rangeClosed(first, last).boxed()
                        .collect(Collectors.toList())
        );
    }

    public User newUser(String login, String name) {
        User u = new User();
        u.setLogin(login);
        u.setName(name);
        return store.save(u);
    }

    public User saveUser(User user) {
        return store.save(user);
    }

    public void deleteUser(int id) {
        store.deleteById(id);
    }
}
