package com.lbb.clothes.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lbb.clothes.business.model.Tag;
import com.lbb.clothes.business.service.TagService;
import com.lbb.clothes.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getAll() {
        return tagMapper.getAll();
    }
}
