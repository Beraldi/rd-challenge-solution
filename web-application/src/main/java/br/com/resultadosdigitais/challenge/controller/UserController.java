package br.com.resultadosdigitais.challenge.controller;


import br.com.resultadosdigitais.challenge.model.Cookie;
import br.com.resultadosdigitais.challenge.model.User;
import br.com.resultadosdigitais.challenge.service.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

/**
 * The type User controller.
 */
@RestController()
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/allusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> findById(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.findByUserId(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/form", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUserByForm(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/track", method = RequestMethod.GET)
    public ResponseEntity<Cookie> setCookie(@RequestParam(value = "cid") final String cid, @RequestParam(value = "url")  final String url) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}