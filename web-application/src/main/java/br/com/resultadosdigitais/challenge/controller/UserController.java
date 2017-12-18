package br.com.resultadosdigitais.challenge.controller;


import br.com.resultadosdigitais.challenge.model.User;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * The type User controller.
 */
@RestController
public class UserController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private EmailValidator emailValidator = EmailValidator.getInstance();

    /**
     * Sets user with id.
     *
     * @param id    the id
     * @param url   the url
     * @param email the email
     * @return the user with id
     */
    @RequestMapping("/user/{id}")
    public ResponseEntity<User> setUserWithId(@PathVariable() final UUID id, @PathVariable() final String url, final String email) {

        final User user = new User(id, url, new Date(), emailValidator.isValid(email) ? email : "");

        logger.info("user=[" + user.toString() + "]");

        logger.info(String.format("id=[%s] url=[%s] date=[%s]", user.getId(), user.getUrl(), user.getDateTime()));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Sets user.
     *
     * @param url   the url
     * @param email the email
     * @return the user
     */
    @RequestMapping("/user")
    public ResponseEntity<UUID> setUser(@PathVariable() final String url, final String email) {

        final User user = new User(url, new Date(), email);

        logger.info("user=[" + user.toString() + "]");

        logger.info(String.format("id=[%s] url=[%s] date=[%s] email=[%s]", user.getId(), user.getUrl(), user.getDateTime(), user.getEmail()));

        return new ResponseEntity<>(user.getId(), HttpStatus.OK);
    }

}
