package uz.pdp.project_management_front_end.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
}
