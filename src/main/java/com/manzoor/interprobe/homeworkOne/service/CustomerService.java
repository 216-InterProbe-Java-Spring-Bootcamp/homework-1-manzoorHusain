package com.manzoor.interprobe.homeworkOne.service;

import com.manzoor.interprobe.homeworkOne.dao.CustomerDao;
import com.manzoor.interprobe.homeworkOne.entity.Customer;
import com.manzoor.interprobe.homeworkOne.entity.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    // Question 3: Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
    public List<ProductComment> getAllCommentsByUser(Long user_id){
        Customer customer = customerDao.findById(user_id).orElse(null);
        if (customer==null){
            return  null;
        }
        return customer.getProductComments();
    }


    //4. Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.
    public List<ProductComment> getAllCommentsByUserBetweenTwoDates(Long user_id, Date startDate, Date end_date){

        Customer customer = customerDao.findById(user_id).orElse(null);
        if (customer==null){
            return  null;
        }
        List<ProductComment> allCommentsByOneUser = customer.getProductComments();

        List<ProductComment> customerComments = new ArrayList<>();
        for (int i = 0; i < allCommentsByOneUser.size(); i++) {
            Date productCommentDate = allCommentsByOneUser.get(i).getCommentDate();

            if (productCommentDate.after(startDate) && productCommentDate.before(end_date)) {
                customerComments.add(allCommentsByOneUser.get(i));
            }


        }
        return customerComments;
    }

}

