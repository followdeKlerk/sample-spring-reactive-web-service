package org.console.reactiveweb.client;

import org.console.reactiveweb.entity.Farewell;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class FarewellClient {

  private final WebClient client;

  public FarewellClient(WebClient.Builder builder) {
    this.client = builder.baseUrl("http://localhost:8080").build();
  }

  public Mono<String> getMessage() {
    return this.client.get().uri("/farewell").accept(MediaType.APPLICATION_JSON).retrieve()
        .bodyToMono(Farewell.class).map(Farewell::getMessage);
  }
}
