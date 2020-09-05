package com.urs.bsi.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD
import com.urs.bsi.model.BankStmtSummaryData;
import com.urs.bsi.model.CategoriesConsolidated;
import com.urs.bsi.model.CategoriesSummary;
import com.urs.bsi.model.CustomerTxnData;
import com.urs.bsi.model.TplHistory;
import com.urs.bsi.repository.BankStmtSummaryDataRepository;
import com.urs.bsi.repository.CategoriesConsolidatedRepository;
import com.urs.bsi.repository.CategoriesSummaryRepository;
import com.urs.bsi.repository.CustomerTxnDataRepository;
import com.urs.bsi.repository.TplHistoryRepository;
import com.urs.bsi.vo.Address;
import com.urs.bsi.vo.ApiResponse;
import com.urs.bsi.vo.Bank;
import com.urs.bsi.vo.BankStatement;
import com.urs.bsi.vo.Categories;
import com.urs.bsi.vo.CategoriesL1;
import com.urs.bsi.vo.CategoriesL2;
import com.urs.bsi.vo.CategoriesL3;
import com.urs.bsi.vo.Category;
import com.urs.bsi.vo.Group;
import com.urs.bsi.vo.Summary;
import com.urs.bsi.vo.Transactions;
=======
import com.urs.bsi.model.AuthToken;
import com.urs.bsi.model.SpreadingAccountData;
import com.urs.bsi.model.SpreadingMasterData;
import com.urs.bsi.model.SpreadingSummaryData;
import com.urs.bsi.model.SpreadingTransactionData;
import com.urs.bsi.model.URSIoJsonDetails;
import com.urs.bsi.model.vo.AccountDataVo;
import com.urs.bsi.model.vo.CLToURSResponseVo;
import com.urs.bsi.model.vo.CustomerDataVo;
import com.urs.bsi.model.vo.DocumentRejectionResponseVo;
import com.urs.bsi.model.vo.DocumentRejectionVo;
import com.urs.bsi.model.vo.FGToURSResponseVo;
import com.urs.bsi.model.vo.MonthlyDataVo;
import com.urs.bsi.model.vo.RequestedAccount;
import com.urs.bsi.model.vo.TransactionDataVo;
import com.urs.bsi.model.vo.URSToFGRequestVo;
import com.urs.bsi.repository.SpreadingMasterDataRepository;
import com.urs.bsi.repository.URSIoJsonDetailsRepository;
import com.urs.bsi.util.ApiGatewayService;
import com.urs.bsi.util.BsiFileUtility;
>>>>>>> 3f2994a687f11572d7d856ddd9b158f16e813ec5

@Service
public class URSConsumptionAPIServiceImpl implements URSConsumptionAPIService {
	
	public static final Logger logger = Logger.getLogger(URSConsumptionAPIServiceImpl.class);
	
	@Value("${cj.api.url}")
	private String cjAPIUrl;
	
	@Value("${cj.api.authToken}")
	private String cjAPIAuthToken;
	
	@Autowired
	private CustomerTxnDataRepository customerTxnDataRepository;

	@Autowired
	private BankStmtSummaryDataRepository bankStmtSummaryDataRepository;
	
	@Autowired
	private TplHistoryRepository tplHistoryRepository;
	
	@Autowired
	private CategoriesSummaryRepository categoriesSummaryRepository;
	
