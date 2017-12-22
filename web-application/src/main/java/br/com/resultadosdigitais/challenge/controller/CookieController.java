package br.com.resultadosdigitais.challenge.controller;


import br.com.resultadosdigitais.challenge.model.Cookie;
import br.com.resultadosdigitais.challenge.service.CookieService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping("/cookie")
public class CookieController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private CookieService cookieService;

    /**
     * Sets cookie.
     *
     * @param cid the cid
     * @param url the url
     * @return the cookie
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/track", method = RequestMethod.GET)
    public ResponseEntity<Cookie> setCookie(@RequestParam(value = "cid") final String cid, @RequestParam(value = "url")  final String url) {

        Cookie cookie = new Cookie();
        cookie.setUuid(cid);
        cookie.setUrl(url);

        logger.info(cookieService.create(cookie).toString());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Find by id response entity.
     *
     * @param cid the cid
     * @return the response entity
     */
    @CrossOrigin(origins = "http://localhost:3004")
    @RequestMapping(value = "/{cid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cookie>> findById(@PathVariable("cid") String cid) {
        return new ResponseEntity<>(cookieService.findByCookieId(cid), HttpStatus.OK);
    }

}