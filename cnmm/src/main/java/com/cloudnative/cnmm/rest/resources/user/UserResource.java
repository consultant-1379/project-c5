package com.cloudnative.cnmm.rest.resources.user;

import com.cloudnative.cnmm.data.models.user.User;
import com.cloudnative.cnmm.data.models.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = repo.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable String id) {
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/name")
    public ResponseEntity<?> getUserByFullName(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        User user = repo.findByFirstNameAndLastName(firstName, lastName);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User newUser) {
        User savedUser = repo.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        repo.deleteById(id);
    }
}
