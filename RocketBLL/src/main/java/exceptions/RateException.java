package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	private RateDomainModel rate; 
	
	public RateDomainModel getRate() {
		return rate;
	}

	public RateException(RateDomainModel rate){
		this.rate = rate;
	}
}
