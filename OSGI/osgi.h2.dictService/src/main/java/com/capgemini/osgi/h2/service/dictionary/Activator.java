package com.capgemini.osgi.h2.service.dictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {

		Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("Language", "English");
        context.registerService(DictionaryService.class, new DictionaryImpl(), props);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Bundle" + context.getBundle().getSymbolicName() + "Stopped");
	}

	private static class DictionaryImpl implements DictionaryService {
		static Set<String> dict = new HashSet<String>();
		
		static {
			String[] array_dict =
	            { "foo", "bar", "DCX", "capgemini", "AEM"  , "booster"};
			dict.addAll(Arrays.asList(array_dict));
		}
		
		public boolean checkWord(String word) {
			return dict.contains(word);
		}
		
	}
}
