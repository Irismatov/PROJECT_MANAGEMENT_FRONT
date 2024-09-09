package uz.pdp.project_management_front_end.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.project_management_front_end.domain.request.LoginRequest;
import uz.pdp.project_management_front_end.domain.request.RegisterRequest;
import uz.pdp.project_management_front_end.domain.response.LoginResponse;
import uz.pdp.project_management_front_end.domain.response.RegisterResponse;

@Service
public class AuthService {

    private final RestTemplate restTemplate;

    public AuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RegisterResponse register(RegisterRequest registerRequest) {
        ResponseEntity<RegisterResponse> responseEntity = restTemplate.postForEntity(
                "http://localhost:8080/register", registerRequest, RegisterResponse.class
        );
        return responseEntity.getBody();
    }

    public LoginResponse login(LoginRequest loginRequest) {
        ResponseEntity<LoginResponse> responseEntity = restTemplate.postForEntity(
                "http://localhost:8080/login", loginRequest, LoginResponse.class
        );
        return responseEntity.getBody();
    }


    public void registerPA() {
        ResponseEntity<RegisterResponse> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/register-pa", RegisterResponse.class
        );
        responseEntity.getBody();
    }
}
