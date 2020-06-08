package com.example.shoponline.client;

import com.example.shoponline.order.OrderConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientConverter {

    private OrderConverter orderConverter;

    @Autowired
    public ClientConverter(OrderConverter orderConverter) {
        this.orderConverter = orderConverter;
    }

    public ClientDto getDtoFromEntities(ClientEntity clientEntity) {
        ClientDto clientDto = new ClientDto();
        clientDto.setName(clientEntity.getName());
        clientDto.setAddress(clientEntity.getAddress());
        clientDto.setCity(clientEntity.getCity());
        clientDto.setProvince(clientEntity.getProvince());
        clientDto.setActive(clientEntity.getActive());
        clientDto.setOrders(this.orderConverter.toDtos(clientEntity.getOrders()));
        return clientDto;
    }

    public List<ClientDto> getDtosFromEntities(List<ClientEntity> clientEntities) {
        List<ClientDto> clientDtos = new ArrayList<>();
        for (int i = 0; i < clientEntities.size(); i++) {
            clientDtos.add(getDtoFromEntities(clientEntities.get(i)));
        }
        return clientDtos;
    }

    public ClientDto toDto(ClientEntity clientEntity) {
        ClientDto clientDto = new ClientDto();
        clientDto.setName(clientEntity.getName());
        clientDto.setAddress(clientEntity.getAddress());
        clientDto.setCity(clientEntity.getCity());
        clientDto.setProvince(clientEntity.getProvince());
        clientDto.setActive(clientEntity.getActive());
        return clientDto;
    }

//    public ClientEntity toEntity(ClientDto clientDto) {
//        return convertEntityFromDto(clientDto, new ClientEntity());
//    }
//
//    public ClientEntity toEntity(ClientDto clientDto, ClientEntity objToSave) {
//        return convertEntityFromDto(clientDto, objToSave);
//    }
//
//    private ClientEntity convertEntityFromDto(ClientDto clientDto, ClientEntity objToSave) {
//        objToSave.setName(clientDto.getName());
//        objToSave.setAddress(clientDto.getAddress());
//        objToSave.setCity(clientDto.getCity());
//        objToSave.setProvince(clientDto.getProvince());
//        objToSave.setActive(clientDto.getActive());
//        return objToSave;
//    }



    public ClientEntity toEntity(ClientDto clientDto, ClientEntity previousClientEntity) {
        ClientEntity clientEntity;
        if (previousClientEntity == null) {
            clientEntity = new ClientEntity();
        } else {
            clientEntity = previousClientEntity;
        }
        clientEntity.setName(clientDto.getName());
        clientEntity.setAddress(clientDto.getAddress());
        clientEntity.setCity(clientDto.getCity());
        clientEntity.setProvince(clientDto.getProvince());
        clientEntity.setActive(clientDto.getActive());
        return clientEntity;
    }

    // przesłanianie metody toEntity
    public ClientEntity toEntity(ClientDto clientDto) {
        return toEntity(clientDto, null);
    }
}
