package br.com.alura.rodizi_de_veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class RodiziDeVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RodiziDeVeiculosApplication.class, args);
//		System.out.println(new BCryptPasswordEncoder().encode("admin"));
	}

}
