package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		ArrayList<RateDomainModel> Rates = RateDAL.getAllRates(); 
		
		int top = 0;
		RateDomainModel topRate = new RateDomainModel(); 
		
		for(RateDomainModel R: Rates){
			int rateTemp = R.getiMinCreditScore();
			if(rateTemp <= GivenCreditScore){
				top = rateTemp;
				topRate = R;
			}
		}
		
		if(top == 0){
			throw new RateException(topRate);
		}else{
			dInterestRate = top;
		}
		
		return dInterestRate;
		
		
	}
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
