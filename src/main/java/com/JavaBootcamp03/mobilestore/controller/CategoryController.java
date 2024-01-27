package com.JavaBootcamp03.mobilestore.controller;

import com.JavaBootcamp03.mobilestore.payload.response.BaseResponse;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.CategoryServiceImp;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.SubCategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @Autowired
    private SubCategoryServiceImp subCategoryServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getCategory() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(categoryServiceImp.getAllCategory());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/sub")
    public ResponseEntity<?> getSubCategory(@RequestParam int id_category) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(subCategoryServiceImp.getSubCategory(id_category));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
