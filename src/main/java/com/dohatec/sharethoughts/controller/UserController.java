package com.dohatec.sharethoughts.controller;

import com.dohatec.sharethoughts.exception.UserNotFoundException;
import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.model.User;
import com.dohatec.sharethoughts.model.UserDTO;
import com.dohatec.sharethoughts.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/all")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("getting all the users");
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        logger.info("Creating a new user");
        User user1 = userService.createNewUser(user);
        return  new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id){
        logger.info("Getting a user with their ID");
        User user = userService.findByUserWithId(id);
        if(user == null){
            throw new UserNotFoundException();
        }
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUsersWithId(@PathVariable int id) {
        logger.info("Deleting a user based on the provided ID");
        if(userService.findByUserWithId(id) == null){
            throw new UserNotFoundException();
        }
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
