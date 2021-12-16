package net.moulik.ecommercemoulik.service;

import net.moulik.ecommercemoulik.exceptions.ResourceNotFoundException;

public abstract class BaseService {
    protected void doHandleException(Exception e) throws Exception {
       if(e instanceof ResourceNotFoundException) {
           throw e;
       }
    }
}
