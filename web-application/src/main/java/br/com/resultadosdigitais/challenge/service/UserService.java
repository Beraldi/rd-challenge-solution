package br.com.resultadosdigitais.challenge.service;

import br.com.resultadosdigitais.challenge.model.User;

import java.util.Collection;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Find all by user id collection.
     *
     * @param userId the user id
     * @return the collection
     */
    Collection<User> findByUserId(long userId);

    /**
     * Find all collection.
     *
     * @return the collection
     */
    Collection<User> findAll();

    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     */
    User create(User user);

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    User update(User user);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(long id);

}
