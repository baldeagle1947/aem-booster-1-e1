
package com.capgemini.osgi.h2.service.dictionarybis.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.capgemini.osgi.h2.service.dictionary.DictionaryService;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		
		Collection<ServiceReference<DictionaryService>> refs = context.getServiceReferences(DictionaryService.class, null);
		
		
		if(refs == null || refs.isEmpty()) {
			System.out.println("no Dictionary Service");
			return;
		}
		ServiceReference<DictionaryService> ref = refs.iterator().next();
		
		System.out.println("Enter a blank line to exit.");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String word = "";
        
        while (true) {
        	System.out.print("Enter word: ");
            word = in.readLine();
            
         
            if (word.length() == 0)
            {
                break;
            }
            
            DictionaryService dictionary = context.getService(ref);
                if (dictionary.checkWord(word))
                {
                    System.out.println("Correct.");
                }
                else
                {
                    System.out.println("Incorrect.");
                }

                // Unget the dictionary service.
                context.ungetService(ref);
        }
	}

	

	public void stop(BundleContext context) throws Exception {
	}

}
