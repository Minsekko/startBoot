package org.codenova.start.controller;

import org.codenova.start.model.Pokemon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @GetMapping("/example/01")
    public String example01Handle(Model model) {
        String[] keywords = new String[] {"도전","기회","성장","행운","인내","집중","열정","자신감","전환"};

        model.addAttribute("keyword",keywords[(int)(Math.random()*keywords.length)]);
        model.addAttribute("number",(int)(Math.random()*10)+1);

        model.addAttribute("message","<script>alert('??');</script>");

        return "thymeleaf/example/01";
    }
    @GetMapping("/example/02")
    public String example02Handle(Model model) {
        Pokemon pokemon = Pokemon.builder()
                                 .name("이상해씨")
                                 .type("풀")
                                 .id(1)
                                 .imageUrl("https://data1.pokemonkorea.co.kr/newdata/pokedex/full/000101.png")
                                 .unique(false)
                                 .build();
        model.addAttribute("pokemon",pokemon);
        model.addAttribute("role","admin");

        return "thymeleaf/example/02";
    }

    @GetMapping("/example/03")
    public String example03Handle(Model model) {
        List<String> names = List.of("이상해씨","파이리","피카츄","꼬부기");
        model.addAttribute("names",names);

        return "thymeleaf/example/03";
    }

    @GetMapping("/example/04")
    public String example04Handle(Model model) {
        List<Pokemon> pokemons = List.of(
                Pokemon.builder().id(37).name("피카츄").imageUrl("https://data1.pokemonkorea.co.kr/newdata/pokedex/full/002501.png").type("전기").build(),
                Pokemon.builder().id(6).name("파이리").imageUrl("https://data1.pokemonkorea.co.kr/newdata/pokedex/full/000401.png").type("파이리").build(),
                Pokemon.builder().id(12).name("꼬부기").imageUrl("https://data1.pokemonkorea.co.kr/newdata/pokedex/full/000701.png").type("꼬부기").build(),
                Pokemon.builder().id(1).name("이상해씨").imageUrl("https://data1.pokemonkorea.co.kr/newdata/pokedex/full/000101.png").type("풀").build()
        );
        model.addAttribute("pokemons", pokemons);

        return "thymeleaf/example/04";
    }
}
