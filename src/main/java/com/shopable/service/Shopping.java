package com.shopable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopable.DAO.ProductDao;

import com.shopable.model.UserProduct;

@Component
public class Shopping {

	@Autowired
	ProductDao pd;
	public List<UserProduct> usercart(String name){
		
		 return pd.getusercart(name);
		
	
		
		
	}
	
	public void deletecart(String uname) {
		pd.deletetable(uname);
		return;
	}
	public void deleteitem(String uname,String pid) {
		pd.deletefromcart(uname,pid);
	}
	
	
}
