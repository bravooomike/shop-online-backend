package com.example.shoponline.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/shop")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(path = "/clients", method = RequestMethod.GET)
    public List<ClientDto> getAll() {
        return this.clientService.getAll();
    }

    @RequestMapping(path = "clients/{id}", method = RequestMethod.GET)
    public ClientDto getOne(@PathVariable("id") Integer id) {
        return this.clientService.getOne(id);
    }

    @RequestMapping(path = "client/add", method = RequestMethod.POST)
    public ClientDto add(@RequestBody ClientDto clientDto) {
        return this.clientService.save(clientDto);
    }

    @RequestMapping(path = "client/update/{id}", method = RequestMethod.PUT)
    public ClientDto update(@RequestBody ClientDto clientDto, @PathVariable("id") Integer id) {
        return this.clientService.save(clientDto, id);
    }

    @RequestMapping(path = "client/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        this.clientService.delete(id);
    }
}
