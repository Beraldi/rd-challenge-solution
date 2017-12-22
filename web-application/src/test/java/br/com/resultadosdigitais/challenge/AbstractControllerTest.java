package br.com.resultadosdigitais.challenge;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The type Abstract controller test.
 */
@WebAppConfiguration
public abstract class AbstractControllerTest extends AbstractTest{

    /**
     * The Mvc.
     */
    protected MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Sets up.
     */
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * Map to json string.
     *
     * @param obj the obj
     * @return the string
     * @throws JsonProcessingException the json processing exception
     */
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    /**
     * Map from json t.
     *
     * @param <T>   the type parameter
     * @param json  the json
     * @param clazz the clazz
     * @return the t
     * @throws IOException the io exception
     */
    protected <T> T mapFromJson(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    /**
     * Gets many.
     *
     * @param <W>        the type parameter
     * @param list       the list
     * @param uri        the uri
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected <W> void getMany(W list, String uri, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        getMany(list, uri, null, httpStatus, hasBody);
    }

    /**
     * Gets many.
     *
     * @param <T>        the type parameter
     * @param <W>        the type parameter
     * @param list       the list
     * @param uri        the uri
     * @param id         the id
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected <T, W> void getMany(W list, String uri, T id, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        getMany(list, uri, id, null, httpStatus, hasBody);
    }

    /**
     * Gets many.
     *
     * @param <T>        the type parameter
     * @param <W>        the type parameter
     * @param <Y>        the type parameter
     * @param list       the list
     * @param uri        the uri
     * @param id         the id
     * @param id2        the id 2
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected <T, W, Y> void getMany(W list, String uri, T id, Y id2, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        getMany(list, uri, id, id2, null, httpStatus, hasBody);
    }

    /**
     * Gets many.
     *
     * @param <T>        the type parameter
     * @param <W>        the type parameter
     * @param <Y>        the type parameter
     * @param <Z>        the type parameter
     * @param list       the list
     * @param uri        the uri
     * @param id         the id
     * @param id2        the id 2
     * @param id3        the id 3
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected <T, W, Y, Z> void getMany(W list, String uri, T id, Y id2, Z id3, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, id, id2, id3).accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        assertEquals("failure - expected HTTP status " + httpStatus.toString(), httpStatus.value(), status);

        if(list != null){
            String sample = mapToJson(list);
            assertEquals("failure - expected HTTP response body to match returned object", sample, content);
        }

        if(hasBody) assertTrue("failure - expected HTTP response body to have a value",
                content.trim().length() > 0);
        else assertTrue("failure - expected HTTP response body to not have a value",
                content.trim().length() == 0);
    }

    /**
     * Gets one.
     *
     * @param <T>        the type parameter
     * @param uri        the uri
     * @param id         the id
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected <T> void getOne(String uri, T id, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        getOne(uri, id, null, httpStatus, hasBody);
    }

    /**
     * Gets one.
     *
     * @param <T>        the type parameter
     * @param <Y>        the type parameter
     * @param uri        the uri
     * @param id         the id
     * @param id2        the id 2
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected <T, Y> void getOne(String uri, T id, Y id2, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        getOne(uri, id, id2, null, httpStatus, hasBody);
    }

    /**
     * Gets one.
     *
     * @param <T>        the type parameter
     * @param <Y>        the type parameter
     * @param <Z>        the type parameter
     * @param uri        the uri
     * @param id         the id
     * @param id2        the id 2
     * @param id3        the id 3
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected <T, Y, Z> void getOne(String uri, T id, Y id2, Z id3, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        getOne(uri, id, id2, id3, null, httpStatus, hasBody);
    }

    /**
     * Gets one.
     *
     * @param <T>        the type parameter
     * @param <W>        the type parameter
     * @param <Y>        the type parameter
     * @param <Z>        the type parameter
     * @param uri        the uri
     * @param id         the id
     * @param id2        the id 2
     * @param id3        the id 3
     * @param id4        the id 4
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected <T, W, Y, Z> void getOne(String uri, T id, W id2, Y id3, Z id4, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri, id, id2, id3, id4).accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        assertEquals("failure - expected HTTP status " + httpStatus.toString(), httpStatus.value(), status);

        if(hasBody) assertTrue("failure - expected HTTP response body to have a value",
                0 < content.trim().length());
        else assertTrue("failure - expected HTTP response body to not have a value",
                0 == content.trim().length());
    }

    /**
     * Update one.
     *
     * @param uri        the uri
     * @param inputJson  the input json
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected void updateOne(String uri, String inputJson, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.put(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        assertEquals("failure - expected HTTP status " + httpStatus.toString(), httpStatus.value(), status);
        if(hasBody) assertTrue("failure - expected HTTP response body to have a value",
                0 < content.trim().length());
        else assertTrue("failure - expected HTTP response body to not have a value",
                0 == content.trim().length());
    }

    /**
     * Delete one.
     *
     * @param <T>        the type parameter
     * @param uri        the uri
     * @param id         the id
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected  <T> void deleteOne(String uri, T id, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.delete(uri, id)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        assertEquals("failure - expected HTTP status " + httpStatus.toString(), httpStatus.value(), status);
        if (hasBody) assertTrue("failure - expected HTTP response body to not be empty",
                content.trim().length() > 0);
        else assertTrue("failure - expected HTTP response body to be empty",
                content.trim().length() == 0);
    }

    /**
     * Create one.
     *
     * @param uri        the uri
     * @param inputJson  the input json
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected void createOne(String uri, String inputJson, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        assertEquals("failure - expected HTTP status " +httpStatus.toString(), httpStatus.value(), status);
        if (hasBody) assertTrue("failure - expected HTTP response body to have a value",
                content.trim().length() > 0);
        else assertTrue("failure - expected HTTP response body to be empty",
                content.trim().length() == 0);
    }

    /**
     * Create one get.
     *
     * @param uri        the uri
     * @param inputJson  the input json
     * @param httpStatus the http status
     * @param hasBody    the has body
     * @throws Exception the exception
     */
    protected void createOneGet(String uri, String inputJson, HttpStatus httpStatus, Boolean hasBody) throws Exception {
        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        assertEquals("failure - expected HTTP status " +httpStatus.toString(), httpStatus.value(), status);
        if (hasBody) assertTrue("failure - expected HTTP response body to have a value",
                content.trim().length() > 0);
        else assertTrue("failure - expected HTTP response body to be empty",
                content.trim().length() == 0);
    }
}
