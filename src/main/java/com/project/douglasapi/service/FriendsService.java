package com.project.douglasapi.service;

import com.project.douglasapi.dto.MessageResponseDTO;
import com.project.douglasapi.entity.Friends;
import com.project.douglasapi.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FriendsService {
    private FriendsRepository friendsRepository;

    @Autowired
    public FriendsService(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    public MessageResponseDTO createFriend(Friends friends){
        Friends savedFriend =  friendsRepository.save(friends);
        return MessageResponseDTO.builder().message("Created Friend with id " + savedFriend.getId()).build();
    }
}
