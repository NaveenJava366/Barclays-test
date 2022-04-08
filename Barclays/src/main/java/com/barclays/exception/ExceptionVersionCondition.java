package com.barclays.exception;

public class ExceptionVersionCondition {
	public void versionHandling( final int version){
		if(version<2){
			throw new StoreException("Trade rejected.Version should always be greater than 1");
		}
	}
}
