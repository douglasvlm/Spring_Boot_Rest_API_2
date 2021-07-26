package com.project.douglasapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientsNotFoundException extends Exception {
    public ClientsNotFoundException(Long id) {
        super("Client not found with id = " + id);
    }
}
