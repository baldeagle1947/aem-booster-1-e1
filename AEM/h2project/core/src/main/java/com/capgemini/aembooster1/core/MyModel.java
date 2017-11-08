package com.capgemini.aembooster1.core;


import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class) 
public class MyModel { 


  @Inject
  private String titre; 

  @PostConstruct 
  public void activate() { 

  } 

  public String getTitle() { 
    return "Mon très beau " + titre; 
  }


	public void setTitre(String titre) {
		this.titre = titre;
	} 

	
}


