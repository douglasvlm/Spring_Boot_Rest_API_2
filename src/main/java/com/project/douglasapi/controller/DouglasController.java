package com.project.douglasapi.controller;

import com.project.douglasapi.dto.MessageResponseDTO;
import com.project.douglasapi.entity.Friends;
import com.project.douglasapi.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/friends") //@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DouglasController {

    private FriendsRepository friendsRepository;

    @Autowired
    public DouglasController(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    @PostMapping
    public MessageResponseDTO createFriend(@RequestBody Friends friends){
       Friends savedFriend =  friendsRepository.save(friends);
        return MessageResponseDTO.builder().message("Created Friend with id " + savedFriend.getId()).build();
    }

}




  /*  private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

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
