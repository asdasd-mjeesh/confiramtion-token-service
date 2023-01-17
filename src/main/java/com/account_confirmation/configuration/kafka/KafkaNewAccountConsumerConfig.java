package com.account_confirmation.configuration.kafka;

import com.account_confirmation.model.dto.kafka.consumer.NewAccount;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaNewAccountConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServerUrl;

    public Map<String, Object> newAccountConsumerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerUrl);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TYPE_MAPPINGS, "newAccount:com.account_confirmation.model.dto.kafka.consumer.NewAccount");
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return props;
    }

    @Bean
    public ConsumerFactory<String, NewAccount> newAccountConfirmationConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(newAccountConsumerConfig());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, NewAccount>> newAccountConfirmationListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, NewAccount> listenerContainerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();
        listenerContainerFactory.setConsumerFactory(this.newAccountConfirmationConsumerFactory());
        return listenerContainerFactory;
    }
}
