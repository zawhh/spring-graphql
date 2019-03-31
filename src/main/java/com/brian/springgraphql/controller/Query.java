package com.brian.springgraphql.controller;

import com.brian.springgraphql.model.User;
import com.brian.springgraphql.service.UserService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private UserService userService;

    public Query( UserService userService) {
        this.userService = userService;
    }

    public List<User> users(int first, int last) {
        System.out.println("Query: [" + first + "] to [" + last + "]");
        if((first == 0) && (last == 0)) {
            return this.userService.getAllUsers();
        } else {
            return this.userService.getUsers(first, last);
        }
    }

    public Optional<User> user(int id) {
        return this.userService.getUser(id);
    }

    public Optional<User> userone() {
        return this.userService.getUser(1);
    }
}

