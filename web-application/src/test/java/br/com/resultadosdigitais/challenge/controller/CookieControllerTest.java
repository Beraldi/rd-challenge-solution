package br.com.resultadosdigitais.challenge.controller;

import br.com.resultadosdigitais.challenge.AbstractControllerTest;
import br.com.resultadosdigitais.challenge.model.Cookie;
import br.com.resultadosdigitais.challenge.service.CookieService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * The type Cookie controller test.
 */
public class CookieControllerTest extends AbstractControllerTest {

    @Mock
    private CookieService service;

    @InjectMocks
    private CookieController controller;

    private String uri = "/cookie";

    @Before
    public void setUp() {
        initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    /**
     * Sets cookie.
     *
     * @throws Exception the exception
     */
    @Test
    public void setCookie() throws Exception {
        logger.info("> " + getMethodName());
        Cookie cookie = CookieSetUp(true);
        when(service.create(any(Cookie.class))).thenReturn(cookie);
        String inputJson = super.mapToJson(cookie);
        createOneGet(uri+"/track", inputJson, HttpStatus.CREATED, true);
        verify(service, times(1)).create(any(Cookie.class));
    }

    /**
     * Find by id.
     *
     * @throws Exception the exception
     */
    @Test
    public void findById() throws Exception {
        logger.info("> " + getMethodName());

        Collection<Cookie> cookieCollection = CookieCollectionSetUp(true);

        when(service.findByCookieId(uuid)).thenReturn(cookieCollection);

        getMany(cookieCollection, uri + "/{cid}", uuid, HttpStatus.OK, true);

        verify(service, times(1)).findByCookieId(uuid);
    }
}