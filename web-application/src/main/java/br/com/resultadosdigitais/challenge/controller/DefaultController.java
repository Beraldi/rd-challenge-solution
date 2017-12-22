package br.com.resultadosdigitais.challenge.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "RD Challenge Solution";
    }
}
