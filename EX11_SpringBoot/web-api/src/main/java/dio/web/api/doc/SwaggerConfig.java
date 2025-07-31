package dio.web.api.doc;


import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Title - Rest API")
                        .description("Api exemplo de uso Spring Boot REST API")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Seu nome")
                                .url("http://www.seusite.com.br")
                                .email("voce@seusite.com.br")
                        )
                        .termsOfService("Termos de uso: Open Source")
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Licenca - Sua Empresa")
                                .url("http://www.seusite.com.br")
                        )
                );
    }
}
