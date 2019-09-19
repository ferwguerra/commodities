package com.codurance.commodities.unit;

import com.codurance.commodities.controller.CommodityController;
import com.codurance.commodities.domain.Commodity;
import com.codurance.commodities.service.CommodityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CommodityControllerShould {

    @Mock
    CommodityService commodityService;

    @Test
    public void get_commodities_when_invoked() {
        Commodity vehicle = new Commodity();
        vehicle.setId("5d6633b6c07ffb983113fa62");
        vehicle.setType("vehicle");
        vehicle.setBrand("Chevrolet");
        vehicle.setModel("Corsa Classic");
        vehicle.setYear(2008);
        vehicle.setColour("black");
        vehicle.setKind("car");

        List<Commodity> commoditiesToReturn = new ArrayList<>();
        commoditiesToReturn.add(vehicle);

        given(commodityService.findAll()).willReturn(commoditiesToReturn);
        CommodityController commodityController = new CommodityController();
        commodityController.setCommodityService(commodityService);

        List<Commodity> commodities = commodityController.findAll();

        assertThat(commodities.size(), is(1));
    }
}
