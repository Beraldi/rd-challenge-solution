package br.com.resultadosdigitais.challenge.controller;


import br.com.resultadosdigitais.challenge.model.User;
import br.com.resultadosdigitais.challenge.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * The type User controller.
 */
@RestController()
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @CrossOrigin(origins = "http://localhost:3004")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> findById(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.findByUserId(id), HttpStatus.OK);
    }

    /**
     * Create user by form response entity.
     *
     * @param user the user
     * @return the response entity
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/form", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUserByForm(@RequestBody User user) {
        User newUser = userService.create(user);

        logger.info(newUser.toString());

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}