package com.codurance.commodities.service;

import com.codurance.commodities.domain.Commodity;
import com.codurance.commodities.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;


    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }

    public void setCommodityRepository(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    public Commodity findById(String id) {
        return commodityRepository.findById(id).get();
    }
}
