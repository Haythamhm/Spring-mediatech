package com.springhayth.mediatech.Controller;

import com.springhayth.mediatech.Dto.ClientRequestDto;
import com.springhayth.mediatech.Dto.ClientResponseDto;
import com.springhayth.mediatech.Exceptions.EntityNotFoundException;
import com.springhayth.mediatech.Service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClientResponseDto>> getClient(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody ClientRequestDto clientRequestDto){
        ClientResponseDto responseDto = clientService.save(clientRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ClientResponseDto> findByNom(@PathVariable String nom) {
        ClientResponseDto clientResponseDto = clientService.findByNom(nom);
        return ResponseEntity.ok(clientResponseDto);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> update(@Valid @PathVariable int id, @RequestBody ClientRequestDto requestDto) throws EntityNotFoundException {
        ClientResponseDto clientResponseDto = clientService.update(id, requestDto);
        return ResponseEntity.accepted().body(clientResponseDto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable int id) {
        ClientResponseDto clientResponseDto = clientService.findById(id);
        return ResponseEntity.ok(clientResponseDto);
    }
}
