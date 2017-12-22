package br.com.resultadosdigitais.challenge.service;

import br.com.resultadosdigitais.challenge.model.Cookie;
import br.com.resultadosdigitais.challenge.repository.CookieRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * The type Cookie service bean.
 */
@Service
public class CookieServiceBean implements CookieService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private CookieRepository cookieRepository;

    @Override
    public Collection<Cookie> findByCookieId(String cookieId) {
        return cookieRepository.findByCookieId(cookieId);
    }

    @Override
    public Collection<Cookie> findAll() {
        return cookieRepository.findAll();
    }

    @Override
    public Cookie create(Cookie cookie) {
        return cookieRepository.save(cookie);
    }

    @Override
    public Cookie update(Cookie cookie) {
        return cookieRepository.save(cookie);
    }

    @Override
    public void delete(String id) {
        cookieRepository.delete(this.findByCookieId(id));
    }
}
