package com.lbb.clothes.service;

import com.lbb.clothes.business.model.Clothes;
import com.lbb.clothes.business.service.ClothesService;
import com.alibaba.dubbo.config.annotation.Service;
import com.lbb.clothes.mapper.ClothesMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClothesServiceImpl implements ClothesService {

    @Autowired
    private ClothesMapper clothesMapper;

    public Clothes getClothesById(Long id) {
        return clothesMapper.selectByPrimaryKey(id);
    }
}
