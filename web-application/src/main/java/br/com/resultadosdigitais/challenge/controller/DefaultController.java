package br.com.resultadosdigitais.challenge.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The type Default controller.
 */
@Controller
public class DefaultController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Home string.
     *
     * @return the string
     */
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "RD Challenge Solution";
    }
}
