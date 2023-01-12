package com.duboomom.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duboomom.spring.test.database.bo.StoreBO;
import com.duboomom.spring.test.database.model.Store;

@Controller
public class StoreController {

	@Autowired
	private StoreBO storeBO;
	
	@ResponseBody
	@RequestMapping("/database/test01")
	public List<Store> test01() {
		
		List<Store> storeList = storeBO.getStoreList();
		return storeList;
		
	}
	
}
