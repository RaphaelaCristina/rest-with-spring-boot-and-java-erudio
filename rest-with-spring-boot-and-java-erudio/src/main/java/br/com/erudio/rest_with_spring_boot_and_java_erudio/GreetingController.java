package br.com.erudio.rest_with_spring_boot_and_java_erudio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//DIFERENTE DA APLICAÇÃO WEB, A APLICAÇÃO REST RETORNA APENAS OS DADOS NA FORMA DE JSON, XML OU OUTRO CONTENT TYPE

@RestController //Combinação das annotations @ResponseBody e @Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    //Método responsável por devolver o endpoint Greeting
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template,name)); //A cada chamada será gerado um id maior através do incrementAndGet()
    }

}
