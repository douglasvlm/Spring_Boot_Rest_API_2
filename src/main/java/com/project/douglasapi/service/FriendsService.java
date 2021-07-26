package com.project.douglasapi.service;

import com.project.douglasapi.dto.request.FriendsDTO;
import com.project.douglasapi.dto.response.MessageResponseDTO;
import com.project.douglasapi.entity.Friends;
import com.project.douglasapi.exception.FriendsNotFoundException;
import com.project.douglasapi.mapper.FriendsMapper;
import com.project.douglasapi.repository.FriendsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FriendsService {

    private FriendsRepository friendsRepository;

    private final FriendsMapper friendsMapper = FriendsMapper.INSTANCE;

    public MessageResponseDTO createFriend(FriendsDTO friendsDTO){
        Friends friendsToSave = friendsMapper.toModel(friendsDTO);
        Friends savedFriend = friendsRepository.save(friendsToSave);
        return createMessageResponse(savedFriend.getId(), "Created Friend with id ");
    }

    public List<FriendsDTO> listAll() {
        List<Friends> allFriends = friendsRepository.findAll();
        return allFriends.stream()
                .map(friendsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FriendsDTO findById(Long id) throws FriendsNotFoundException {
        Friends friends = verifyIfExists(id);
        return friendsMapper.toDTO(friends);
        //Optional<Friends> optionalFriends = friendsRepository.findById(id);  // if(optionalFriends.isEmpty()){  //   throw new FriendsNotFoundException(id);  //} return friendsMapper.toDTO(optionalFriends.get());
    }

    public void delete(Long id) throws FriendsNotFoundException {
        verifyIfExists(id);
        friendsRepository.deleteById(id);
    }

     public MessageResponseDTO updateById(Long id, FriendsDTO friendsDTO) throws FriendsNotFoundException {
        verifyIfExists(id);
        Friends friendsToUpdate = friendsMapper.toModel(friendsDTO);
        Friends updateFriend = friendsRepository.save(friendsToUpdate);
        return createMessageResponse(updateFriend.getId(), "Updated Friend with id ");
    }

    private Friends verifyIfExists (Long id) throws FriendsNotFoundException{
        return friendsRepository.findById(id).orElseThrow(() -> new FriendsNotFoundException(id));

    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
