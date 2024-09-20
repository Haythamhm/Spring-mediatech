package com.springhayth.mediatech.Service.ImplService;

import com.springhayth.mediatech.Dao.ClientDao;
import com.springhayth.mediatech.Dto.ClientRequestDto;
import com.springhayth.mediatech.Dto.ClientResponseDto;
import com.springhayth.mediatech.Entities.Client;
import com.springhayth.mediatech.Exceptions.EntityNotFoundException;
import com.springhayth.mediatech.Service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImpl(ModelMapper modelMapper, ClientDao clientDao) {
        this.modelMapper = modelMapper;
        this.clientDao = clientDao;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto requestDto) {
        Client client = modelMapper.map(requestDto, Client.class);
        Client saved = clientDao.save(client);
        return modelMapper.map(saved, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(int id) {
        Client client=clientDao.findById(id).orElseThrow(()->new EntityNotFoundException("Client not found"));
        return modelMapper.map(client, ClientResponseDto.class);

    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        Client client=clientDao.findByNom(nom);
        return modelMapper.map(client, ClientResponseDto.class);
    }

    @Override
    public void delete(int id) {
        clientDao.deleteById(id);
    }

    @Override
    public ClientResponseDto update(int id, ClientRequestDto requestDto) throws EntityNotFoundException {
        Optional<Client> clientOptional = clientDao.findById(id);
        if(clientOptional.isPresent()) {
            Client client = modelMapper.map(requestDto, Client.class);
            client.setId(id);
            Client updatedClient =  clientDao.save(client);
            return modelMapper.map(updatedClient, ClientResponseDto.class);
        }else {
            throw new EntityNotFoundException("Client not found");
        }
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll().stream().map(element->modelMapper.map(element,ClientResponseDto.class)).collect(Collectors.toList());
    }
}
