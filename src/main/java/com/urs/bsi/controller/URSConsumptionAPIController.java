package com.urs.bsi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

<<<<<<< HEAD
=======
import com.urs.bsi.model.ErrorModel;
import com.urs.bsi.model.vo.CLToURSResponseVo;
import com.urs.bsi.model.vo.DocumentRejectionResponseVo;
import com.urs.bsi.model.vo.FGToURSResponseVo;
>>>>>>> 3f2994a687f11572d7d856ddd9b158f16e813ec5
import com.urs.bsi.service.URSConsumptionAPIService;
import com.urs.bsi.vo.ApiResponse;

import io.swagger.annotations.ApiOperation;

@Controller
public class URSConsumptionAPIController {
	
	@Autowired
	URSConsumptionAPIService ursConsumptionAPIService;
	
	@ApiOperation(value="",notes="")
	@RequestMapping(method=RequestMethod.POST,value="/submit-spreading-details",produces="application/json")
	public ResponseEntity<ApiResponse>  consumeFGPostAPI(@RequestParam(value="caseId",required=true) String caseId) throws IOException {

		ApiResponse response=ursConsumptionAPIService.postJSONToCJ(caseId);
	    	if(null==response || response.getCode()!=200){
	    		return new ResponseEntity<ApiResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	    	}else
	    		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}

	
	@ApiOperation(value="",notes="")
	@RequestMapping(method=RequestMethod.POST,value="/post-document-rejection",produces="application/json")
	public ResponseEntity<DocumentRejectionResponseVo>  postRejection(@RequestParam(value="se10",required=true) String se10) throws IOException {

		DocumentRejectionResponseVo drResponseModel=ursConsumptionAPIService.postDocumentRejection(se10);
	    	if(null==drResponseModel){
	    		ErrorModel err=new ErrorModel(500,"Error in clResponseModel");
	    		return new ResponseEntity(err,HttpStatus.INTERNAL_SERVER_ERROR);
	    	}else
	    		return new ResponseEntity<DocumentRejectionResponseVo>(drResponseModel,HttpStatus.OK);
	}
}
