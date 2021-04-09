package com.shopable.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopable.DAO.ProductDao;

@Component
public class Wallet {
	@Autowired
	ProductDao pd;
	public int getwallet(String uname) {
		return pd.walletmoney(uname);
		
	}
	
	public int computemoney(String uname) {
		return pd.moneycalc(uname);
	}

}
