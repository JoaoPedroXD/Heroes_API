package com.digitalinnovation.livecoding.service;

import com.digitalinnovation.livecoding.document.Heroes;
import com.digitalinnovation.livecoding.repository.HeroesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {
    //Classe do repositório
    private final HeroesRepository heroesRepository;

    //Construtor
    public HeroesService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    //Pega todos os heróis
    public Flux<Heroes> findAll() {
        return Flux.fromIterable(this.heroesRepository.findAll());
    }

    //Pega um herói pelo seu ID
    public Mono<Heroes> findByIdHero(String id) {
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }

    //Registra um novo herói
    public Mono<Heroes> save(Heroes heroes) {
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }

    //Deleta um herói pelo ID
    public Mono<Boolean> deletebyIDHero(String id) {
        heroesRepository.deleteById(id);
        return Mono.just(true);
    }
}

