package com.urs.bsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.urs.bsi.model.CategoriesConsolidated;

public interface CategoriesConsolidatedRepository  extends JpaRepository<CategoriesConsolidated,Long>{

	@Query("select cc from CategoriesConsolidated cc where cc.historyId = :historyId ")
	CategoriesConsolidated findByHistoryId(@Param("historyId") int historyId);
}
