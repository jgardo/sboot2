package pl.jgardo.counter.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.jgardo.counter.controller.CounterClient;
import reactor.core.publisher.Mono;

@RestController
public class CounterController {

    private final CounterClient counterClient;

    public CounterController(CounterClient counterClient) {
        this.counterClient = counterClient;
    }

    @GetMapping("/counter/{value}")
    public Mono<Long> count(@PathVariable("value") Long value) {
        return counterClient.count(value - 1)
                .map(v -> v + 1);
    }
}
