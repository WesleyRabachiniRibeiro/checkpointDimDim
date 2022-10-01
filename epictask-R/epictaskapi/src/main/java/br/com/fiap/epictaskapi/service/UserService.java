package br.com.fiap.epictaskapi.service;

import br.com.fiap.epictaskapi.dto.SearchUserDto;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Page<User> listAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User findUser(@PathVariable Long id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new EntityNotFoundException("User Not Found!"));
    }

    public User updateUser(SearchUserDto updatedUser, Long id){
        User user = this.findUser(id);
        user.setEmail(updatedUser.getEmail());
        user.setName(updatedUser.getName());
        return repository.save(user);
    }

    public void deleteUser(@PathVariable Long id){
        User user = this.findUser(id);
        repository.delete(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return repository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with username: " + username));
    }
}
