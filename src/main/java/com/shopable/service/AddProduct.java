package com.shopable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopable.DAO.ProductDao;

@Component
public class AddProduct {
	
	@Autowired
	ProductDao pd;
	public String add(String id,String uname,int quantity) {
		int stock = pd.getstock(id);
		int diff=stock-quantity;
		if(diff>=0) {
			pd.addtocart(id,uname,quantity);
			return "";
		}
		else {
			return "uh-oh We have less stock ";
		}
		
	}
	public int computetotal(String uname) {
		
		int total = pd.total(uname);
		return total;
	}

}
