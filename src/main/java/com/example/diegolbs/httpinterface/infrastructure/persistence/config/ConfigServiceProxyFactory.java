package com.example.diegolbs.httpinterface.infrastructure.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Configuration
public class ConfigServiceProxyFactory {

    @Bean
    ConfigEnderecoClient enderecoClient() {
        var webClient = WebClient.builder()
                        .defaultStatusHandler(HttpStatusCode::isError,
                                resp -> Mono.just(new RuntimeException("Endereco não encontrado!")))
                        .baseUrl("https://viacep.com.br/ws")
                        .build();
        var factory = HttpServiceProxyFactory.builder(
                WebClientAdapter.forClient(webClient))
                .build();
        return factory.createClient(ConfigEnderecoClient.class);
    }
}
