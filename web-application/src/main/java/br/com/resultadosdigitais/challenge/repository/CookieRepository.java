package br.com.resultadosdigitais.challenge.repository;

import br.com.resultadosdigitais.challenge.model.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * The interface Cookie repository.
 */
@Repository
public interface CookieRepository extends JpaRepository<Cookie, Long> {

    /**
     * Find all by member id collection.
     *
     * @param uuid the uuid
     * @return the collection
     */
    @Query("Select c from Cookie c where c.uuid = :uuid order by c.datetime desc")
    Collection<Cookie> findByCookieId(@Param("uuid") String uuid);

}
