package com.example.webclient.Controller;


import com.example.webclient.Model.RickAndMortyCharacter;
import com.example.webclient.Model.RickAndMortyResponse;
import com.example.webclient.Service.RickAndMortyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RickAndMortyController {

    RickAndMortyService rickAndMortyService;

    public RickAndMortyController(RickAndMortyService rickAndMortyService) {
        this.rickAndMortyService = rickAndMortyService;
    }


//    @GetMapping("/characters")
//    public List<RickAndMortyCharacter> getAllCharacters(){
//
//        return rickAndMortyService.getAllCharacters();
//    }

    @GetMapping("/characters")
    public List<RickAndMortyCharacter> getAllLivingCharachters(@RequestParam(required = false) String status){
        return rickAndMortyService.getAllLivingCharacters(status);
    }

}
