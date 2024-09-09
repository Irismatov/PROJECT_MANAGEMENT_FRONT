package uz.pdp.project_management_front_end.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.project_management_front_end.domain.enumerators.FeatureStatus;
import uz.pdp.project_management_front_end.domain.response.TaskResponse;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeatureRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String owner;
    @NotBlank
    private FeatureStatus status;
    @NotBlank
    private List<TaskResponse> tasks;

}
