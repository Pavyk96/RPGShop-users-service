package payk96.rpg_shop.service;

import payk96.rpg_shop.dto.KeycloakTokens;

public interface AuthService {
    KeycloakTokens login(String username, String password);
    KeycloakTokens refresh(String refreshToken);
}
