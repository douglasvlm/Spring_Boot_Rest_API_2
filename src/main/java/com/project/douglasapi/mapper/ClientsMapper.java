package com.project.douglasapi.mapper;

import com.project.douglasapi.dto.request.ClientsDTO;
import com.project.douglasapi.entity.Clients;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientsMapper {

    ClientsMapper INSTANCE = Mappers.getMapper(ClientsMapper.class);

    @Mapping(target = "birthDate" , source = "birthDate", dateFormat = "dd-MM-yyyy")
    Clients toModel(ClientsDTO clientsDTO);

    ClientsDTO toDTO(Clients clients);
}
