package com.brian.springgraphql.controller;

import com.brian.springgraphql.model.User;
import com.brian.springgraphql.service.UserService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User createUser(String login, String name) {
        return userService.newUser(login, name);
    }
}
