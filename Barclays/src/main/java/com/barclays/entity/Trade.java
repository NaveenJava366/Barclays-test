package com.barclays.entity;

import java.text.ParseException;
import java.util.Date;
import com.barclays.StoreValidation;

public class Trade {
	private String tradeId;
	private int version;
	private String Counter_party;
	private String Book_Id;
	private String maturity_date;
	private Date createdDate;
	private char expiryStatus;
	private  Trade( final String p_tradeId, final int p_version, final String p_counter_party, final String p_book_Id, final String p_maturity_date, final Date p_createdDate,
				  final char p_expiryStatus ) {
		tradeId = p_tradeId;
		version = p_version;
		Counter_party = p_counter_party;
		Book_Id = p_book_Id;
		maturity_date = p_maturity_date;
		createdDate = p_createdDate;
		expiryStatus = p_expiryStatus;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId( final String p_tradeId ) {
		tradeId = p_tradeId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion( final int p_version ) {
		version = p_version;
	}

	public String getCounter_party() {
		return Counter_party;
	}

	public void setCounter_party( final String p_counter_party ) {
		Counter_party = p_counter_party;
	}

	public String getBook_Id() {
		return Book_Id;
	}

	public void setBook_Id( final String p_book_Id ) {
		Book_Id = p_book_Id;
	}

	public String getMaturity_date() {
		return maturity_date;
	}

	public void setMaturity_date( final String p_maturity_date ) {
		maturity_date = p_maturity_date;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate( final Date p_createdDate ) {
		createdDate = p_createdDate;
	}

	public char getExpiryStatus() {
		return expiryStatus;
	}

	public void setExpiryStatus( final char p_expiryStatus ) {
		expiryStatus = p_expiryStatus;
	}

	@Override
	public String toString() {
		return "Trade{" + "tradeId='" + tradeId + '\'' + ", version=" + version + ", Counter_party='" + Counter_party + '\'' + ", Book_Id='" +
			   Book_Id + '\'' + ", maturity_date=" + maturity_date + ", createdDate=" + createdDate + ", expiryStatus=" + expiryStatus + '}';
	}
	public static Trade createAndValidateTrade( final String p_tradeId, final int p_version, final String p_counter_party, final String p_book_Id, final String p_maturity_date, final Date p_createdDate,
										 final char p_expiryStatus, final StoreValidation sv) throws ParseException {
		sv.versionHandling( p_version );
		sv.maturityDateValidation( p_maturity_date );
		final Trade trade = new Trade( p_tradeId, p_version, p_counter_party, p_book_Id, p_maturity_date, p_createdDate,
									   p_expiryStatus);
		sv.updateFlag( trade );
		return  trade;
	}
}
