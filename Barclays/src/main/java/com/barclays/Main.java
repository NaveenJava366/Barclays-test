package com.barclays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.barclays.entity.Trade;
import com.barclays.exception.StoreException;

public class Main {

	public static void main( final String[] args ) throws ParseException {
		final Scanner s = new Scanner( System.in);
		System.out.println("================Welcome to new Trading system ==========================");
		System.out.println("Enter new Trade Id");
		 final String tradeId =  s.next();
		System.out.println("Enter version of the trade");
		 final int version = s.nextInt();
		System.out.println("Enter counter party Id ");
		 final String counter_party = s.next();
		System.out.println("Enter booking Id ");
		final String book_Id  = s.next();
		System.out.println("Enter maturity date in 'yyyy-mm-dd' format only ");
		final String maturity_date = s.next();
		System.out.println("Enter creation date in 'yyyy-mm-dd' format only ");
		 final String createdDate= s.next();
		final Date sdf = new SimpleDateFormat( "yyyy-mm-dd" ).parse( createdDate );
		System.out.println("Enter expirey status");
		 final String expiryStatus  = s.next();
		 final char expriry = expiryStatus.charAt( 0 );
		final StoreValidation sv = new StoreValidation();
	Trade trade1 = null;
	Trade trade2 = null;
	try {
		trade1 = Trade.createAndValidateTrade( tradeId, version,counter_party , book_Id , maturity_date , sdf , expriry , sv  );
		trade2 = Trade.createAndValidateTrade( "T1", 2, "CP-1", "B1",  new String("2022-04-07"), new Date(), 'N', sv );
		System.out.println(trade1 );
		System.out.println(trade2);
	}catch ( final StoreException e ){
		System.err.println(e);
	}

	}
	}

