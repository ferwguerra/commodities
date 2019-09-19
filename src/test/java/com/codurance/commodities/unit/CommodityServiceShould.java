package com.codurance.commodities.unit;

import com.codurance.commodities.domain.Commodity;
import com.codurance.commodities.repository.CommodityRepository;
import com.codurance.commodities.service.CommodityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CommodityServiceShould {

    @Mock
    CommodityRepository commodityRepository;

    @Test
    public void be_Fernando_when_get_name() {
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

        CommodityService commodityService = new CommodityService();
        commodityService.setCommodityRepository(commodityRepository);

        given(commodityRepository.findAll()).willReturn(commoditiesToReturn);

        List<Commodity> commodities = commodityService.findAll();

        assertThat(commodities.size(), is(1));
    }
}
