package com.shopable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopable.DAO.ProductDao;
import com.shopable.model.*;


@Component
public class DisplayProducts {
	
	@Autowired
	ProductDao pd;
	public List<ProductInformation> showall(){
	
	return pd.fetchall();
		
	}
	
	
	
		
	
	
}
