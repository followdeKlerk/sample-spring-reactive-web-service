package org.console.reactiveweb;

import org.console.reactiveweb.client.FarewellClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.console.reactiveweb.client.GreetingClient;

@SpringBootApplication
public class ReactiveWebServiceApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(ReactiveWebServiceApplication.class, args);

    GreetingClient greetingClient = context.getBean(GreetingClient.class);

    FarewellClient farewellClient = context.getBean(FarewellClient.class);

    System.out.println("Message: " + greetingClient.getMessage().block());
    System.out.println("Message: " + farewellClient.getMessage().block());
  }

}
