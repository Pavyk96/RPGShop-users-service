package payk96.rpg_shop.keycloak.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserRoleMappingId.class)
@Table(name = "user_role_mapping")
public class UserRoleMapping {

    @Id
    @Column(name = "role_id")
    private String roleId;

    @Id
    @Column(name = "user_id")
    private String userId;

}
