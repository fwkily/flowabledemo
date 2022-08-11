package com.fwk.flowabledemo;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Override
    public void getName() {
        System.out.println("fwknb66666");
    }
}
