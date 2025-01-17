package com.weplus.app.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//permette di raggiungere le api dal frontend (piomme)

@Configuration
public class RichiesteCORS implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applica il CORS a tutti gli endpoint
                .allowedOrigins("http://localhost:3000") // Specifica l'origine del frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Metodi HTTP consentiti
                .allowedHeaders("*") // Header consentiti
                .allowCredentials(true); // Consente l'invio di cookie o credenziali
    }
}
