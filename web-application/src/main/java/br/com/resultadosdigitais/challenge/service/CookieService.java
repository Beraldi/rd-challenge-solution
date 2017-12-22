package br.com.resultadosdigitais.challenge.service;

import br.com.resultadosdigitais.challenge.model.Cookie;

import java.util.Collection;

/**
 * The interface Cookie service.
 */
public interface CookieService {

    /**
     * Find all by cookie id collection.
     *
     * @param cookieId the cookie id
     * @return the collection
     */
    Collection<Cookie> findByCookieId(String cookieId);

    /**
     * Find all collection.
     *
     * @return the collection
     */
    Collection<Cookie> findAll();

    /**
     * Create cookie.
     *
     * @param cookie the cookie
     * @return the cookie
     */
    Cookie create(Cookie cookie);

    /**
     * Update cookie.
     *
     * @param cookie the cookie
     * @return the cookie
     */
    Cookie update(Cookie cookie);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(String id);

}
