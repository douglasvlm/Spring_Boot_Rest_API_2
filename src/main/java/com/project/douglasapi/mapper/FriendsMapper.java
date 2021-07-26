package com.project.douglasapi.mapper;

import com.project.douglasapi.dto.request.FriendsDTO;
import com.project.douglasapi.entity.Friends;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FriendsMapper {

    FriendsMapper INSTANCE = Mappers.getMapper(FriendsMapper.class);

    @Mapping(target = "birthDate" , source = "birthDate", dateFormat = "dd-MM-yyyy")
    Friends toModel(FriendsDTO friendsDTO);

    FriendsDTO toDTO(Friends friends);
}
