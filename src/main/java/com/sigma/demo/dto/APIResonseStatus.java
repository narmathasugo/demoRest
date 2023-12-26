package com.sigma.demo.dto;

public enum APIResonseStatus {


	success("success"),
	fail("fail");
	
	private final String status;
	
	APIResonseStatus(String status){
		this.status = status;
	}
	
	@Override
    public String toString() {
        return status;
    }


}
