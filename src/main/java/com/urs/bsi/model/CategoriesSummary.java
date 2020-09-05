package com.urs.bsi.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_categories_summary")
public class CategoriesSummary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id	;
	private Integer historyId;
	private String category_type; 
	private Integer total_credit_count_of_txn;
	private BigDecimal sales_card_amt;
	private BigDecimal sales_non_card_amt;
	private BigDecimal cash_deposit_amt;
	private BigDecimal refund_reversals_amt;
	private BigDecimal intra_account_transfer_amt;
	private Integer sales_card_count ; 
	private Integer sales_non_card_count;
	private Integer cash_deposit_count ; 
	private Integer refund_reversals_count ;
	private Integer intra_account_transfer_count ; 
	private Integer ng_check_count ;
	private BigDecimal ng_check_amt ; 
	private Integer loans_count ;
	private BigDecimal loans_amt ; 
	private Integer investment_income_count ; 
	private BigDecimal investment_income_amt ; 
	private Integer insurance_claim_count ;
	private BigDecimal insurance_claim_amt ; 
	private Integer miscellaneous_credits_count ;
	private BigDecimal miscellaneous_credits_amt ; 
	private BigDecimal total_credit_amount ; 
	private Integer vendor_payments_count ;
	private BigDecimal vendor_payments_amt ; 
	private Integer salaries_benefits_count ;
	private BigDecimal salaries_benefits_amt ; 
	private Integer taxes_count ;
	private BigDecimal taxes_amt ; 
	private Integer insurance_count ;
	private BigDecimal insurance_amt ; 
	private Integer cash_withdrawal_count ; 
	private BigDecimal cash_withdrawal_amt ;
	private Integer card_processor_fees_count ; 
	private BigDecimal card_processor_fees_amt ;
	private Integer chargeback_count ; 
	private BigDecimal chargeback_amt ; 
	private Integer credit_card_payments_count ; 
	private BigDecimal credit_card_payments_amt ; 
	private Integer loan_repayment_emi_lenders_count ; 
	private BigDecimal loan_repayment_emi_lenders_amt ; 
	private Integer loan_repayment_emi_mortgage_count ; 
	private BigDecimal loan_repayment_emi_mortgage_amt ; 
	private Integer loan_repayment_emi_auto_finance_count ;
	private BigDecimal loan_repayment_emi_auto_finance_amt ; 
	private Integer intra_account_count ;
	private BigDecimal intra_account_amt ; 
	private Integer fees_ng_count ; 
	private BigDecimal fees_ng_amt ; 
	private Integer fees_overdraft_count ; 
	private BigDecimal fees_overdraft_amt ; 
	private Integer fees_others_count ; 
	private BigDecimal fees_others_amt ; 
	private Integer investments_count ; 
	private BigDecimal investments_amt ; 
	private Integer deposited_check_return_count ; 
	private BigDecimal deposited_check_return_amt ; 
	private Integer miscellaneous_debit_count ; 
	private BigDecimal miscellaneous_debit_amt ; 
	private Integer travel_expenses_airlines_count ; 
	private BigDecimal travel_expenses_airlines_amt ; 
	private Integer travel_expenses_hotels_count ; 
	private BigDecimal travel_expenses_hotels_amt ; 
	private Integer travel_epenses_car_rental_count ; 
	private BigDecimal travel_epenses_car_rental_amt ; 
	private Integer travel_expenses_others_count ; 
	private BigDecimal travel_expenses_others_amt ; 
	private Integer utilities_telephone_count ; 
	private BigDecimal utilities_telephone_amt ; 
	private Integer utilities_internet_count ; 
	private BigDecimal utilities_internet_amt ; 
	private Integer utilities_tv_count ; 
	private BigDecimal utilities_tv_amt ; 
	private Integer utilities_power_count ; 
	private BigDecimal utilities_power_amt ; 
	private Integer utilities_water_count ; 
	private BigDecimal utilities_water_amt ; 
	private Integer utilities_others_count ; 
	private BigDecimal utilities_others_amt ; 
	private Integer total_debit_count_of_txn ; 
	private BigDecimal total_debit_amt ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getHistoryId() {
		return historyId;
	}
	public void setHistoryId(Integer historyId) {
		this.historyId = historyId;
	}
	public String getCategory_type() {
		return category_type;
	}
	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}
	public Integer getTotal_credit_count_of_txn() {
		return total_credit_count_of_txn;
	}
	public void setTotal_credit_count_of_txn(Integer total_credit_count_of_txn) {
		this.total_credit_count_of_txn = total_credit_count_of_txn;
	}
	public BigDecimal getSales_card_amt() {
		return sales_card_amt;
	}
	public void setSales_card_amt(BigDecimal sales_card_amt) {
		this.sales_card_amt = sales_card_amt;
	}
	public BigDecimal getSales_non_card_amt() {
		return sales_non_card_amt;
	}
	public void setSales_non_card_amt(BigDecimal sales_non_card_amt) {
		this.sales_non_card_amt = sales_non_card_amt;
	}
	public BigDecimal getCash_deposit_amt() {
		return cash_deposit_amt;
	}
	public void setCash_deposit_amt(BigDecimal cash_deposit_amt) {
		this.cash_deposit_amt = cash_deposit_amt;
	}
	public BigDecimal getRefund_reversals_amt() {
		return refund_reversals_amt;
	}
	public void setRefund_reversals_amt(BigDecimal refund_reversals_amt) {
		this.refund_reversals_amt = refund_reversals_amt;
	}
	public BigDecimal getIntra_account_transfer_amt() {
		return intra_account_transfer_amt;
	}
	public void setIntra_account_transfer_amt(BigDecimal intra_account_transfer_amt) {
		this.intra_account_transfer_amt = intra_account_transfer_amt;
	}
	public Integer getSales_card_count() {
		return sales_card_count;
	}
	public void setSales_card_count(Integer sales_card_count) {
		this.sales_card_count = sales_card_count;
	}
	public Integer getSales_non_card_count() {
		return sales_non_card_count;
	}
	public void setSales_non_card_count(Integer sales_non_card_count) {
		this.sales_non_card_count = sales_non_card_count;
	}
	public Integer getCash_deposit_count() {
		return cash_deposit_count;
	}
	public void setCash_deposit_count(Integer cash_deposit_count) {
		this.cash_deposit_count = cash_deposit_count;
	}
	public Integer getRefund_reversals_count() {
		return refund_reversals_count;
	}
	public void setRefund_reversals_count(Integer refund_reversals_count) {
		this.refund_reversals_count = refund_reversals_count;
	}
	public Integer getIntra_account_transfer_count() {
		return intra_account_transfer_count;
	}
	public void setIntra_account_transfer_count(Integer intra_account_transfer_count) {
		this.intra_account_transfer_count = intra_account_transfer_count;
	}
	public Integer getNg_check_count() {
		return ng_check_count;
	}
	public void setNg_check_count(Integer ng_check_count) {
		this.ng_check_count = ng_check_count;
	}
	public BigDecimal getNg_check_amt() {
		return ng_check_amt;
	}
	public void setNg_check_amt(BigDecimal ng_check_amt) {
		this.ng_check_amt = ng_check_amt;
	}
	public Integer getLoans_count() {
		return loans_count;
	}
	public void setLoans_count(Integer loans_count) {
		this.loans_count = loans_count;
	}
	public BigDecimal getLoans_amt() {
		return loans_amt;
	}
	public void setLoans_amt(BigDecimal loans_amt) {
		this.loans_amt = loans_amt;
	}
	public Integer getInvestment_income_count() {
		return investment_income_count;
	}
	public void setInvestment_income_count(Integer investment_income_count) {
		this.investment_income_count = investment_income_count;
	}
	public BigDecimal getInvestment_income_amt() {
		return investment_income_amt;
	}
	public void setInvestment_income_amt(BigDecimal investment_income_amt) {
		this.investment_income_amt = investment_income_amt;
	}
	public Integer getInsurance_claim_count() {
		return insurance_claim_count;
	}
	public void setInsurance_claim_count(Integer insurance_claim_count) {
		this.insurance_claim_count = insurance_claim_count;
	}
	public BigDecimal getInsurance_claim_amt() {
		return insurance_claim_amt;
	}
	public void setInsurance_claim_amt(BigDecimal insurance_claim_amt) {
		this.insurance_claim_amt = insurance_claim_amt;
	}
	public Integer getMiscellaneous_credits_count() {
		return miscellaneous_credits_count;
	}
	public void setMiscellaneous_credits_count(Integer miscellaneous_credits_count) {
		this.miscellaneous_credits_count = miscellaneous_credits_count;
	}
	public BigDecimal getMiscellaneous_credits_amt() {
		return miscellaneous_credits_amt;
	}
	public void setMiscellaneous_credits_amt(BigDecimal miscellaneous_credits_amt) {
		this.miscellaneous_credits_amt = miscellaneous_credits_amt;
	}
	public BigDecimal getTotal_credit_amount() {
		return total_credit_amount;
	}
	public void setTotal_credit_amount(BigDecimal total_credit_amount) {
		this.total_credit_amount = total_credit_amount;
	}
	public Integer getVendor_payments_count() {
		return vendor_payments_count;
	}
	public void setVendor_payments_count(Integer vendor_payments_count) {
		this.vendor_payments_count = vendor_payments_count;
	}
	public BigDecimal getVendor_payments_amt() {
		return vendor_payments_amt;
	}
	public void setVendor_payments_amt(BigDecimal vendor_payments_amt) {
		this.vendor_payments_amt = vendor_payments_amt;
	}
	public Integer getSalaries_benefits_count() {
		return salaries_benefits_count;
	}
	public void setSalaries_benefits_count(Integer salaries_benefits_count) {
		this.salaries_benefits_count = salaries_benefits_count;
	}
	public BigDecimal getSalaries_benefits_amt() {
		return salaries_benefits_amt;
	}
	public void setSalaries_benefits_amt(BigDecimal salaries_benefits_amt) {
		this.salaries_benefits_amt = salaries_benefits_amt;
	}
	public Integer getTaxes_count() {
		return taxes_count;
	}
	public void setTaxes_count(Integer taxes_count) {
		this.taxes_count = taxes_count;
	}
	public BigDecimal getTaxes_amt() {
		return taxes_amt;
	}
	public void setTaxes_amt(BigDecimal taxes_amt) {
		this.taxes_amt = taxes_amt;
	}
	public Integer getInsurance_count() {
		return insurance_count;
	}
	public void setInsurance_count(Integer insurance_count) {
		this.insurance_count = insurance_count;
	}
	public BigDecimal getInsurance_amt() {
		return insurance_amt;
	}
	public void setInsurance_amt(BigDecimal insurance_amt) {
		this.insurance_amt = insurance_amt;
	}
	public Integer getCash_withdrawal_count() {
		return cash_withdrawal_count;
	}
	public void setCash_withdrawal_count(Integer cash_withdrawal_count) {
		this.cash_withdrawal_count = cash_withdrawal_count;
	}
	public BigDecimal getCash_withdrawal_amt() {
		return cash_withdrawal_amt;
	}
	public void setCash_withdrawal_amt(BigDecimal cash_withdrawal_amt) {
		this.cash_withdrawal_amt = cash_withdrawal_amt;
	}
	public Integer getCard_processor_fees_count() {
		return card_processor_fees_count;
	}
	public void setCard_processor_fees_count(Integer card_processor_fees_count) {
		this.card_processor_fees_count = card_processor_fees_count;
	}
	public BigDecimal getCard_processor_fees_amt() {
		return card_processor_fees_amt;
	}
	public void setCard_processor_fees_amt(BigDecimal card_processor_fees_amt) {
		this.card_processor_fees_amt = card_processor_fees_amt;
	}
	public Integer getChargeback_count() {
		return chargeback_count;
	}
	public void setChargeback_count(Integer chargeback_count) {
		this.chargeback_count = chargeback_count;
	}
	public BigDecimal getChargeback_amt() {
		return chargeback_amt;
	}
	public void setChargeback_amt(BigDecimal chargeback_amt) {
		this.chargeback_amt = chargeback_amt;
	}
	public Integer getCredit_card_payments_count() {
		return credit_card_payments_count;
	}
	public void setCredit_card_payments_count(Integer credit_card_payments_count) {
		this.credit_card_payments_count = credit_card_payments_count;
	}
	public BigDecimal getCredit_card_payments_amt() {
		return credit_card_payments_amt;
	}
	public void setCredit_card_payments_amt(BigDecimal credit_card_payments_amt) {
		this.credit_card_payments_amt = credit_card_payments_amt;
	}
	public Integer getLoan_repayment_emi_lenders_count() {
		return loan_repayment_emi_lenders_count;
	}
	public void setLoan_repayment_emi_lenders_count(Integer loan_repayment_emi_lenders_count) {
		this.loan_repayment_emi_lenders_count = loan_repayment_emi_lenders_count;
	}
	public BigDecimal getLoan_repayment_emi_lenders_amt() {
		return loan_repayment_emi_lenders_amt;
	}
	public void setLoan_repayment_emi_lenders_amt(BigDecimal loan_repayment_emi_lenders_amt) {
		this.loan_repayment_emi_lenders_amt = loan_repayment_emi_lenders_amt;
	}
	public Integer getLoan_repayment_emi_mortgage_count() {
		return loan_repayment_emi_mortgage_count;
	}
	public void setLoan_repayment_emi_mortgage_count(Integer loan_repayment_emi_mortgage_count) {
		this.loan_repayment_emi_mortgage_count = loan_repayment_emi_mortgage_count;
	}
	public BigDecimal getLoan_repayment_emi_mortgage_amt() {
		return loan_repayment_emi_mortgage_amt;
	}
	public void setLoan_repayment_emi_mortgage_amt(BigDecimal loan_repayment_emi_mortgage_amt) {
		this.loan_repayment_emi_mortgage_amt = loan_repayment_emi_mortgage_amt;
	}
	public Integer getLoan_repayment_emi_auto_finance_count() {
		return loan_repayment_emi_auto_finance_count;
	}
	public void setLoan_repayment_emi_auto_finance_count(Integer loan_repayment_emi_auto_finance_count) {
		this.loan_repayment_emi_auto_finance_count = loan_repayment_emi_auto_finance_count;
	}
	public BigDecimal getLoan_repayment_emi_auto_finance_amt() {
		return loan_repayment_emi_auto_finance_amt;
	}
	public void setLoan_repayment_emi_auto_finance_amt(BigDecimal loan_repayment_emi_auto_finance_amt) {
		this.loan_repayment_emi_auto_finance_amt = loan_repayment_emi_auto_finance_amt;
	}
	public Integer getIntra_account_count() {
		return intra_account_count;
	}
	public void setIntra_account_count(Integer intra_account_count) {
		this.intra_account_count = intra_account_count;
	}
	public BigDecimal getIntra_account_amt() {
		return intra_account_amt;
	}
	public void setIntra_account_amt(BigDecimal intra_account_amt) {
		this.intra_account_amt = intra_account_amt;
	}
	public Integer getFees_ng_count() {
		return fees_ng_count;
	}
	public void setFees_ng_count(Integer fees_ng_count) {
		this.fees_ng_count = fees_ng_count;
	}
	public BigDecimal getFees_ng_amt() {
		return fees_ng_amt;
	}
	public void setFees_ng_amt(BigDecimal fees_ng_amt) {
		this.fees_ng_amt = fees_ng_amt;
	}
	public Integer getFees_overdraft_count() {
		return fees_overdraft_count;
	}
	public void setFees_overdraft_count(Integer fees_overdraft_count) {
		this.fees_overdraft_count = fees_overdraft_count;
	}
	public BigDecimal getFees_overdraft_amt() {
		return fees_overdraft_amt;
	}
	public void setFees_overdraft_amt(BigDecimal fees_overdraft_amt) {
		this.fees_overdraft_amt = fees_overdraft_amt;
	}
	public Integer getFees_others_count() {
		return fees_others_count;
	}
	public void setFees_others_count(Integer fees_others_count) {
		this.fees_others_count = fees_others_count;
	}
	public BigDecimal getFees_others_amt() {
		return fees_others_amt;
	}
	public void setFees_others_amt(BigDecimal fees_others_amt) {
		this.fees_others_amt = fees_others_amt;
	}
	public Integer getInvestments_count() {
		return investments_count;
	}
	public void setInvestments_count(Integer investments_count) {
		this.investments_count = investments_count;
	}
	public BigDecimal getInvestments_amt() {
		return investments_amt;
	}
	public void setInvestments_amt(BigDecimal investments_amt) {
		this.investments_amt = investments_amt;
	}
	public Integer getDeposited_check_return_count() {
		return deposited_check_return_count;
	}
	public void setDeposited_check_return_count(Integer deposited_check_return_count) {
		this.deposited_check_return_count = deposited_check_return_count;
	}
	public BigDecimal getDeposited_check_return_amt() {
		return deposited_check_return_amt;
	}
	public void setDeposited_check_return_amt(BigDecimal deposited_check_return_amt) {
		this.deposited_check_return_amt = deposited_check_return_amt;
	}
	public Integer getMiscellaneous_debit_count() {
		return miscellaneous_debit_count;
	}
	public void setMiscellaneous_debit_count(Integer miscellaneous_debit_count) {
		this.miscellaneous_debit_count = miscellaneous_debit_count;
	}
	public BigDecimal getMiscellaneous_debit_amt() {
		return miscellaneous_debit_amt;
	}
	public void setMiscellaneous_debit_amt(BigDecimal miscellaneous_debit_amt) {
		this.miscellaneous_debit_amt = miscellaneous_debit_amt;
	}
	public Integer getTravel_expenses_airlines_count() {
		return travel_expenses_airlines_count;
	}
	public void setTravel_expenses_airlines_count(Integer travel_expenses_airlines_count) {
		this.travel_expenses_airlines_count = travel_expenses_airlines_count;
	}
	public BigDecimal getTravel_expenses_airlines_amt() {
		return travel_expenses_airlines_amt;
	}
	public void setTravel_expenses_airlines_amt(BigDecimal travel_expenses_airlines_amt) {
		this.travel_expenses_airlines_amt = travel_expenses_airlines_amt;
	}
	public Integer getTravel_expenses_hotels_count() {
		return travel_expenses_hotels_count;
	}
	public void setTravel_expenses_hotels_count(Integer travel_expenses_hotels_count) {
		this.travel_expenses_hotels_count = travel_expenses_hotels_count;
	}
	public BigDecimal getTravel_expenses_hotels_amt() {
		return travel_expenses_hotels_amt;
	}
	public void setTravel_expenses_hotels_amt(BigDecimal travel_expenses_hotels_amt) {
		this.travel_expenses_hotels_amt = travel_expenses_hotels_amt;
	}
	public Integer getTravel_epenses_car_rental_count() {
		return travel_epenses_car_rental_count;
	}
	public void setTravel_epenses_car_rental_count(Integer travel_epenses_car_rental_count) {
		this.travel_epenses_car_rental_count = travel_epenses_car_rental_count;
	}
	public BigDecimal getTravel_epenses_car_rental_amt() {
		return travel_epenses_car_rental_amt;
	}
	public void setTravel_epenses_car_rental_amt(BigDecimal travel_epenses_car_rental_amt) {
		this.travel_epenses_car_rental_amt = travel_epenses_car_rental_amt;
	}
	public Integer getTravel_expenses_others_count() {
		return travel_expenses_others_count;
	}
	public void setTravel_expenses_others_count(Integer travel_expenses_others_count) {
		this.travel_expenses_others_count = travel_expenses_others_count;
	}
	public BigDecimal getTravel_expenses_others_amt() {
		return travel_expenses_others_amt;
	}
	public void setTravel_expenses_others_amt(BigDecimal travel_expenses_others_amt) {
		this.travel_expenses_others_amt = travel_expenses_others_amt;
	}
	public Integer getUtilities_telephone_count() {
		return utilities_telephone_count;
	}
	public void setUtilities_telephone_count(Integer utilities_telephone_count) {
		this.utilities_telephone_count = utilities_telephone_count;
	}
	public BigDecimal getUtilities_telephone_amt() {
		return utilities_telephone_amt;
	}
	public void setUtilities_telephone_amt(BigDecimal utilities_telephone_amt) {
		this.utilities_telephone_amt = utilities_telephone_amt;
	}
	public Integer getUtilities_internet_count() {
		return utilities_internet_count;
	}
	public void setUtilities_internet_count(Integer utilities_internet_count) {
		this.utilities_internet_count = utilities_internet_count;
	}
	public BigDecimal getUtilities_internet_amt() {
		return utilities_internet_amt;
	}
	public void setUtilities_internet_amt(BigDecimal utilities_internet_amt) {
		this.utilities_internet_amt = utilities_internet_amt;
	}
	public Integer getUtilities_tv_count() {
		return utilities_tv_count;
	}
	public void setUtilities_tv_count(Integer utilities_tv_count) {
		this.utilities_tv_count = utilities_tv_count;
	}
	public BigDecimal getUtilities_tv_amt() {
		return utilities_tv_amt;
	}
	public void setUtilities_tv_amt(BigDecimal utilities_tv_amt) {
		this.utilities_tv_amt = utilities_tv_amt;
	}
	public Integer getUtilities_power_count() {
		return utilities_power_count;
	}
	public void setUtilities_power_count(Integer utilities_power_count) {
		this.utilities_power_count = utilities_power_count;
	}
	public BigDecimal getUtilities_power_amt() {
		return utilities_power_amt;
	}
	public void setUtilities_power_amt(BigDecimal utilities_power_amt) {
		this.utilities_power_amt = utilities_power_amt;
	}
	public Integer getUtilities_water_count() {
		return utilities_water_count;
	}
	public void setUtilities_water_count(Integer utilities_water_count) {
		this.utilities_water_count = utilities_water_count;
	}
	public BigDecimal getUtilities_water_amt() {
		return utilities_water_amt;
	}
	public void setUtilities_water_amt(BigDecimal utilities_water_amt) {
		this.utilities_water_amt = utilities_water_amt;
	}
	public Integer getUtilities_others_count() {
		return utilities_others_count;
	}
	public void setUtilities_others_count(Integer utilities_others_count) {
		this.utilities_others_count = utilities_others_count;
	}
	public BigDecimal getUtilities_others_amt() {
		return utilities_others_amt;
	}
	public void setUtilities_others_amt(BigDecimal utilities_others_amt) {
		this.utilities_others_amt = utilities_others_amt;
	}
	public Integer getTotal_debit_count_of_txn() {
		return total_debit_count_of_txn;
	}
	public void setTotal_debit_count_of_txn(Integer total_debit_count_of_txn) {
		this.total_debit_count_of_txn = total_debit_count_of_txn;
	}
	public BigDecimal getTotal_debit_amt() {
		return total_debit_amt;
	}
	public void setTotal_debit_amt(BigDecimal total_debit_amt) {
		this.total_debit_amt = total_debit_amt;
	}
	

}
