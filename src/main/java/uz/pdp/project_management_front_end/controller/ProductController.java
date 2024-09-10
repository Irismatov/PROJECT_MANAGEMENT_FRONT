package uz.pdp.project_management_front_end.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.project_management_front_end.domain.request.ProductRequest;
import uz.pdp.project_management_front_end.service.ProductService;

import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "ceo/product-crud";
    }


    @PostMapping
    public String save(ProductRequest productRequest, Model model) {
        productService.save(productRequest);
        model.addAttribute("products", productService.getProducts());
        return "ceo/product-crud";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")UUID uuid, ProductRequest productRequest, Model model) {
        productService.update(uuid, productRequest);
        model.addAttribute("products", productService.getProducts());
        return "ceo/product-crud";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID uuid, Model model) {
        productService.delete(uuid);
        model.addAttribute("products", productService.getProducts());
        return "ceo/product-crud";
    }
}
