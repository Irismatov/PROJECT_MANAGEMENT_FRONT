package uz.pdp.project_management_front_end.domain.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.project_management_front_end.domain.enumerators.Permission;
import uz.pdp.project_management_front_end.domain.enumerators.UserRole;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
    private List<Permission> permissions;
}
