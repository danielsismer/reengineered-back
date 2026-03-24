package com.weg.reenginered.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Reenginered API")
                        .description("""
                                ## 📦 Reenginered REST API
                                
                                API for product and category management.
                                
                                ---
                                
                                ### 🚀 Features
                                - Product CRUD with category association
                                - Category CRUD
                                - Product filtering by name and price range
                                
                                ---
                                
                                ### 👥 Team
                                | Name | Role |
                                |------|------|
                                | Daniel Vinicius Rios Simer | Full Developer |
                                | Hugo Deleon Giminiani de Souza Paim  | Full Developer |
                                
                                ---
                                
                                ### 📌 Version History
                                | Version | Description |
                                |---------|-------------|
                                | v1.0.0  | Initial release with Product and Category CRUD |
                                """)
                        .version("v1.0.0")
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                        .contact(new Contact()
                                .name("Reenginered Team")));
    }
}