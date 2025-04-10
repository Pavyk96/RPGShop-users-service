package payk96.rpg_shop.keycloak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import payk96.rpg_shop.keycloak.model.KeycloakRole;

@Repository
public interface KeycloakRolesRepository extends JpaRepository<KeycloakRole, String> {
    /**
     * Находит ID роли с именем "company"
     * @return ID роли или null, если не найдено
     */
    @Query("SELECT r.id FROM KeycloakRole r WHERE r.name = 'company'")
    String findCompanyRoleId();

    /**
     * Находит ID роли с именем "user"
     * @return ID роли или null, если не найдено
     */
    @Query("SELECT r.id FROM KeycloakRole r WHERE r.name = 'user'")
    String findUserRoleId();

    KeycloakRole findRoleByName(String name);
}

