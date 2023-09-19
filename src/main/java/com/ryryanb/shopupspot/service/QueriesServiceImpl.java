package com.ryryanb.shopupspot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryryanb.shopupspot.model.Query;
import com.ryryanb.shopupspot.repository.QueryRepository;

@Service
public class QueriesServiceImpl implements QueriesService {

	@Autowired
	private QueryRepository queryRepository;

	public void addQuery(Query queries) {

		queryRepository.save(queries);
	}

}
