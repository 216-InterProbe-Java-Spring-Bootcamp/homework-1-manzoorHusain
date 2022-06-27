package com.manzoor.interprobe.homeworkOne.service;
import com.manzoor.interprobe.homeworkOne.dao.ProductDao;
import com.manzoor.interprobe.homeworkOne.entity.Product;
import com.manzoor.interprobe.homeworkOne.entity.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }


    //Question 1: Bir ürüne ait yorumları listeleyen bir metot yazınız.
    public List<ProductComment> getAllCommentsAddedToProduct(Long product_id){
        Product product = productDao.findById(product_id).orElse(null);
        if (product==null){
            return  null;
        }

        return  product.getProductComments();
    }
    // 2. Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.

    public List<ProductComment> getCommentBetweenTwoDatesToSpecificProduct(Long product_id, Date startDate, Date end_date) {
        Product product = productDao.findById(product_id).orElse(null);
        if (product==null){
            return  null;
        }
        List<ProductComment> allComments = product.getProductComments();


        List<ProductComment> productComments = new ArrayList<>();
        for (int i = 0; i < allComments.size(); i++) {
            Date productCommentDate = allComments.get(i).getCommentDate();

            if (productCommentDate.after(startDate) && productCommentDate.before(end_date)) {
                productComments.add(allComments.get(i));
            }


        }
        return productComments;
    }




    //  5 Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.
    public List<Product> getExpireProducts(){
        Date currentDate = new Date();
        List<Product> products = productDao.findAll();
        List<Product> expireProducts  = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            Date expiryDate = product.getExpiryDate();
            if (expiryDate.after(currentDate)){
                expireProducts.add(product);
            }
        }

        return expireProducts;
    }


    //6. Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)
    public List<Product> getValidProducts(){
        Date currentDate = new Date();
        List<Product> products = productDao.findAll();
        List<Product> freshProducts  = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            Date expiryDate = product.getExpiryDate();
            if (expiryDate.before(currentDate) || expiryDate.equals(null)){
                freshProducts.add(product);
            }
        }

        return freshProducts;
    }
}
