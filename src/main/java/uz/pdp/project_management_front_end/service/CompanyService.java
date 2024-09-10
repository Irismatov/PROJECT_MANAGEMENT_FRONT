package uz.pdp.project_management_front_end.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.project_management_front_end.domain.request.CompanyCreateDTO;
import uz.pdp.project_management_front_end.domain.response.CompanyResponse;
import uz.pdp.project_management_front_end.domain.view.CompanyInfoView;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpSession httpSession;

    public CompanyInfoView save(CompanyCreateDTO company) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString()); // Replace with your actual token

        HttpEntity<CompanyCreateDTO> entity = new HttpEntity<>(company, headers);

        ResponseEntity<CompanyInfoView> companyInfoViewResponseEntity = restTemplate.postForEntity(
                "http://localhost:8080/company",
                entity,
                CompanyInfoView.class
        );
        return companyInfoViewResponseEntity.getBody();
    }

    public List<CompanyResponse> getAllCompanies() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString()); // Replace with your actual token

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<List<CompanyResponse>> response = restTemplate.exchange(
                "http://localhost:8080/company",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public void freezeCompany(UUID companyId) {
        restTemplate.put(
                "http://localhost:8080/company/" + companyId + "/block",
                null
        );
    }

    public void unfreezeCompany(UUID companyId) {
        restTemplate.put(
                "http://localhost:8080/company/" + companyId +"/unblock",
                null

        );
    }
}
