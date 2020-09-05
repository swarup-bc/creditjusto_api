package com.urs.bsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.urs.bsi.model.BankStmtSummaryData;

public interface BankStmtSummaryDataRepository  extends JpaRepository<BankStmtSummaryData,Long>{

	@Query("select bs from BankStmtSummaryData bs where bs.historyId = :historyId ")
	List<BankStmtSummaryData> findByHistoryId(@Param("historyId") int historyId);
}
