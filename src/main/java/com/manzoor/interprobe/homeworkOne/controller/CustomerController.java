package com.manzoor.interprobe.homeworkOne.controller;
import com.manzoor.interprobe.homeworkOne.entity.ProductComment;
import com.manzoor.interprobe.homeworkOne.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }



    @GetMapping("/{user_id}")
    public List<ProductComment> getAllCommentsByUser(@PathVariable("user_id") Long id){
        return customerService.getAllCommentsByUser(id);
    }




//4. Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.

    @GetMapping("/{user_id}/{start_date}/{end_date}")
    public List<ProductComment> getAllCommentsByUserBetweenTwoDates(
            @PathVariable("product_id") Long user_id,
            @PathVariable("start_date") Date startDate, @PathVariable("end_date") Date end_date){
        return customerService.getAllCommentsByUserBetweenTwoDates(user_id,startDate,end_date);
    }

}
