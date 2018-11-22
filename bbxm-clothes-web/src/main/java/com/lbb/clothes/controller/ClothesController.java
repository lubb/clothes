package com.lbb.clothes.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lbb.clothes.business.model.Clothes;
import com.lbb.clothes.business.service.ClothesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/clothes")
public class ClothesController {

    @Reference
    private ClothesService clothesService;

    @RequestMapping("/find")
    @ResponseBody
    public Clothes find(){
        return clothesService.getClothesById(1L);
    }

}
