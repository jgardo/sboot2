package pl.jgardo.counter.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Service
public class CounterClient {
    private WebClient client = WebClient.create("http://localhost:8080");

    public Mono<Long> count(Long value) {
        if (value == 0L) {
            return Mono.just(0L);
        }
        return client.get()
                .uri("/counter/{value}", value)
                .accept(APPLICATION_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(Long.class));
    }
}
