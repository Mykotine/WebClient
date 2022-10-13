package com.example.webclient.Service;

import com.example.webclient.Model.RickAndMortyCharacter;
import com.example.webclient.Model.RickAndMortyResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class RickAndMortyService {

private WebClient client = WebClient.create("https://rickandmortyapi.com/api");
//    public List<RickAndMortyCharacter> getAllCharacters(){
//    RickAndMortyResponse rickAndMortyResponse =
//            client.get()
//            .uri("/character")
//            .retrieve()
//            .toEntity(RickAndMortyResponse.class)
//            .block()
//            .getBody();
//
//            return rickAndMortyResponse.getResults();
//    }

    public List<RickAndMortyCharacter> getAllLivingCharacters(String status){
        String uri;
        if(status == null){
            uri = "/character";
        } else {
            uri = "/character?status="+status;
        }
        RickAndMortyResponse rickAndMortyResponse =
                client.get()
                        .uri(uri)
                        .retrieve()
                        .toEntity(RickAndMortyResponse.class)
                        .block()
                        .getBody();

        return rickAndMortyResponse.getResults();
    }

}
