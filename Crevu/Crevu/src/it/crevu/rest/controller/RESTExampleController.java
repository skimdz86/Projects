package it.crevu.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class RESTExampleController {

	//occhio che il @ResponseBody � INDISPENSABILE: altrimenti va in loop e stackoverflow perch� tenta di risolvere l'output come url
	//oppure usare void come tipo di ritorno, senza annotazioni
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public @ResponseBody String getExample(@PathVariable String name){
		return name+": Servizio riuscito!";
	}
}
