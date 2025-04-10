package payk96.rpg_shop.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "keycloak")
@Data
public class KeycloakProperties {
    private String url;
    private String realm;
    private Client client;

    @Data
    public static class Client {
        private String id;
        private String secret;
    }
}
