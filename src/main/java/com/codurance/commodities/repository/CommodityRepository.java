package com.codurance.commodities.repository;

import com.codurance.commodities.domain.Commodity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends MongoRepository<Commodity, String> {
}
