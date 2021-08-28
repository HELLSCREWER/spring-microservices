package com.microservice.currencyexchangeservice.repository;

import com.microservice.currencyexchangeservice.domain.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeValueRepository {

    @Autowired
    private MongoTemplate template;

    public ExchangeValue getExchangeValue(String from, String to){
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("currencyFrom").is(from), Criteria.where("currencyTo").is(to));
        Query query = new Query(criteria);
        return template.findOne(query, ExchangeValue.class);
    }
}
