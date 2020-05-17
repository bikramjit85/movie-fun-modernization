package org.superbiz.moviefun;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.superbiz.moviefun.albumsapi.AlbumsClient;
import org.superbiz.moviefun.moviesapi.MoviesClient;

@Configuration
public class ClientConfiguration {

    //@Value("${movies.url}") String moviesUrl;

    //@Value("${albums.url}") String albumUrl;

    @Bean
    public MoviesClient moviesClient(@Qualifier("RestOperations")  RestOperations restOperations) {
        return new MoviesClient("//movie-service/movies", restOperations);
    }


    @Bean
    public AlbumsClient albumsClient(@Qualifier("RestOperations") RestOperations restOperations) {
        return new AlbumsClient("//album-service/albums", restOperations);
    }
}