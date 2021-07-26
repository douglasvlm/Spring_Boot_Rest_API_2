package com.project.douglasapi.controller;

import com.project.douglasapi.dto.request.FriendsDTO;
import com.project.douglasapi.dto.response.MessageResponseDTO;
import com.project.douglasapi.entity.Friends;
import com.project.douglasapi.exception.FriendsNotFoundException;
import com.project.douglasapi.service.FriendsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/friends")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DouglasController {

    private FriendsService friendsService;

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws FriendsNotFoundException {
        friendsService.delete(id);
    }
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid FriendsDTO friendsDTO) throws FriendsNotFoundException {
        return friendsService.updateById(id, friendsDTO);
    }
}