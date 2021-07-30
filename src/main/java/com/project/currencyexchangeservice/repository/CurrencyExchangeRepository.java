package com.project.currencyexchangeservice.repository;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.currencyexchangeservice.resource.CurrencyExchange;

//@Repository
public interface CurrencyExchangeRepository extends MongoRepository<CurrencyExchange,String>{
//public class CurrencyExchangeRepository{
	
	/*
	 * @Autowired private MongoTemplate mongoTemplate;
	 * 
	 * public Optional<CurrencyExchange> getCurrency(String from, String to) {
	 * return
	 * Optional.of(mongoTemplate.findOne(Query.query(Criteria.where("_id").is(
	 * 4524234)), CurrencyExchange.class)); }
	 */	
	
	@Query(value="{fromCurrencyCode:?0,toCurrencyCode:?1}",sort= "{lastEvaluationDate:-1}")
	public Stream<CurrencyExchange> findLatestRecordByFromAndTo(String fromCurrencyCode,String toCurrencyCode);
	
}
