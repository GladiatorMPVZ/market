package shopcore.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shopcore.entity.Product;
import shopcore.services.ProductService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getAllProducts() {
        return "show all products and change it";
    }

    @GetMapping("/{id}")
    public Product getAllProduct(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public Product saveNewProduct(@RequestBody Product product) {
        product.setId(null);
        return productService.saveOrUpdateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @PutMapping
    public Product updateStudent(@RequestBody Product product) {
        return productService.saveOrUpdateProduct(product);
    }
}
