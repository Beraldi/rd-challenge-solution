package br.com.resultadosdigitais.challenge.repository;

import br.com.resultadosdigitais.challenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    /**
     * Find all by member id collection.
     *
     * @param id the id
     * @return the collection
     */
    @Query("Select u from User u where u.id = :id")
    Collection<User> findByUserId(@Param("id") long id);

}
