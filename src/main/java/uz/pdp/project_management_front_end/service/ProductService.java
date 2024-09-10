package uz.pdp.project_management_front_end.service;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.project_management_front_end.domain.request.ProductRequest;
import uz.pdp.project_management_front_end.domain.view.ProductInfoView;

import java.util.List;

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

    }
}
