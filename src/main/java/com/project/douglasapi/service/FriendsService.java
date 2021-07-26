package com.project.douglasapi.service;

import com.project.douglasapi.dto.request.FriendsDTO;
import com.project.douglasapi.dto.response.MessageResponseDTO;
import com.project.douglasapi.entity.Friends;
import com.project.douglasapi.mapper.FriendsMapper;
import com.project.douglasapi.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendsService {

    private FriendsRepository friendsRepository;

    private final FriendsMapper friendsMapper = FriendsMapper.INSTANCE;

    @Autowired
    public FriendsService(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    public MessageResponseDTO createFriend(FriendsDTO friendsDTO){
        Friends friendsToSave = friendsMapper.toModel(friendsDTO);

        Friends savedFriend = friendsRepository.save(friendsToSave);

        return MessageResponseDTO
                .builder()
                .message("Created Friend with id " + savedFriend.getId())
                .build();
    }

    public List<FriendsDTO> listAll() {
        List<Friends> allFriends = friendsRepository.findAll();
        return allFriends.stream()
                .map(friendsMapper::toDTO)
                .collect(Collectors.toList());
    }
}
