package com.project.douglasapi.controller;

import com.project.douglasapi.dto.request.FriendsDTO;
import com.project.douglasapi.dto.response.MessageResponseDTO;
import com.project.douglasapi.entity.Friends;
import com.project.douglasapi.exception.FriendsNotFoundException;
import com.project.douglasapi.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/friends") //@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DouglasController {

    private FriendsService friendsService;

    @Autowired
    public DouglasController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createFriend(@RequestBody @Valid FriendsDTO friendsDTO){
        return friendsService.createFriend(friendsDTO);
    }

    @GetMapping
    public List<FriendsDTO> listAll() {
        return friendsService.listAll();
    }

    @GetMapping("/{id}")
    public FriendsDTO findById(@PathVariable Long id) throws FriendsNotFoundException {
        return friendsService.findById(id);
    }

}




  /*  private PersonService personService;


    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);*/
