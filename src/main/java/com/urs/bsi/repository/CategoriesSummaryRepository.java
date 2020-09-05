package com.urs.bsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.urs.bsi.model.CategoriesSummary;

public interface CategoriesSummaryRepository  extends JpaRepository<CategoriesSummary,Long>{

	@Query("select cs from CategoriesSummary cs where cs.historyId = :historyId ")
	List<CategoriesSummary> findByHistoryId(@Param("historyId") int historyId);
}
