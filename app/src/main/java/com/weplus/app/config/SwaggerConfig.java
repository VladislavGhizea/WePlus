package com.weplus.app.config;

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
                        .title("WorkHub")
                        .version("1.0.0")
                        .description("""
                                API per la gestione di una piattaforma che connette lavoratori e aziende. 
                                Funzionalità principali:
                                - Gestione di diversi tipi di account: Persona Fisica, Persona Giuridica, Liberi Professionisti.
                                - Visualizzazione e interazione personalizzata per ogni account.
                                
                                Questa documentazione fornisce una panoramica delle operazioni supportate per garantire 
                                una connessione efficace e senza interruzioni tra lavoratori e aziende.
                                """));
    }
}
