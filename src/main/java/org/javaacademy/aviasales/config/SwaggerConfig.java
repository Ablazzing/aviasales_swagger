package org.javaacademy.aviasales.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Value("${spring.profiles.active}")
    private String profiles;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Тестовый сервер");

        Server prodServer = new Server();
        prodServer.setUrl("http://localhost:8081");
        prodServer.setDescription("Сервер прод");

        Contact contact = new Contact();
        contact.setEmail("test@gmail.com");
        contact.setName("Юрий Молодыко");
        contact.setUrl("https://www.java-academy.ru");
//
        Info info = new Info()
                .title("Api Сервиса по бронированию билетов")
                .version("1.0")
                .contact(contact)
                .description("Апи по бронированию билетов\n"
                             + "Имя профилей спринга: " + profiles);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer));
    }
}
