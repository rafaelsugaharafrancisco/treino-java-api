package br.com.alura.rodizi_de_veiculos.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alura.rodizi_de_veiculos.models.Usuario;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//localhost:8080/swagger-ui.html
@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket RodizioDeVeiculosApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.alura.rodizi_de_veiculos"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(Usuario.class)
				.globalOperationParameters(
						Arrays.asList(
								new ParameterBuilder()
									.name("Authorization")
									.description("Header para token JWT")
									.modelRef(new ModelRef("string"))
									.parameterType("header")
									.required(false)
									.build()));
	}
}
