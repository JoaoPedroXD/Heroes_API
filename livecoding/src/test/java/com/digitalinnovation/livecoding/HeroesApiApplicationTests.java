package com.digitalinnovation.livecoding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinnovation.livecoding.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class HeroesApiApplicationTests {
    @Autowired
    WebTestClient webTestClient;

    @Test
    //Testa se um herói válido é retornado do banco pela API
    public void getOneHeroeById() {
        webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "10")
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

    @Test
    //Testa se irá retornar um exceção ao informar um herói não cadastrado
    public void getOneHeronotFound() {
        webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "10")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    //Testa se irá deletar o herói com o ID informado
    public void deleteHero() {
        webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), "1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(Void.class);
    }
}


