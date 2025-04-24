package payk96.rpg_shop.keycloak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payk96.rpg_shop.keycloak.model.KeycloakRole;

@Repository
public interface KeycloakRolesRepository extends JpaRepository<KeycloakRole, String> {
}

