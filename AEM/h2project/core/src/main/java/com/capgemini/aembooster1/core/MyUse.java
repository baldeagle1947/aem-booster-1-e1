package com.capgemini.aembooster1.core;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.adobe.cq.sightly.WCMUsePojo;

public class MyUse extends WCMUsePojo {

    
    @Override
	public void activate() throws Exception {
		
	}

	
    public List<ValueMap> getChildren(){
    	List<ValueMap> ret = new ArrayList<>();
        Iterator<Resource> list = getResource().listChildren();
    	while(list.hasNext()){
    		ret.add(list.next().adaptTo(ValueMap.class));
    	}
    	return ret ;
    }

	
}