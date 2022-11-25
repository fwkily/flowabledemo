package com.fwk.flowabledemo.service.impl;

import com.fwk.flowabledemo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {



    @Override
    public String getName() {
        System.out.println("fwknb66666");
        return "";
    }

}
