package net.moulik.ecommercemoulik.controller;

import net.moulik.ecommercemoulik.dto.ResponseModel;
import net.moulik.ecommercemoulik.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    protected ResponseEntity<ResponseModel> doHandleException(Exception e){
        String message = "required request can not processed!";
        if(e instanceof ResourceNotFoundException) {
            message = e.getMessage();
        }
        ResponseModel model = new ResponseModel();
        model.setMessage(message);
        model.setData(null);
        return ResponseEntity.ok(model);
    }
}
