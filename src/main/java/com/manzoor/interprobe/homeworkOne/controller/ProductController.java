package com.manzoor.interprobe.homeworkOne.controller;
import com.manzoor.interprobe.homeworkOne.entity.Product;
import com.manzoor.interprobe.homeworkOne.entity.ProductComment;
import com.manzoor.interprobe.homeworkOne.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // Question 1: Bir ürüne ait yorumları listeleyen bir metot yazınız.
    @GetMapping("/{product_id}")
    public List<ProductComment> getAllCommentsToProduct(@PathVariable("product_id") Long id) {
        System.out.println("inside getAllCommentsToProduct() method... ");
        return productService.getAllCommentsAddedToProduct(id);
    }


    //    2. Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.

    @GetMapping("/{product_id}/{start_date}/{end_date}")
    public List<ProductComment> getCommentBetweenTwoDatesToSpecificProduct
            (@PathVariable("product_id") Long product_id, @PathVariable("start_date") Date startDate,
             @PathVariable("end_date") Date end_date) {

        return productService.getCommentBetweenTwoDatesToSpecificProduct(product_id, startDate, startDate);
    }


    //  5 Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.

    @GetMapping("/expired")
    public List<Product> getExpireProducts(){
        return productService.getExpireProducts();
    }


    //6. Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)
    @GetMapping("/fresh")
    public List<Product> getValidProducts(){
        return productService.getValidProducts();
    }


}