	@Autowired
	private CategoriesConsolidatedRepository ccRepository;
	
<<<<<<< HEAD
	public ApiResponse postJSONToCJ(String caseId) {
		try {
			
			TplHistory th = tplHistoryRepository.findById(Long.parseLong(caseId)).get();
			List<CustomerTxnData> ctd = customerTxnDataRepository.findByHistoryId((int)th.getId());
			List<BankStmtSummaryData> bssd = bankStmtSummaryDataRepository.findByHistoryId((int)th.getId());
			List<CategoriesSummary> cs = categoriesSummaryRepository.findByHistoryId((int)th.getId());
			CategoriesConsolidated cc = ccRepository.findByHistoryId((int)th.getId());
			
		Group group = new Group();
		group.setUnique_id(th.getUniqueId());
		List<BankStatement> bsList = new ArrayList<BankStatement>();	
		List<Summary> sList = new ArrayList<Summary>();
		for(BankStmtSummaryData bssdObj : bssd) {
			BankStatement bs = new BankStatement();
			bs.setBank_statement_id(th.getUniqueId()+bssdObj.getAccount_number()+bssdObj.getStart_date().toString()+bssdObj.getEnd_date().toString());
			bs.setAccount_id(bssdObj.getAccount_number());
			bs.setAccount_name(bssdObj.getAccount_holder_name());
			List<Transactions> lt = new ArrayList<Transactions>();
			for(CustomerTxnData ctdObj : ctd) {
				Transactions tr = new Transactions();
				tr.setId(Integer.parseInt(String.valueOf(ctdObj.getId())));
				tr.setDescription(ctdObj.getDescription());
				tr.setCurrency(bssdObj.getCurrency());
				tr.setCheck_number(ctdObj.getCheck_no());
				tr.setEntry(ctdObj.getType());
				if(null==bssdObj.getOpen_balance())
					bssdObj.setOpen_balance(new BigDecimal("0"));
				if(null==ctdObj.getTxn_amt())
					ctdObj.setTxn_amt(new BigDecimal("0"));
				if(ctdObj.getType().equalsIgnoreCase("cr"))
					tr.setBalance(bssdObj.getOpen_balance().add(ctdObj.getTxn_amt()));
				else
					tr.setBalance(bssdObj.getOpen_balance().subtract(ctdObj.getTxn_amt()));
				tr.setAmount(ctdObj.getTxn_amt());
				tr.setTimestamp(ctdObj.getTimestamp().toString());
				lt.add(tr);
=======
	@Value("${fg.base.url}")
	private String fgBaseUrl;
	
	@Value("${fg.endpoint.url}")
	private String fgEndpointUrl;
	
	@Value("${cl.client.id}")
	private String clClientId;
	
	@Value("${cl.client.secret}")
	private String clClientSecret;
	
	@Value("${cl.token.url}")
	private String clTokenUrl;
	
	@Value("${cl.api.url}")
	private String clAPIUrl;
	
	@Value("${cl.client.username}")
	private String clClientUserName;
	
	@Value("${cl.client.password}")
	private String clClientPassword;
	
	@Value("${rejection.api.url}")
	private String rejectionApiUrl;
	
	public FGToURSResponseVo callFgPostAPI(String postEntity, boolean isHistoricalData) throws UnsupportedEncodingException {
		AuthToken accessToken = null;
		int count=0;
		do{
		if(isTokenAvaliable())
			accessToken=authTokenLookUPMap.get(clientId+":"+clientSecret);
		else{
			accessToken = apiGatewayService.createMacAccessToken();
			authTokenLookUPMap.put(clientId+":"+clientSecret,accessToken);
		}
		if (null != accessToken) {
			
			logger.info("Access Token is ="+accessToken.getAccess_token());
			logger.info("Start - calling FgPostAPI");
			try {
				HttpPost post = getMacAuthHeaderForFgApi(apiGatewayService, accessToken);
				post.setEntity(new StringEntity(postEntity.toString(), "UTF-8"));
//				if(isHistoricalData)
//					post.setHeader("usecase_id","MF-HIST");
				Header[] headers = post.getAllHeaders();
				for (Header header : headers) {
					logger.info(header.getName() + ": " + header.getValue());
				}
				FGToURSResponseVo fgResponseModel = apiGatewayService.callPostApi(post, FGToURSResponseVo.class);
				if(null!=fgResponseModel)
					return fgResponseModel;
					//apiGatewayService.retryAPI(post, FGToURSResponseVo.class,3,"fgPostAPI");
				logger.info("End - FgPostAPI");
				
			} 
			catch (IOException e) {
				e.printStackTrace();
			}catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			} catch (InvalidKeyException e) {
				e.printStackTrace();
>>>>>>> 3f2994a687f11572d7d856ddd9b158f16e813ec5
			}
			
			bs.setTransactions(lt);

			bsList.add(bs);
			
			Summary s = new Summary();
			s.setAccount_id(bssdObj.getAccount_number());
			s.setAccount_name(bssdObj.getAccount_holder_name());
			s.setId(th.getUniqueId()+bssdObj.getAccount_number()+bssdObj.getStart_date().toString()+bssdObj.getEnd_date().toString());
			s.setStart_date(bssdObj.getStart_date().toString());
			s.setEnd_date(bssdObj.getEnd_date().toString());
			s.setCurrent_balance(bssdObj.getCurrent_balance());
			s.setOpen_balance(bssdObj.getOpen_balance());
			s.setClosing_balance(bssdObj.getClosing_balance());
			s.setTotal_deposits(bssdObj.getTotal_deposits());
			s.setTotal_withdrawals(bssdObj.getTotal_withdrawals());
			s.setCount_deposits(bssdObj.getCount_deposits().intValue());
			s.setCount_withdrawals(bssdObj.getCount_withdrawals().intValue());
			s.setNative_vs_non_native(bssdObj.getNative_vs_non_native());
			s.setCheck_sum((bssdObj.getOpen_balance().add(bssdObj.getTotal_deposits().subtract(bssdObj.getTotal_withdrawals()))).subtract(bssdObj.getClosing_balance()).intValue());
			
			Bank b = new Bank();
			b.setName(bssdObj.getName_of_bank());
			
			Address addr = new Address();
			addr.setAddress(bssdObj.getBank_address());
			addr.setCity(bssdObj.getBank_city());
			addr.setState(bssdObj.getBank_state());
			addr.setCountry("Mexico");
			addr.setPostal_code(bssdObj.getBank_zip());
			
			b.setAddress(addr);
			
			s.setBank(b);
			
			sList.add(s);
		}
		
		group.setTransactions(bsList);
		
<<<<<<< HEAD
		group.setSummaries(sList);
=======
		return null;
	}

	private HttpPost getMacAuthHeaderForFgApi(ApiGatewayService apiGatewayService, AuthToken accessToken)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {

		String currentTimeInMilliseconds = Long.toString(Calendar.getInstance().getTimeInMillis());
		// String currentTimeInMilliseconds =String.valueOf(ZonedDateTime.now().toInstant().toEpochMilli());
		StringBuilder nonce = new StringBuilder(currentTimeInMilliseconds + ":AMEX");
		StringBuilder tsn = new StringBuilder(currentTimeInMilliseconds + "\n");
		StringBuilder noncen = new StringBuilder(nonce + "\n");
		StringBuilder resPath = new StringBuilder(URLEncoder.encode(fgEndpointUrl,StandardCharsets.UTF_8.toString()) + "\n");
		StringBuilder host = new StringBuilder(fgBaseUrl).append("\n");
		StringBuilder baseString = new StringBuilder(tsn.toString() + noncen.toString() + "POST\n" + resPath + host.toString().replace("https://", "") + "443\n" + "\n");
		String hash = apiGatewayService.getSignature(accessToken.getMac_key(), baseString.toString());
		String signature = URLDecoder.decode(hash, "UTF-8").replace("\r\n", EMPTY_STRING);
		StringBuilder macAuthHeader = new StringBuilder("MAC id=\"" + accessToken.getAccess_token() + "\",ts=\""+ currentTimeInMilliseconds + "\",nonce=\"" + nonce + "\",mac=\"" + signature + "\"");
		StringBuilder url = new StringBuilder(fgBaseUrl + fgEndpointUrl);
		
		HttpPost post = new HttpPost(url.toString());
		post.setHeader("Authorization", macAuthHeader.toString());
		post.setHeader("X-AMEX-API-KEY", clientId);
		post.setHeader("client_app_id", "URS");
		post.setHeader("Content-Type", "application/json");
		post.setHeader("country_code","US");
		post.setHeader("currency_code","USD");
		post.setHeader("client_channel_code","Web");
		post.setHeader("client_platform_code","clientplatform");
		post.setHeader("request_timestamp",BsiFileUtility.getCurrentTimeMMDDYYYYHHMMSS());
		post.setHeader("usecase_id","RLI");
		post.setHeader("correlation_id",BsiFileUtility.getUuidBatchId());
		
		return post;
	}

	private boolean isTokenAvaliable() {
		return null!=authTokenLookUPMap && authTokenLookUPMap.containsKey(clientId+":"+clientSecret) && null!=authTokenLookUPMap.get(clientId+":"+clientSecret) && null!=authTokenLookUPMap.get(clientId+":"+clientSecret).getExpires_date() && authTokenLookUPMap.get(clientId+":"+clientSecret).getExpires_date().after(new Date());
	}

	
	public URSToFGRequestVo prepareURSToFgJson(String se10){
		SpreadingMasterData spreadingMasterData=spreadingMasterDataRepository.findBySe10(se10);
		if(null==spreadingMasterData) return null;
		URSToFGRequestVo customerDataVo=prepareCustomerDataVo(spreadingMasterData);
		return customerDataVo;
	}
	
	private void saveFgJsonToTbl(String customerDataVo,String fGToURSResponseVo) {
		URSIoJsonDetails usrIoJsonDetails=new URSIoJsonDetails();
		usrIoJsonDetails.setFromEntity("URS");
		usrIoJsonDetails.setToEntity("FG");
		usrIoJsonDetails.setRequestJson(customerDataVo);
		usrIoJsonDetails.setResponseJson(fGToURSResponseVo);
		logger.info("Inserting data in JSON tbl");
		ursIoJsonDetailsRepository.save(usrIoJsonDetails);
		logger.info("Data inserted successfully JSON tbl");
	}

	@Override
	public FGToURSResponseVo consumeFGApi(String se10) throws JsonProcessingException, UnsupportedEncodingException{
>>>>>>> 3f2994a687f11572d7d856ddd9b158f16e813ec5
		
		Categories cat = new Categories();
		cat.setCurrency("MXN");
		
		CategoriesL1 cl1 = new CategoriesL1();
		
<<<<<<< HEAD
		CategoriesL2 cl2 = new CategoriesL2();
		
		CategoriesL3 cl3Credit = new CategoriesL3();
		cl3Credit.setTotal_amount(cc.getTotal_credit_amount());
		cl3Credit.setTotal_count(cc.getTotal_credit_count_of_txn());
		List<Category> consolidatedCreditList = getConsolidatedCategoriesListCredit(cc);
		cl3Credit.setCategories(consolidatedCreditList);
		cl2.setCredit(cl3Credit);
		
		CategoriesL3 cl3Debit = new CategoriesL3();
		cl3Debit.setTotal_amount(cc.getTotal_debit_amt());
		cl3Debit.setTotal_count(cc.getTotal_debit_count_of_txn());
		List<Category> consolidatedDebitList = getConsolidatedCategoriesListDebit(cc);
		cl3Debit.setCategories(consolidatedDebitList);
		cl2.setDebit(cl3Debit);
		Map<String,CategoriesL2> categories = new HashMap<String, CategoriesL2>();
//		cl1.setConsolidated(cl2);
		categories.put("consolidated", cl2);
		int i=1;
		for(CategoriesSummary csObj : cs) {
			
			CategoriesL2 cl2Summary = new CategoriesL2();
			
			CategoriesL3 cl3CreditSummary = new CategoriesL3();
			cl3CreditSummary.setTotal_amount(cc.getTotal_credit_amount());
			cl3CreditSummary.setTotal_count(cc.getTotal_credit_count_of_txn());
			List<Category> consolidatedCreditListSummary = getSummaryCategoriesListCredit(csObj);
			cl3CreditSummary.setCategories(consolidatedCreditListSummary);
			cl2Summary.setCredit(cl3CreditSummary);
			
			CategoriesL3 cl3DebitSummary = new CategoriesL3();
			cl3DebitSummary.setTotal_amount(cc.getTotal_debit_amt());
			cl3DebitSummary.setTotal_count(cc.getTotal_debit_count_of_txn());
			List<Category> consolidatedDebitListSummary = getSummaryCategoriesListDebit(csObj);
			cl3DebitSummary.setCategories(consolidatedDebitListSummary);
			cl2Summary.setDebit(cl3DebitSummary);
			
			categories.put(csObj.getCategory_type(), cl2Summary);
			i++;
		}
		cat.setCategories(categories);
		group.setSummary_categories(cat);
		
		ObjectMapper om=new ObjectMapper();	
		String postEntity = om.writeValueAsString(group);
		logger.info(postEntity);
		
		return callCJPostAPI(postEntity);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ApiResponse();
=======
		return fGToURSResponseVo;
	}

	private URSToFGRequestVo prepareCustomerDataVo(SpreadingMasterData spreadingMasterData) {
		
		URSToFGRequestVo ursToFGRequestVo=new URSToFGRequestVo();
		CustomerDataVo customerDataVo=new CustomerDataVo();
		
		RequestedAccount requestedAccount=new RequestedAccount();
		List<RequestedAccount> requestedAccountList =new ArrayList<>();
		
		customerDataVo.setProcess_control_number(null!=spreadingMasterData.getSe10()?spreadingMasterData.getSe10():EMPTY_STRING);
		customerDataVo.setBusiness_id(null!=spreadingMasterData.getBusinessId()?spreadingMasterData.getBusinessId():EMPTY_STRING);
		customerDataVo.setCase_id(null!=spreadingMasterData.getBusinessId()?spreadingMasterData.getBusinessId():EMPTY_STRING);
		customerDataVo.setRequest_limit(null!=spreadingMasterData.getRequestedLimit()?spreadingMasterData.getRequestedLimit():EMPTY_STRING);
		customerDataVo.setSpread_date(formatDateToMMDDYYYYHHMMSS(spreadingMasterData.getSpreadingDoneOn()));
		customerDataVo.setAccount_business_unit_code("GCP");
		customerDataVo.setContainer_type(null!=spreadingMasterData.getContainerType()?spreadingMasterData.getContainerType():EMPTY_STRING);
		customerDataVo.setSource_of_origin(null!=spreadingMasterData.getDataSource()?spreadingMasterData.getDataSource():EMPTY_STRING);
		
		customerDataVo.setDoing_business_as_name(EMPTY_STRING);
		customerDataVo.setConsumer_name(EMPTY_STRING);
		customerDataVo.setRe_spread_indicator("false");
		
			requestedAccount.setUnique_id_type("client_org_id");
		if("2020244DP001SGD".equalsIgnoreCase(spreadingMasterData.getSe10())) {
			customerDataVo.setCompany_name("NTT SINGAPORE PTE. LTD.");
			requestedAccount.setUnique_id("011222462");
		}
		if("2020244DP002CAD".equalsIgnoreCase(spreadingMasterData.getSe10())){
			customerDataVo.setCompany_name("DIXIN CONSTRUCTION LIMITED");
			requestedAccount.setUnique_id("001545952");
		}
		if("2020244DP003SGD".equalsIgnoreCase(spreadingMasterData.getSe10())){
			customerDataVo.setCompany_name("DIRECT ASIA MANAGEMENT SERVICES PTE. LTD.");
			requestedAccount.setUnique_id("011700891");
		}
		if("2020244DP004AUG".equalsIgnoreCase(spreadingMasterData.getSe10())){
			customerDataVo.setCompany_name("THE TRUSTEE FOR MARSHALL WHITE MARKETING TRUST");
			requestedAccount.setUnique_id("006703348");
		}
		if("2020244DP005CAD".equalsIgnoreCase(spreadingMasterData.getSe10())){
			customerDataVo.setCompany_name("DAVE & BUSTER'S, INC.");
			requestedAccount.setUnique_id("001607430");
		}
		if("2020244DP006CAD".equalsIgnoreCase(spreadingMasterData.getSe10())){
			customerDataVo.setCompany_name("ISACSOFT INC");
			requestedAccount.setUnique_id("001506095");
		}
		if("2020244DP007GBP".equalsIgnoreCase(spreadingMasterData.getSe10())){
			customerDataVo.setCompany_name("RED COMMERCE LIMITED");
			requestedAccount.setUnique_id("036418102");
		}
		if("2020244DP008GBP".equalsIgnoreCase(spreadingMasterData.getSe10())){
			customerDataVo.setCompany_name("RED COMMERCE LIMITED");
			requestedAccount.setUnique_id("036417891");
		}

		requestedAccountList.add(requestedAccount);
		customerDataVo.setRequested_account(requestedAccountList);
		customerDataVo.setAccount_data(getAccountVo(spreadingMasterData.getSpreadingAccountDataList()));
		//customerDataVo.setCompany_name(customerDataVo.getAccount_data().get(0).getAccount_holder_name()); // Setting company name same as first account holder name
		ursToFGRequestVo.setCustomer_data(customerDataVo);
		return ursToFGRequestVo;
>>>>>>> 3f2994a687f11572d7d856ddd9b158f16e813ec5
	}
	
	private ApiResponse callCJPostAPI(String postEntity) {
		HttpPost post = new HttpPost(cjAPIUrl);
		post.setHeader("Authorization", "Bearer "+cjAPIAuthToken);
		post.setEntity(new StringEntity(postEntity.toString(), "UTF-8"));
		ApiResponse ar = null;
		try {
			ar = callPostApi(post);
			logger.info(ar.getMessage());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ar;
	}

	public ApiResponse callPostApi(HttpPost post)
			throws IOException, ClientProtocolException, JsonParseException, JsonMappingException {
		logger.info("Processing request:"+post.getURI());
		CloseableHttpClient client = HttpClientBuilder.create().build();
		CloseableHttpResponse response = client.execute(post);
		if(response.getStatusLine().getStatusCode()!=200) {
			logger.error("API failed. Error code:"+response.getStatusLine().getStatusCode()+" Message:"+response.getStatusLine());
		}
		else{
			logger.info("API invoked successfully. ResponseCode:"+response.getStatusLine().getStatusCode()+" Message:"+response.getStatusLine());
		}
		post.releaseConnection();
		ApiResponse ar = new ApiResponse();
		ar.setCode(response.getStatusLine().getStatusCode());
		ar.setMessage(IOUtils.toString(response.getEntity().getContent()).replace("{", "").replace("}", ""));
		return ar;
	}
	
	private List<Category> getConsolidatedCategoriesListCredit(CategoriesConsolidated cc) {
		List<Category> catList = new ArrayList<Category>();

		Category catgSalesCard = new Category();
		catgSalesCard.setAmount(cc.getSales_card_amt());
		catgSalesCard.setName("Sales - Card");
		catgSalesCard.setTransaction_count(cc.getSales_card_count());
		catList.add(catgSalesCard);
		
		Category catgSalesNonCard = new Category();
		catgSalesNonCard.setAmount(cc.getSales_non_card_amt());
		catgSalesNonCard.setName("Sales - Non card");
		catgSalesNonCard.setTransaction_count(cc.getSales_non_card_count());
		catList.add(catgSalesNonCard);
		
		Category catgCashDeposit = new Category();
		catgCashDeposit.setAmount(cc.getCash_deposit_amt());
		catgCashDeposit.setName("Cash Deposit");
		catgCashDeposit.setTransaction_count(cc.getCash_deposit_count());
		catList.add(catgCashDeposit);
		
		Category catgRefRev = new Category();
		catgRefRev.setAmount(cc.getRefund_reversals_amt());
		catgRefRev.setName("Refund/Reversals");
		catgRefRev.setTransaction_count(cc.getRefund_reversals_count());
		catList.add(catgSalesCard);
		
		Category catgIAT = new Category();
		catgIAT.setAmount(cc.getIntra_account_transfer_amt());
		catgIAT.setName("Intra Account Transfer");
		catgIAT.setTransaction_count(cc.getIntra_account_transfer_count());
		catList.add(catgIAT);
		
		Category catgNGC = new Category();
		catgNGC.setAmount(cc.getNg_check_amt());
		catgNGC.setName("NG Check");
		catgNGC.setTransaction_count(cc.getNg_check_count());
		catList.add(catgNGC);
		
		Category catgLoan = new Category();
		catgLoan.setAmount(cc.getSales_card_amt());
		catgLoan.setName("Loans");
		catgLoan.setTransaction_count(cc.getSales_card_count());
		catList.add(catgLoan);
		
		Category catgInvInc = new Category();
		catgInvInc.setAmount(cc.getInvestment_income_amt());
		catgInvInc.setName("Investment Income");
		catgInvInc.setTransaction_count(cc.getInvestment_income_count());
		catList.add(catgInvInc);
		
		Category catgInsClaim = new Category();
		catgInsClaim.setAmount(cc.getInsurance_claim_amt());
		catgInsClaim.setName("Insurance Claim");
		catgInsClaim.setTransaction_count(cc.getInsurance_claim_count());
		catList.add(catgInsClaim);
		
		Category catgMiscCr = new Category();
		catgMiscCr.setAmount(cc.getMiscellaneous_credits_amt());
		catgMiscCr.setName("Miscellaneous Credits");
		catgMiscCr.setTransaction_count(cc.getMiscellaneous_credits_count());
		catList.add(catgMiscCr);
		
		
		return catList;
	}
	
	private List<Category> getConsolidatedCategoriesListDebit(CategoriesConsolidated cc) {
		List<Category> catList = new ArrayList<Category>();

		Category catgSalesCard = new Category();
		catgSalesCard.setAmount(cc.getVendor_payments_amt());
		catgSalesCard.setName("Vendor Payments");
		catgSalesCard.setTransaction_count(cc.getVendor_payments_count());
		catList.add(catgSalesCard);
		
		Category catgSalesNonCard = new Category();
		catgSalesNonCard.setAmount(cc.getSalaries_benefits_amt());
		catgSalesNonCard.setName("Salaries & Benefits");
		catgSalesNonCard.setTransaction_count(cc.getSalaries_benefits_count());
		catList.add(catgSalesNonCard);
		
		Category catgCashDeposit = new Category();
		catgCashDeposit.setAmount(cc.getTaxes_amt());
		catgCashDeposit.setName("Taxes");
		catgCashDeposit.setTransaction_count(cc.getTaxes_count());
		catList.add(catgCashDeposit);
		
		Category catgRefRev = new Category();
		catgRefRev.setAmount(cc.getInsurance_amt());
		catgRefRev.setName("Insurance");
		catgRefRev.setTransaction_count(cc.getInsurance_count());
		catList.add(catgSalesCard);
		
		Category catgCW = new Category();
		catgCW.setAmount(cc.getCash_withdrawal_amt());
		catgCW.setName("Cash Withdrawal");
		catgCW.setTransaction_count(cc.getCash_withdrawal_count());
		catList.add(catgCW);
		
		Category catgNGC = new Category();
		catgNGC.setAmount(cc.getCard_processor_fees_amt());
		catgNGC.setName("Card Processor Fees");
		catgNGC.setTransaction_count(cc.getCard_processor_fees_count());
		catList.add(catgNGC);
		
		Category catgLoan = new Category();
		catgLoan.setAmount(cc.getChargeback_amt());
		catgLoan.setName("Chargeback");
		catgLoan.setTransaction_count(cc.getChargeback_count());
		catList.add(catgLoan);
		
		Category catgInvInc = new Category();
		catgInvInc.setAmount(cc.getCredit_card_payments_amt());
		catgInvInc.setName("Credit Card Payments");
		catgInvInc.setTransaction_count(cc.getCredit_card_payments_count());
		catList.add(catgInvInc);
		
		Category catgInsClaim = new Category();
		catgInsClaim.setAmount(cc.getLoan_repayment_emi_lenders_amt());
		catgInsClaim.setName("Loan Repayment/EMI - Lenders");
		catgInsClaim.setTransaction_count(cc.getLoan_repayment_emi_lenders_count());
		catList.add(catgInsClaim);
		
		Category catgMiscCr = new Category();
		catgMiscCr.setAmount(cc.getLoan_repayment_emi_mortgage_amt());
		catgMiscCr.setName("Loan Repayment/EMI - Mortgage");
		catgMiscCr.setTransaction_count(cc.getLoan_repayment_emi_mortgage_count());
		catList.add(catgMiscCr);
		
		Category catgLRAF = new Category();
		catgLRAF.setAmount(cc.getLoan_repayment_emi_auto_finance_amt());
		catgLRAF.setName("Loan Repayment/EMI - Auto Finance");
		catgLRAF.setTransaction_count(cc.getLoan_repayment_emi_auto_finance_count());
		catList.add(catgLRAF);
		
		Category catgIAT = new Category();
		catgIAT.setAmount(cc.getIntra_account_transfer_amt());
		catgIAT.setName("Intra Account Transfer");
		catgIAT.setTransaction_count(cc.getIntra_account_transfer_count());
		catList.add(catgIAT);
		
		Category catgFeeNG = new Category();
		catgFeeNG.setAmount(cc.getFees_ng_amt());
		catgFeeNG.setName("Fees - NG");
		catgFeeNG.setTransaction_count(cc.getFees_ng_count());
		catList.add(catgFeeNG);
		
		Category catgFeeOD = new Category();
		catgFeeOD.setAmount(cc.getInsurance_amt());
		catgFeeOD.setName("Fees - Overdraft");
		catgFeeOD.setTransaction_count(cc.getInsurance_count());
		catList.add(catgFeeOD);
		
		Category catgFeeOther = new Category();
		catgFeeOther.setAmount(cc.getFees_others_amt());
		catgFeeOther.setName("Fees - Others");
		catgFeeOther.setTransaction_count(cc.getFees_others_count());
		catList.add(catgFeeOther);
		
		Category catgInv = new Category();
		catgInv.setAmount(cc.getInvestments_amt());
		catgInv.setName("Investments");
		catgInv.setTransaction_count(cc.getInvestments_count());
		catList.add(catgInv);
		
		Category catgDCR = new Category();
		catgDCR.setAmount(cc.getChargeback_amt());
		catgDCR.setName("Deposited Check Return");
		catgDCR.setTransaction_count(cc.getChargeback_count());
		catList.add(catgDCR);
		
		Category catgMD = new Category();
		catgMD.setAmount(cc.getMiscellaneous_debit_amt());
		catgMD.setName("Miscellaneous Debit");
		catgMD.setTransaction_count(cc.getMiscellaneous_debit_count());
		catList.add(catgMD);
		
		Category catgTEA = new Category();
		catgTEA.setAmount(cc.getTravel_expenses_airlines_amt());
		catgTEA.setName("Travel Expenses - Airlines");
		catgTEA.setTransaction_count(cc.getTravel_expenses_airlines_count());
		catList.add(catgTEA);
		
		Category catgTEH = new Category();
		catgTEH.setAmount(cc.getTravel_expenses_hotels_amt());
		catgTEH.setName("Travel Expenses - Hotels");
		catgTEH.setTransaction_count(cc.getTravel_expenses_hotels_count());
		catList.add(catgTEH);

		Category catgTECR = new Category();
		catgTECR.setAmount(cc.getTravel_epenses_car_rental_amt());
		catgTECR.setName("Travel Expenses - Car Rental");
		catgTECR.setTransaction_count(cc.getTravel_epenses_car_rental_count());
		catList.add(catgTECR);
		
		Category catgTEOth = new Category();
		catgTEOth.setAmount(cc.getTravel_expenses_others_amt());
		catgTEOth.setName("Travel Expenses - Others");
		catgTEOth.setTransaction_count(cc.getTravel_expenses_others_count());
		catList.add(catgTEOth);
		
		Category catgUtilTel = new Category();
		catgUtilTel.setAmount(cc.getUtilities_telephone_amt());
		catgUtilTel.setName("Utilities - Telephone");
		catgUtilTel.setTransaction_count(cc.getUtilities_telephone_count());
		catList.add(catgUtilTel);
		
		Category catgUtilInt = new Category();
		catgUtilInt.setAmount(cc.getUtilities_internet_amt());
		catgUtilInt.setName("Utilities - Internet");
		catgUtilInt.setTransaction_count(cc.getUtilities_internet_count());
		catList.add(catgUtilInt);
		
		Category catgUtilTV = new Category();
		catgUtilTV.setAmount(cc.getUtilities_tv_amt());
		catgUtilTV.setName("Utilities - TV");
		catgUtilTV.setTransaction_count(cc.getUtilities_tv_count());
		catList.add(catgUtilTV);
		
		Category catgUtilPwr = new Category();
		catgUtilPwr.setAmount(cc.getUtilities_power_amt());
		catgUtilPwr.setName("Utilities - Power");
		catgUtilPwr.setTransaction_count(cc.getUtilities_power_count());
		catList.add(catgUtilPwr);
		
		Category catgUtilWater = new Category();
		catgUtilWater.setAmount(cc.getUtilities_water_amt());
		catgUtilWater.setName("Utilities - Water");
		catgUtilWater.setTransaction_count(cc.getUtilities_water_count());
		catList.add(catgUtilWater);
		
		Category catgUtilOth = new Category();
		catgUtilOth.setAmount(cc.getUtilities_others_amt());
		catgUtilOth.setName("Utilities - Others");
		catgUtilOth.setTransaction_count(cc.getUtilities_others_count());
		catList.add(catgUtilOth);
		
		return catList;
	}
	
	private List<Category> getSummaryCategoriesListCredit(CategoriesSummary cc) {
		List<Category> catList = new ArrayList<Category>();

		Category catgSalesCard = new Category();
		catgSalesCard.setAmount(cc.getSales_card_amt());
		catgSalesCard.setName("Sales - Card");
		catgSalesCard.setTransaction_count(cc.getSales_card_count());
		catList.add(catgSalesCard);
		
		Category catgSalesNonCard = new Category();
		catgSalesNonCard.setAmount(cc.getSales_non_card_amt());
		catgSalesNonCard.setName("Sales - Non card");
		catgSalesNonCard.setTransaction_count(cc.getSales_non_card_count());
		catList.add(catgSalesNonCard);
		
		Category catgCashDeposit = new Category();
		catgCashDeposit.setAmount(cc.getCash_deposit_amt());
		catgCashDeposit.setName("Cash Deposit");
		catgCashDeposit.setTransaction_count(cc.getCash_deposit_count());
		catList.add(catgCashDeposit);
		
		Category catgRefRev = new Category();
		catgRefRev.setAmount(cc.getRefund_reversals_amt());
		catgRefRev.setName("Refund/Reversals");
		catgRefRev.setTransaction_count(cc.getRefund_reversals_count());
		catList.add(catgSalesCard);
		
		Category catgIAT = new Category();
		catgIAT.setAmount(cc.getIntra_account_transfer_amt());
		catgIAT.setName("Intra Account Transfer");
		catgIAT.setTransaction_count(cc.getIntra_account_transfer_count());
		catList.add(catgIAT);
		
		Category catgNGC = new Category();
		catgNGC.setAmount(cc.getNg_check_amt());
		catgNGC.setName("NG Check");
		catgNGC.setTransaction_count(cc.getNg_check_count());
		catList.add(catgNGC);
		
		Category catgLoan = new Category();
		catgLoan.setAmount(cc.getSales_card_amt());
		catgLoan.setName("Loans");
		catgLoan.setTransaction_count(cc.getSales_card_count());
		catList.add(catgLoan);
		
		Category catgInvInc = new Category();
		catgInvInc.setAmount(cc.getInvestment_income_amt());
		catgInvInc.setName("Investment Income");
		catgInvInc.setTransaction_count(cc.getInvestment_income_count());
		catList.add(catgInvInc);
		
		Category catgInsClaim = new Category();
		catgInsClaim.setAmount(cc.getInsurance_claim_amt());
		catgInsClaim.setName("Insurance Claim");
		catgInsClaim.setTransaction_count(cc.getInsurance_claim_count());
		catList.add(catgInsClaim);
		
		Category catgMiscCr = new Category();
		catgMiscCr.setAmount(cc.getMiscellaneous_credits_amt());
		catgMiscCr.setName("Miscellaneous Credits");
		catgMiscCr.setTransaction_count(cc.getMiscellaneous_credits_count());
		catList.add(catgMiscCr);
		
		
		return catList;
	}
	
	private List<Category> getSummaryCategoriesListDebit(CategoriesSummary cc) {
		List<Category> catList = new ArrayList<Category>();

		Category catgSalesCard = new Category();
		catgSalesCard.setAmount(cc.getVendor_payments_amt());
		catgSalesCard.setName("Vendor Payments");
		catgSalesCard.setTransaction_count(cc.getVendor_payments_count());
		catList.add(catgSalesCard);
		
		Category catgSalesNonCard = new Category();
		catgSalesNonCard.setAmount(cc.getSalaries_benefits_amt());
		catgSalesNonCard.setName("Salaries & Benefits");
		catgSalesNonCard.setTransaction_count(cc.getSalaries_benefits_count());
		catList.add(catgSalesNonCard);
		
		Category catgCashDeposit = new Category();
		catgCashDeposit.setAmount(cc.getTaxes_amt());
		catgCashDeposit.setName("Taxes");
		catgCashDeposit.setTransaction_count(cc.getTaxes_count());
		catList.add(catgCashDeposit);
		
		Category catgRefRev = new Category();
		catgRefRev.setAmount(cc.getInsurance_amt());
		catgRefRev.setName("Insurance");
		catgRefRev.setTransaction_count(cc.getInsurance_count());
		catList.add(catgSalesCard);
		
		Category catgCW = new Category();
		catgCW.setAmount(cc.getCash_withdrawal_amt());
		catgCW.setName("Cash Withdrawal");
		catgCW.setTransaction_count(cc.getCash_withdrawal_count());
		catList.add(catgCW);
		
		Category catgNGC = new Category();
		catgNGC.setAmount(cc.getCard_processor_fees_amt());
		catgNGC.setName("Card Processor Fees");
		catgNGC.setTransaction_count(cc.getCard_processor_fees_count());
		catList.add(catgNGC);
		
		Category catgLoan = new Category();
		catgLoan.setAmount(cc.getChargeback_amt());
		catgLoan.setName("Chargeback");
		catgLoan.setTransaction_count(cc.getChargeback_count());
		catList.add(catgLoan);
		
		Category catgInvInc = new Category();
		catgInvInc.setAmount(cc.getCredit_card_payments_amt());
		catgInvInc.setName("Credit Card Payments");
		catgInvInc.setTransaction_count(cc.getCredit_card_payments_count());
		catList.add(catgInvInc);
		
		Category catgInsClaim = new Category();
		catgInsClaim.setAmount(cc.getLoan_repayment_emi_lenders_amt());
		catgInsClaim.setName("Loan Repayment/EMI - Lenders");
		catgInsClaim.setTransaction_count(cc.getLoan_repayment_emi_lenders_count());
		catList.add(catgInsClaim);
		
		Category catgMiscCr = new Category();
		catgMiscCr.setAmount(cc.getLoan_repayment_emi_mortgage_amt());
		catgMiscCr.setName("Loan Repayment/EMI - Mortgage");
		catgMiscCr.setTransaction_count(cc.getLoan_repayment_emi_mortgage_count());
		catList.add(catgMiscCr);
		
		Category catgLRAF = new Category();
		catgLRAF.setAmount(cc.getLoan_repayment_emi_auto_finance_amt());
		catgLRAF.setName("Loan Repayment/EMI - Auto Finance");
		catgLRAF.setTransaction_count(cc.getLoan_repayment_emi_auto_finance_count());
		catList.add(catgLRAF);
		
		Category catgIAT = new Category();
		catgIAT.setAmount(cc.getIntra_account_transfer_amt());
		catgIAT.setName("Intra Account Transfer");
		catgIAT.setTransaction_count(cc.getIntra_account_transfer_count());
		catList.add(catgIAT);
		
		Category catgFeeNG = new Category();
		catgFeeNG.setAmount(cc.getFees_ng_amt());
		catgFeeNG.setName("Fees - NG");
		catgFeeNG.setTransaction_count(cc.getFees_ng_count());
		catList.add(catgFeeNG);
		
		Category catgFeeOD = new Category();
		catgFeeOD.setAmount(cc.getInsurance_amt());
		catgFeeOD.setName("Fees - Overdraft");
		catgFeeOD.setTransaction_count(cc.getInsurance_count());
		catList.add(catgFeeOD);
		
		Category catgFeeOther = new Category();
		catgFeeOther.setAmount(cc.getFees_others_amt());
		catgFeeOther.setName("Fees - Others");
		catgFeeOther.setTransaction_count(cc.getFees_others_count());
		catList.add(catgFeeOther);
		
		Category catgInv = new Category();
		catgInv.setAmount(cc.getInvestments_amt());
		catgInv.setName("Investments");
		catgInv.setTransaction_count(cc.getInvestments_count());
		catList.add(catgInv);
		
		Category catgDCR = new Category();
		catgDCR.setAmount(cc.getChargeback_amt());
		catgDCR.setName("Deposited Check Return");
		catgDCR.setTransaction_count(cc.getChargeback_count());
		catList.add(catgDCR);
		
		Category catgMD = new Category();
		catgMD.setAmount(cc.getMiscellaneous_debit_amt());
		catgMD.setName("Miscellaneous Debit");
		catgMD.setTransaction_count(cc.getMiscellaneous_debit_count());
		catList.add(catgMD);
		
		Category catgTEA = new Category();
		catgTEA.setAmount(cc.getTravel_expenses_airlines_amt());
		catgTEA.setName("Travel Expenses - Airlines");
		catgTEA.setTransaction_count(cc.getTravel_expenses_airlines_count());
		catList.add(catgTEA);
		
		Category catgTEH = new Category();
		catgTEH.setAmount(cc.getTravel_expenses_hotels_amt());
		catgTEH.setName("Travel Expenses - Hotels");
		catgTEH.setTransaction_count(cc.getTravel_expenses_hotels_count());
		catList.add(catgTEH);

		Category catgTECR = new Category();
		catgTECR.setAmount(cc.getTravel_epenses_car_rental_amt());
		catgTECR.setName("Travel Expenses - Car Rental");
		catgTECR.setTransaction_count(cc.getTravel_epenses_car_rental_count());
		catList.add(catgTECR);
		
		Category catgTEOth = new Category();
		catgTEOth.setAmount(cc.getTravel_expenses_others_amt());
		catgTEOth.setName("Travel Expenses - Others");
		catgTEOth.setTransaction_count(cc.getTravel_expenses_others_count());
		catList.add(catgTEOth);
		
		Category catgUtilTel = new Category();
		catgUtilTel.setAmount(cc.getUtilities_telephone_amt());
		catgUtilTel.setName("Utilities - Telephone");
		catgUtilTel.setTransaction_count(cc.getUtilities_telephone_count());
		catList.add(catgUtilTel);
		
		Category catgUtilInt = new Category();
		catgUtilInt.setAmount(cc.getUtilities_internet_amt());
		catgUtilInt.setName("Utilities - Internet");
		catgUtilInt.setTransaction_count(cc.getUtilities_internet_count());
		catList.add(catgUtilInt);
		
		Category catgUtilTV = new Category();
		catgUtilTV.setAmount(cc.getUtilities_tv_amt());
		catgUtilTV.setName("Utilities - TV");
		catgUtilTV.setTransaction_count(cc.getUtilities_tv_count());
		catList.add(catgUtilTV);
		
		Category catgUtilPwr = new Category();
		catgUtilPwr.setAmount(cc.getUtilities_power_amt());
		catgUtilPwr.setName("Utilities - Power");
		catgUtilPwr.setTransaction_count(cc.getUtilities_power_count());
		catList.add(catgUtilPwr);
		
		Category catgUtilWater = new Category();
		catgUtilWater.setAmount(cc.getUtilities_water_amt());
		catgUtilWater.setName("Utilities - Water");
		catgUtilWater.setTransaction_count(cc.getUtilities_water_count());
		catList.add(catgUtilWater);
		
		Category catgUtilOth = new Category();
		catgUtilOth.setAmount(cc.getUtilities_others_amt());
		catgUtilOth.setName("Utilities - Others");
		catgUtilOth.setTransaction_count(cc.getUtilities_others_count());
		catList.add(catgUtilOth);
		
		return catList;
	}

<<<<<<< HEAD

//	public DocumentRejectionResponseVo postDocumentRejection(String se10) {
//		DocumentRejectionVo drVo = new DocumentRejectionVo();
//		drVo.setIs_spread_completed("N");
//		drVo.setReject_reason_text("In attached document we have received 2017 2016 Tax return and CoPrepared interim 2019 FS please provide the FYE 2018 FS to complete the spreading activity");
//		drVo.setReject_reason("INC");
//		drVo.setStatus("RJCTD");
//		try {
//			ObjectMapper om=new ObjectMapper();	
//			String postEntity = om.writeValueAsString(drVo);
//			HttpPost post = getPostForDocRejection();
//			post.setEntity(new StringEntity(postEntity.toString(), "UTF-8"));
//			DocumentRejectionResponseVo drResponseModel = apiGatewayService.callPostApi(post, DocumentRejectionResponseVo.class);
//			return drResponseModel;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	private HttpPost getPostForDocRejection(){
//		HttpPost post = new HttpPost(rejectionApiUrl);
//		post.setHeader("country", "US");
//		post.setHeader("request_timestamp", BsiFileUtility.getCurrentTimeYYYYMMDDHHMMSS());
//		post.setHeader("correlation_id", BsiFileUtility.getUuidBatchId());
//		post.setHeader("consumer","URS");
//		return post;
//	}
=======
	private HttpPost getAuthHeaderForCLTokenApi(){
		HttpPost post = new HttpPost(clTokenUrl);
		post.setHeader("grant_type", "password");
		post.setHeader("client_id", clientId);
		post.setHeader("client_secret", clClientSecret);
		post.setHeader("username", clClientUserName);
		post.setHeader("password",clClientPassword);
		return post;
	}
	
	private HttpPost getPostForCLPostApi(String token){
		HttpPost post = new HttpPost(clAPIUrl);
		post.setHeader("Authorization", "Bearer "+token);
		return post;
	}

	public DocumentRejectionResponseVo postDocumentRejection(String se10) {
		DocumentRejectionVo drVo = new DocumentRejectionVo();
		drVo.setIs_spread_completed("N");
		drVo.setReject_reason_text("In attached document we have received 2017 2016 Tax return and CoPrepared interim 2019 FS please provide the FYE 2018 FS to complete the spreading activity");
		drVo.setReject_reason("INC");
		drVo.setStatus("RJCTD");
		try {
			ObjectMapper om=new ObjectMapper();	
			String postEntity = om.writeValueAsString(drVo);
			HttpPost post = getPostForDocRejection();
			post.setEntity(new StringEntity(postEntity.toString(), "UTF-8"));
			DocumentRejectionResponseVo drResponseModel = apiGatewayService.callPostApi(post, DocumentRejectionResponseVo.class);
			return drResponseModel;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private HttpPost getPostForDocRejection(){
		HttpPost post = new HttpPost(rejectionApiUrl);
		post.setHeader("country", "US");
		post.setHeader("request_timestamp", BsiFileUtility.getCurrentTimeYYYYMMDDHHMMSS());
		post.setHeader("correlation_id", BsiFileUtility.getUuidBatchId());
		post.setHeader("consumer","URS");
		return post;
	}
>>>>>>> 3f2994a687f11572d7d856ddd9b158f16e813ec5
	
}
