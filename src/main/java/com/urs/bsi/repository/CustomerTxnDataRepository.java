package com.urs.bsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.urs.bsi.model.CustomerTxnData;

public interface CustomerTxnDataRepository  extends JpaRepository<CustomerTxnData,Long>{

	@Query("select cd from CustomerTxnData cd where cd.historyId = :historyId ")
	List<CustomerTxnData> findByHistoryId(@Param("historyId") int historyId);
}
