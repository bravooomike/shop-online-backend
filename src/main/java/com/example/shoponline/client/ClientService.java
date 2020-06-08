package com.example.shoponline.client;


import com.example.shoponline.client.ClientConverter;
import com.example.shoponline.client.ClientEntity;
import com.example.shoponline.client.ClientDto;
import com.example.shoponline.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ClientConverter clientConverter;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientConverter clientConverter) {
        this.clientRepository = clientRepository;
        this.clientConverter = clientConverter;
    }

    public List<ClientDto> getAll() {
        return this.clientConverter.getDtosFromEntities(this.clientRepository.findAll());
    }

    public ClientDto getOne(Integer id) {
        return this.clientConverter.toDto(this.clientRepository.findById(id).orElse(null));
    }

    public void delete(Integer id) {
        this.clientRepository.deleteById(id);
    }

//    public ClientDto save(ClientDto clientDto, Integer id) {
//        ClientEntity clientEntity;
//        if (id == null) {
//            clientEntity = this.clientRepository.save(this.clientConverter.toEntity(clientDto));
//        } else {
//            clientEntity =  this.clientRepository.save(this.clientConverter.toEntity(clientDto, this.clientRepository.getOne(id)));
//        }
//        return this.clientConverter.toDto(clientEntity);
//    }

//    public ClientDto save(ClientDto clientDto, Integer id) {
//        ClientEntity savedClientEntity;
//        if (id == null) {
//            savedClientEntity = this.clientRepository.save(this.clientConverter.toEntity(clientDto, null));
//        } else {
//            savedClientEntity = this.clientRepository.save(this.clientConverter.toEntity(clientDto, this.clientRepository.getOne(id)));
//        }
//        return this.clientConverter.toDto(savedClientEntity);
//    }

    public ClientDto save(ClientDto clientDto) {
        return this.clientConverter.toDto(this.clientRepository.save(this.clientConverter.toEntity(clientDto)));
    }

    public ClientDto save(ClientDto clientDto, Integer id) {
        ClientEntity clientEntity = this.clientRepository.save(this.clientConverter.toEntity(clientDto, this.clientRepository.getOne(id)));
        return this.clientConverter.toDto(clientEntity);
    }
}





