package br.edu.unoesc.desafiofullstackunoesc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class DesafioFullstackUnoescApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFullstackUnoescApplication.class, args);		
	}
}
