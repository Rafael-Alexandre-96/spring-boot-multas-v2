package br.com.gris.grisestrela.configs;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

  /*@Value("${rafaelalexandre.openapi.dev-url}")
  private String devUrl;

  @Value("${rafaelalexandre.openapi.prod-url}")
  private String prodUrl;*/
  
  @Bean
  public OpenAPI myOpenAPI() {
    /*Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");

    Server prodServer = new Server();
    prodServer.setUrl(prodUrl);
    prodServer.setDescription("Server URL in Production environment");*/

    Contact contact = new Contact();
    contact.setEmail("rafael.alexandre.1996.ra@gmail.com");
    contact.setName("Rafael Alexandre");
    //contact.setUrl("https://www.rafaelalexandre.com");

    //License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

    Info info = new Info()
        .title("GRIS Multas - API")
        .version("1.0")
        .contact(contact)
        .description("Endpoints da API GRIS Multas");//.termsOfService("https://www.rafaelalexandre.com/terms")
        //.license(mitLicense);

    return new OpenAPI().info(info);//.servers(List.of(devServer, prodServer));
  }
  
}
