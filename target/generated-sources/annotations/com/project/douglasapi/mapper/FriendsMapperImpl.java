package com.project.douglasapi.mapper;

import com.project.douglasapi.dto.request.FriendsDTO;
import com.project.douglasapi.dto.request.PhoneDTO;
import com.project.douglasapi.entity.Friends;
import com.project.douglasapi.entity.Phone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-26T16:31:00-0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
public class FriendsMapperImpl implements FriendsMapper {

    @Override
    public Friends toModel(FriendsDTO friendsDTO) {
        if ( friendsDTO == null ) {
            return null;
        }

        Friends friends = new Friends();

        if ( friendsDTO.getBirthDate() != null ) {
            friends.setBirthDate( LocalDate.parse( friendsDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        friends.setId( friendsDTO.getId() );
        friends.setFirstName( friendsDTO.getFirstName() );
        friends.setLastName( friendsDTO.getLastName() );
        friends.setCpf( friendsDTO.getCpf() );
        friends.setPhone( phoneDTOListToPhoneList( friendsDTO.getPhone() ) );

        return friends;
    }

    @Override
    public FriendsDTO toDTO(Friends friends) {
        if ( friends == null ) {
            return null;
        }

        FriendsDTO friendsDTO = new FriendsDTO();

        friendsDTO.setId( friends.getId() );
        friendsDTO.setFirstName( friends.getFirstName() );
        friendsDTO.setLastName( friends.getLastName() );
        friendsDTO.setCpf( friends.getCpf() );
        if ( friends.getBirthDate() != null ) {
            friendsDTO.setBirthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( friends.getBirthDate() ) );
        }
        friendsDTO.setPhone( phoneListToPhoneDTOList( friends.getPhone() ) );

        return friendsDTO;
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getId() );
        phone.setType( phoneDTO.getType() );
        phone.setNumber( phoneDTO.getNumber() );

        return phone;
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId( phone.getId() );
        phoneDTO.setType( phone.getType() );
        phoneDTO.setNumber( phone.getNumber() );

        return phoneDTO;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
