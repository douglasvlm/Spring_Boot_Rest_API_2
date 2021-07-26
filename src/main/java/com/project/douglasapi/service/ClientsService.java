package com.project.douglasapi.service;

import com.project.douglasapi.dto.request.ClientsDTO;
import com.project.douglasapi.dto.response.MessageResponseDTO;
import com.project.douglasapi.entity.Clients;
import com.project.douglasapi.exception.ClientsNotFoundException;
import com.project.douglasapi.mapper.ClientsMapper;
import com.project.douglasapi.repository.ClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientsService {

    private ClientsRepository clientsRepository;

    private final ClientsMapper clientsMapper = ClientsMapper.INSTANCE;

    public MessageResponseDTO createClient(ClientsDTO clientsDTO){
        Clients clientsToSave = clientsMapper.toModel(clientsDTO);
        Clients savedClient = clientsRepository.save(clientsToSave);
        return createMessageResponse(savedClient.getId(), "Created Client with id ");
    }

    public List<ClientsDTO> listAll() {
        List<Clients> allclients = clientsRepository.findAll();
        return allclients.stream()
                .map(clientsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientsDTO findById(Long id) throws ClientsNotFoundException {
        Clients clients = verifyIfExists(id);
        return clientsMapper.toDTO(clients);
        //Optional<clients> optionalclients = clientsRepository.findById(id);  // if(optionalclients.isEmpty()){  //   throw new clientsNotFoundException(id);  //} return clientsMapper.toDTO(optionalclients.get());
    }

    public void delete(Long id) throws ClientsNotFoundException {
        verifyIfExists(id);
        clientsRepository.deleteById(id);
    }

     public MessageResponseDTO updateById(Long id, ClientsDTO clientsDTO) throws ClientsNotFoundException {
        verifyIfExists(id);
        Clients clientsToUpdate = clientsMapper.toModel(clientsDTO);
        Clients updateClient = clientsRepository.save(clientsToUpdate);
        return createMessageResponse(updateClient.getId(), "Updated Client with id ");
    }

    private Clients verifyIfExists (Long id) throws ClientsNotFoundException {
        return clientsRepository.findById(id).orElseThrow(() -> new ClientsNotFoundException(id));

    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}