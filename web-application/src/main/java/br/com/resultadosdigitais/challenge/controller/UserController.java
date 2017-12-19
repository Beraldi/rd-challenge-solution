package br.com.resultadosdigitais.challenge.controller;


import br.com.resultadosdigitais.challenge.model.User;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * The type User controller.
 */
@RestController()
@RequestMapping("/user")
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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<User> setUserWithId(@RequestParam(value = "cid") final UUID id, @RequestParam(value = "url")  final String url, @RequestParam(value = "email", required = false) final String email) {

        final User user = new User(id, url, new Date(), emailValidator.isValid(email) ? email : "");

        loggerInfo(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Sets user.
     *
     * @param url   the url
     * @param email the email
     * @return the user
     */
    @RequestMapping(value = "/track", method = RequestMethod.GET)
    public ResponseEntity<UUID> setUser(@RequestParam(value = "url")  final String url, @RequestParam(value = "email", required = false) final String email) {

        final User user = new User(url, new Date(), emailValidator.isValid(email) ? email : "");

        loggerInfo(user);

        return new ResponseEntity<>(user.getId(), HttpStatus.OK);
    }

    private void loggerInfo(User user) {
        logger.info("user=[" + user.toString() + "]");

        logger.info(String.format("id=[%s] url=[%s] date=[%s]", user.getId(), user.getUrl(), user.getDateTime()));
    }

}
