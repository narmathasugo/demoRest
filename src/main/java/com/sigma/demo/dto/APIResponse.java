package com.sigma.demo.dto;

import java.util.Date;

import flexjson.JSON;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;

public class APIResponse {


	  private String status;

	  private Object data;

	  private String message;

	  public APIResponse(String status, Object data, String message) {
	    this.status = status;
	    this.data = data;
	    this.message = message;
	  }

	  // constructor can be used for success and failure scenario
	  public APIResponse(String status, Object data) {
	    this(status, data, null);
	  }

	  // constructor can be used for error scenario
	  public APIResponse(String status, String message) {
	    this(status, null, message);
	  }

	  public String getStatus() {
	    return status;
	  }

	  public void setStatus(String status) {
	    this.status = status;
	  }

	  @JSON(include = true)
	  public Object getData() {
	    return data;
	  }

	  public void setData(Object data) {
	    this.data = data;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

	  private static final DateTransformer DATE_TRANSFORMER =
	      new DateTransformer("yyyy-MM-dd'T'HH:mm:ss");

	  public String toJson() {
	    return new JSONSerializer()
	        .transform(DATE_TRANSFORMER, Date.class)
	        .exclude("*.class")
	        .serialize(this);
	  }


}
