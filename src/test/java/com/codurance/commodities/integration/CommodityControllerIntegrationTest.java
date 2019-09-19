import com.codurance.commodities.controller.CommodityController;
import com.codurance.commodities.domain.Commodity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(locations = "classpath:test.properties")
public class CommodityControllerIntegrationTest {

    @Autowired
    CommodityController commodityController;

    @Autowired
    MongoTemplate mongoTemplate;

    @Before
    public void setUp() throws Exception {
        Commodity vehicle = new Commodity();
        vehicle.setId("5d6633b6c07ffb983113fa33");
        vehicle.setType("vehicle");
        vehicle.setBrand("Chevrolet");
        vehicle.setModel("Corsa Classic");
        vehicle.setYear(2008);
        vehicle.setColour("black");
        vehicle.setKind("car");

        Commodity product = new Commodity();
        product.setId("5d663408c07ffb983113fa34");
        product.setType("product");
        product.setBrand("Apple");
        product.setDescription("MacBook Pro");
        product.setGtin("1234567890123");

        mongoTemplate.save(vehicle);
        mongoTemplate.save(product);
    }

    @Test
    public void find_by_id() {
        Commodity commodity = commodityController.findById("5d6633b6c07ffb983113fa33");

        assertThat(commodity.getType(), is("vehicle"));
    }

    @Test
    public void find_all() {
        List<Commodity> commodities = commodityController.findAll();

        assertThat(commodities.size(), is(2));
    }
}
