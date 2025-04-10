package payk96.rpg_shop.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import payk96.rpg_shop.dto.KeycloakTokens;

@FeignClient(
        name = "keycloak-auth-client",
        url = "${keycloak.url}/realms/${keycloak.realm}"
)
public interface KeycloakAuthClient {

    @PostMapping(
            path = "/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded"
    )
    KeycloakTokens login(@RequestBody String formUrlEncoded);

    @PostMapping(
            path = "/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded"
    )
    KeycloakTokens refreshToken(@RequestBody String formUrlEncoded);
}