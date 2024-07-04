package com.forohub.forohub.domain.infra.jackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();

        // Configuración para ignorar los proxies Hibernate
        objectMapper.registerModule(new SimpleModule().addSerializer(HibernateProxy.class, new HibernateProxySerializer()));

        return objectMapper;
    }
}
