package org.console.reactiveweb.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.console.reactiveweb.handler.FarewellHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class FarewellRouter {

  @Bean
  public RouterFunction<ServerResponse> farewellRoute(FarewellHandler farewellHandler) {
     return RouterFunctions
         .route(GET("/farewell")
             .and(accept(MediaType.APPLICATION_JSON)), farewellHandler::farewell);
  }

}
