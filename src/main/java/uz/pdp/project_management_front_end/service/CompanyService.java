package uz.pdp.project_management_front_end.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.project_management_front_end.domain.request.CompanyCreateDTO;
import uz.pdp.project_management_front_end.domain.view.CompanyInfoView;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {
    @Autowired
    private RestTemplate restTemplate;

    public CompanyInfoView save(CompanyCreateDTO company) {
        ResponseEntity<CompanyInfoView> companyInfoViewResponseEntity = restTemplate.postForEntity(
                "http://localhost:8080/company",
                company,
                CompanyInfoView.class
        );
        return companyInfoViewResponseEntity.getBody();
    }

    public List<CompanyInfoView> getAllCompanies() {
        ResponseEntity<List<CompanyInfoView>> response = restTemplate.exchange(
                "http://localhost:8080/company",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public void freezeCompany(UUID companyId, boolean frozen) {
        restTemplate.put(
                "http://localhost:8080/company/" + companyId,
                frozen
        );
    }

    public void unfreezeCompany(UUID companyId, boolean unfrozen) {
        restTemplate.put(
                "http://localhost:8080/company/" + companyId,
                unfrozen
        );
    }
}
