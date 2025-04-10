package payk96.rpg_shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import payk96.rpg_shop.clients.KeycloakAuthClient;
import payk96.rpg_shop.config.KeycloakProperties;
import payk96.rpg_shop.dto.KeycloakTokens;
import payk96.rpg_shop.keycloak.repository.KeycloakRolesRepository;
import payk96.rpg_shop.keycloak.repository.UserEntityRepository;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final KeycloakAuthClient authClient;
    private final KeycloakProperties props;

    private final UserEntityRepository userEntityRepository;
    private final KeycloakRolesRepository rolesRepository;

    public KeycloakTokens login(String username, String password) {
        String formData = buildFormData(
                Map.of(
                        "client_id", props.getClient().getId(),
                        "client_secret", props.getClient().getSecret(),
                        "username", username.toLowerCase(),
                        "password", password,
                        "grant_type", "password"
                )
        );

        KeycloakTokens tokens = authClient.login(formData);
        tokens.setIssued_at(System.currentTimeMillis() / 1000);
        return tokens;
    }

    public KeycloakTokens refresh(String refreshToken) {
        String formData = buildFormData(
                Map.of(
                        "client_id", props.getClient().getId(),
                        "client_secret", props.getClient().getSecret(),
                        "refresh_token", refreshToken,
                        "grant_type", "refresh_token"
                )
        );

        KeycloakTokens tokens = authClient.refreshToken(formData);
        tokens.setIssued_at(System.currentTimeMillis() / 1000);
        return tokens;
    }

    private String buildFormData(Map<String, String> params) {
        return params.entrySet().stream()
                .map(e -> e.getKey() + "=" + encode(e.getValue()))
                .collect(Collectors.joining("&"));
    }

    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }
}