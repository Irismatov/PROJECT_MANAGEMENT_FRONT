package uz.pdp.project_management_front_end.domain.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TeamRequest {

    private String name;
    private String description;
    private UUID leadId;
    private UUID scrumMasterId;
}
