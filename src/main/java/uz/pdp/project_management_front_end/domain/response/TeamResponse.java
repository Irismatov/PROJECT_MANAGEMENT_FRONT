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
public class TeamResponse {
    private UUID id;
    private String name;
    private String description;
    private String lead;
    private String scrumMaster;
    private String developer;
}
