package com.barclays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import com.barclays.entity.Trade;
import com.barclays.exception.StoreException;

public class StoreValidation {
	SimpleDateFormat sdf ;
	DateTimeFormatter dtf;
	LocalDateTime now;
	String today;
	public StoreValidation(){
		 sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		 dtf =  DateTimeFormatter.ofPattern("yyyy-MM-dd" );
		 now = LocalDateTime.now();
		today = dtf.format( now );
	}
	private int dateCompariosnWithCurrentDate( final String d) throws ParseException {
		final Date todayNow  = sdf.parse( today );
		final Date d1  = sdf.parse( d );
		 return d1.compareTo( todayNow );
	}

	public void maturityDateValidation( final String date ) throws ParseException {
		final int result = dateCompariosnWithCurrentDate( date);
		if (result == -1  ) {
			throw new StoreException( "this maturity date is not accepted because its less than today" );
		}
	}

	public void versionHandling( final int version ) {
		if ( version < 2 ) {
			throw new StoreException( "Trade rejected. Version should always be greater than 1" );
		}
	}

	public void updateFlag( final Trade trade ) throws ParseException {
		final int result = dateCompariosnWithCurrentDate( trade.getMaturity_date());
		if ( result == 1  ) {
			trade.setExpiryStatus( 'Y' );
			System.out.println("Maturity date reached. So flag has been updated");
		}
	}


}


