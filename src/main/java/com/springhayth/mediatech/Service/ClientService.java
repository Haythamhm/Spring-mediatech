package com.springhayth.mediatech.Service;

import com.springhayth.mediatech.Dto.ClientRequestDto;
import com.springhayth.mediatech.Dto.ClientResponseDto;

import java.util.List;

public interface ClientService {

    ClientResponseDto save(ClientRequestDto requestDto);
    ClientResponseDto findById(int id);
    ClientResponseDto findByNom(String nom);

    void delete(int id);

    ClientResponseDto update(int id, ClientRequestDto requestDto);

    List<ClientResponseDto> findAll();
}
