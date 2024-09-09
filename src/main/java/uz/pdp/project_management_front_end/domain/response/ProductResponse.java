package uz.pdp.project_management_front_end.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {
    private String name;
    private String gitRepo;
    private String description;
    private UUID owner;
    private UUID team;
}
