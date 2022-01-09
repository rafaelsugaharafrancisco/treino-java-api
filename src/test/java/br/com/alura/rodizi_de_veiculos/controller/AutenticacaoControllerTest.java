package br.com.alura.rodizi_de_veiculos.controller;

import java.net.URI;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("teste")
class AutenticacaoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	private static String json;
	
	private static URI uri;

	@BeforeAll
	static void inicio() throws Exception {
		
		uri = new URI("/auth");
		
		JSONObject jo = new JSONObject();
		jo.put("email", "email@email.com");
		jo.put("senha", "1234");

		json = jo.toString();
	}
	
	@Test
	void verificaRetornoBadRequest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
	}

}
