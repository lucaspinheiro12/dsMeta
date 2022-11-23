package com.devsuperior.dsmeta.services;







import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;

	public Page<Sale> findSales (String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.now();
		LocalDate min ;
		LocalDate max ;
		if(minDate.equals("")) {
			LocalDate mini = today.minusDays(365);
			min = mini;
		}else {
			LocalDate mini = LocalDate.parse(minDate);
			min = mini;
		}
		if(maxDate.equals("")) {
			LocalDate maxi = today;
			max = maxi;
		}else {
			LocalDate maxi = LocalDate.parse(maxDate);
			max = maxi;
		}
			
		return repository.findSales(min, max, pageable);
	}
}
