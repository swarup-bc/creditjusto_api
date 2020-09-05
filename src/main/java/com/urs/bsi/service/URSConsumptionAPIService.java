package com.urs.bsi.service;

import java.io.UnsupportedEncodingException;

import com.fasterxml.jackson.core.JsonProcessingException;
<<<<<<< HEAD
import com.urs.bsi.vo.ApiResponse;
=======
import com.urs.bsi.model.vo.CLToURSResponseVo;
import com.urs.bsi.model.vo.DocumentRejectionResponseVo;
import com.urs.bsi.model.vo.FGToURSResponseVo;
>>>>>>> 3f2994a687f11572d7d856ddd9b158f16e813ec5

public interface URSConsumptionAPIService {


	public ApiResponse postJSONToCJ(String caseId) throws JsonProcessingException, UnsupportedEncodingException;
	
	public DocumentRejectionResponseVo postDocumentRejection(String se10);
	
}
