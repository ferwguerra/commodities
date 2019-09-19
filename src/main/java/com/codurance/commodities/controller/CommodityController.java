package com.codurance.commodities.controller;

import com.codurance.commodities.service.CommodityService;
import com.codurance.commodities.domain.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commodities")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Commodity> findAll() {
        return commodityService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Commodity findById(@PathVariable("id") String id) {
        return commodityService.findById(id);
    }

    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }
}
