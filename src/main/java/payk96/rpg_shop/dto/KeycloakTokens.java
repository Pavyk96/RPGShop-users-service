package payk96.rpg_shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KeycloakTokens {
    private String access_token;
    private String refresh_token;
    private String token_type;
    private int expires_in;
    private long issued_at;

    public boolean isExpired() {
        return (System.currentTimeMillis() / 1000) > (issued_at + expires_in - 30);
    }
}
