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
import uz.pdp.project_management_front_end.domain.request.TeamRequest;
import uz.pdp.project_management_front_end.domain.response.TeamResponse;

import java.util.List;
import java.util.UUID;


@Service
public class TeamService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpSession httpSession;

    public TeamResponse saveTeam(TeamRequest teamRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());

        HttpEntity<TeamRequest> entity = new HttpEntity<>(teamRequest, headers);


        ResponseEntity<TeamResponse> response = restTemplate.postForEntity(
                "http://localhost:8080/team/save-team",
                entity,
                TeamResponse.class
        );
        return response.getBody();
    }

    public void deleteTeam(UUID teamId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<Void> response = restTemplate.exchange(
                "http://localhost:8080/team/delete-team/" + teamId,
                HttpMethod.DELETE,
                entity,
                Void.class
        );
    }

    public List<TeamResponse> getAllTeams() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<List<TeamResponse>> response = restTemplate.exchange(
                "http://localhost:8080/team/get-team",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<TeamResponse>>() {}
        );

        return response.getBody();
    }


    public void updateTeam(UUID teamId, TeamRequest teamRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());

        HttpEntity<TeamRequest> entity = new HttpEntity<>(teamRequest, headers);

        ResponseEntity<TeamResponse> response = restTemplate.exchange(
                "http://localhost:8080/team/update-team/" + teamId,
                HttpMethod.PUT,
                entity,
                TeamResponse.class
        );
        response.getBody();
    }



}
