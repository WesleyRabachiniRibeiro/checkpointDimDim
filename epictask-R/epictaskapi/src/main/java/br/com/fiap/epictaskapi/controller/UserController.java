package br.com.fiap.epictaskapi.controller;

import br.com.fiap.epictaskapi.dto.RegistryUserDto;
import br.com.fiap.epictaskapi.dto.SearchUserDto;
import br.com.fiap.epictaskapi.mappers.UserMapper;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    private final UserService service;

    private UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RegistryUserDto> saveUser(@RequestBody @Valid RegistryUserDto dto){
        try {
            service.saveUser(UserMapper.fromDTO(dto));
            return new ResponseEntity<RegistryUserDto>(dto, HttpStatus.CREATED);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping
    public ResponseEntity<Page<SearchUserDto>> findAllUsers(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(service.listAll(pageable).map(UserMapper::fromEntity));
    }

    @GetMapping("{id}")
    public ResponseEntity<SearchUserDto> searchUser(@PathVariable Long id){
        try{
            User user = service.findUser(id);
            return ResponseEntity.ok(UserMapper.fromEntity(user));
        }catch (RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<SearchUserDto> updateUser(@RequestBody SearchUserDto dto, @PathVariable Long id){
        try{
            service.updateUser(dto, id);
            return ResponseEntity.ok(dto);
        }catch (RuntimeException ex){
            ex.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SearchUserDto> deleteUser(@PathVariable Long id){
        try{
            service.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (RuntimeException ex){
            return ResponseEntity.notFound().build();
        }
    }
}