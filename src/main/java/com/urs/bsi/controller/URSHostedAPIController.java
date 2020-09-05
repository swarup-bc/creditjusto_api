package com.urs.bsi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.urs.bsi.model.SpreadingRequestData;
import com.urs.bsi.model.SpreadingResponseData;
import com.urs.bsi.model.vo.spreadingreq.SpreadingRequestVo;
import com.urs.bsi.model.vo.spreadingreq.SpreadingResponseVo;
import com.urs.bsi.service.BsiCommonService;

@Controller
public class URSHostedAPIController {
	
	@Autowired
	private BsiCommonService bsiCommonService;
	
	private static Logger logger = LogManager.getLogger(URSHostedAPIController.class);
	
	@RequestMapping(method = RequestMethod.POST, value = "/bank-statement-spreading-request", produces = "application/json", consumes = {"application/json","multipart/form-data"})
	public ResponseEntity<SpreadingResponseVo> spreadingRequestData(@RequestPart("file") MultipartFile[] file,
			@RequestPart(name="spreadingRequestJson",required=true) SpreadingRequestVo spreadingRequestVo,
			@RequestHeader("client_app_id") String clientAppId,
			@RequestHeader("request_timestamp") String requestTimestamp,
			@RequestHeader("correlation_id") String correlationId) throws IOException {
		logger.info("spreading-request-data post API started :: ");
	    ResponseEntity<SpreadingResponseVo> responseEntity = null;
	    SpreadingResponseVo responseVo = null;
	    SpreadingRequestData spreadingReqData = null;
	    try {
	    	spreadingReqData = bsiCommonService.persistSpreadingRequestData(spreadingRequestVo, clientAppId, requestTimestamp, correlationId);
	    	responseVo = createResponse(clientAppId, correlationId,spreadingReqData.getProcess_control_number(), HttpStatus.OK);
	    	responseEntity = new ResponseEntity<SpreadingResponseVo>(responseVo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in spreading-request-data", e);
			responseVo = createResponse(clientAppId, correlationId,spreadingReqData.getProcess_control_number(),HttpStatus.INTERNAL_SERVER_ERROR);
			responseEntity = new ResponseEntity<SpreadingResponseVo>(responseVo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    SpreadingResponseData spreadingResponseData =  bsiCommonService.persistSpreadingResponse(responseVo, spreadingReqData,spreadingRequestVo);
	    return responseEntity;
	}
	
	private SpreadingResponseVo createResponse(String clientAppId, String correlationId, String pcn, HttpStatus httpStatus) {
		SpreadingResponseVo response = new SpreadingResponseVo();
		response.setProcess_control_number(pcn);
		response.setClient_app_id(clientAppId);
		response.setResponse_id(correlationId);
		response.setResponse_timestamp(new SimpleDateFormat("dd-MM-yy hh:mm:ss").format(new Date()));
		response.setResponse_code(String.valueOf(httpStatus.value()));
		return response;
	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "/upload-bank-statements", produces = "application/json")
//	public ResponseEntity<String> mapCustomerExcelDatatoDB(@RequestParam("file") MultipartFile[] bankStmts) throws IOException {
//		logger.info("File upload API 'upload-bank-statements' started for file:: "+bankStmts.length);
//	    String retVal = "successfully uploaded # of file(s): "+bankStmts.length;
//	    ResponseEntity<String> responseEntity = null;
//	    try {
////	    	bsiFileUploadService.saveCustomerSpreadingDataToDB(reapExcelDataFile);
//	    	responseEntity = new ResponseEntity<String>(retVal, HttpStatus.OK);
//	    	logger.info("File upload API 'upload-bank-statements' completed for # of file(s):: "+bankStmts.length);
//		} catch (Exception e) {
//			logger.error("Error in file upload process", e);
//			responseEntity = new ResponseEntity<String>("Exception in uploading file", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	    return responseEntity;
//	}
	
}
