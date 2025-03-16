package org.luisalbertocodes.crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "org.luisalbertocodes.crud")
@Import({WebConfig.class, DatabaseConfig.class})
public class AppConfig {
    // Configuración global de la aplicación
}