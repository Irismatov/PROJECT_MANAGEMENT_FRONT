package uz.pdp.project_management_front_end.domain.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyInfoViewImpl implements CompanyInfoView{
    private UUID id;
    private String name;
    private String address;
    private LocalDate establishmentDate;
    boolean isBlocked;
    private String ceoUsername;
}
