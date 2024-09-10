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
import uz.pdp.project_management_front_end.domain.request.ProductRequest;
import uz.pdp.project_management_front_end.domain.view.ProductInfoView;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpSession httpSession;


    public void save(ProductRequest productRequest) {
        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(httpSession.getAttribute("token").toString());

        HttpEntity<ProductRequest> entity = new HttpEntity<>(productRequest, headers);

        restTemplate.postForEntity(
                "http://localhost:8080/product",
                productRequest,
                null
        );
    }


    public List<ProductInfoView> getProducts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());
        HttpEntity<ProductRequest> entity = new HttpEntity<>(null, headers);
        ResponseEntity<List<ProductInfoView>> entity1 = restTemplate.exchange(
                "http://localhost:8080/product",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );
        return entity1.getBody();
    }


    public void delete(UUID id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());
        HttpEntity<ProductRequest> entity = new HttpEntity<>(null, headers);
        restTemplate.delete(
                "http://localhost:8080/product",
                HttpMethod.DELETE,
                entity,
                new ParameterizedTypeReference<>() {}
        );
    }


    public void update(UUID id, ProductRequest productRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(httpSession.getAttribute("token").toString());
        HttpEntity<ProductRequest> entity = new HttpEntity<>(productRequest, headers);
        restTemplate.put(
                "http://localhost:8080/product",
                HttpMethod.PUT,
                entity,
                new ParameterizedTypeReference<>() {}
        );
    }
}
