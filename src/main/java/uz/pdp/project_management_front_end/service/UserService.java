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
import uz.pdp.project_management_front_end.domain.enumerators.Permission;
import uz.pdp.project_management_front_end.domain.enumerators.UserRole;
import uz.pdp.project_management_front_end.domain.request.UserRequest;
import uz.pdp.project_management_front_end.domain.response.CompanyResponse;
import uz.pdp.project_management_front_end.domain.response.UserResponse;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpSession httpSession;

    public UserResponse saveCEO(UserRequest userRequest) {
        HttpHeaders headers = new HttpHeaders();
        userRequest.setPermissions(UserRole.CEO.getPermissions());
        headers.setBearerAuth(httpSession.getAttribute("token").toString()); // Replace with your actual token
        HttpEntity<UserRequest> entity = new HttpEntity<>(userRequest, headers);
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(
                "http://localhost:8080/users",
                entity,
                UserResponse.class
        );
        return response.getBody();
    }

    public List<UserResponse> getAllCEO() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString()); // Replace with your actual token

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<UserResponse>> response = restTemplate.exchange(
                "http://localhost:8080/users/ceo",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public List<UserResponse> getAllTeamLeads() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<UserResponse>> response = restTemplate.exchange(
                "http://localhost:8080/users/leads",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public List<UserResponse> getAllScrumMasters() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<UserResponse>> response = restTemplate.exchange(
                "http://localhost:8080/users/scrum-master",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public UserResponse saveHRAdmin(UserRequest userRequest) {
        HttpHeaders headers = new HttpHeaders();
        userRequest.setPermissions(UserRole.HR_ADMIN.getPermissions());
        headers.setBearerAuth(httpSession.getAttribute("token").toString()); // Replace with your actual token
        HttpEntity<UserRequest> entity = new HttpEntity<>(userRequest, headers);
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(
                "http://localhost:8080/users/save-hr-admin",
                entity,
                UserResponse.class
        );
        return response.getBody();
    }

    public List<UserResponse> getAllHRAdmin() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<UserResponse>> response = restTemplate.exchange(
                "http://localhost:8080/users/get-hr-admin",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {}
        );
        return response.getBody();
    }

    public void deleteHRAdmin(UUID id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString()); // Replace with your actual token

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        restTemplate.exchange(
                "http://localhost:8080/users/delete-hr-admin/" + id,
                HttpMethod.DELETE,
                entity,
                Void.class
        );
    }
}
