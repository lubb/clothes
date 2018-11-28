package com.lbb.clothes.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lbb.clothes.business.model.Quotation;
import com.lbb.clothes.business.service.QuotationService;
import com.lbb.clothes.mapper.QuotationMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private QuotationMapper quotationMapper;

    @Override
    public Quotation getQuotationRand() {
        return quotationMapper.getQuotationRand();
    }
}
