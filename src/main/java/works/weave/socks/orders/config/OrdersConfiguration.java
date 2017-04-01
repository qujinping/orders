package works.weave.socks.orders.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrdersConfiguration {
    @Value("${server.payment.host}") 
    private String paymentHost;

    @Value("${server.shipping.host}") 
    private String shippingHost;

    @Value("${server.domain}") 
    private String domain;

    @Bean
    @ConditionalOnMissingBean(OrdersConfigurationProperties.class)
    public OrdersConfigurationProperties frameworkMesosConfigProperties() {
        return new OrdersConfigurationProperties(domain, paymentHost, shippingHost);
    }
}
