package com.example.herokudemo;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.properties.ssl.truststore.type}")
    private String truststoreType;

    @Value("${spring.kafka.properties.ssl.truststore.certificates}")
    private String trustedCertificates;

    @Value("${spring.kafka.properties.ssl.keystore.type}")
    private String keystoreType;

    @Value("${spring.kafka.properties.ssl.keystore.key}")
    private String keystoreKey;

    @Value("${spring.kafka.properties.ssl.keystore.certificate}")
    private String keystoreCertificate;

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        // Configure SSL properties
        configProps.put("security.protocol", "SSL");
        configProps.put("ssl.truststore.type", truststoreType);
        configProps.put("ssl.truststore.certificates", trustedCertificates);
        configProps.put("ssl.keystore.type", keystoreType);
        configProps.put("ssl.keystore.key", keystoreKey);
        configProps.put("ssl.keystore.certificate", keystoreCertificate);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
