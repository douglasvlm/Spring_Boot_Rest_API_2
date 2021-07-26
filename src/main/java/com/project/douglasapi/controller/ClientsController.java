package com.project.douglasapi.controller;

import com.project.douglasapi.dto.request.ClientsDTO;
import com.project.douglasapi.dto.response.MessageResponseDTO;
import com.project.douglasapi.exception.ClientsNotFoundException;
import com.project.douglasapi.service.ClientsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/clients")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientsController {

    private ClientsService clientsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody @Valid ClientsDTO clientsDTO){
        return clientsService.createClient(clientsDTO);
    }

    @GetMapping
    public List<ClientsDTO> listAll() {
        return clientsService.listAll();
    }

    @GetMapping("/{id}")
    public ClientsDTO findById(@PathVariable Long id) throws ClientsNotFoundException {
        return clientsService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClientsNotFoundException {
        clientsService.delete(id);
    }
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid ClientsDTO clientsDTO) throws ClientsNotFoundException {
        return clientsService.updateById(id, clientsDTO);
    }
}
