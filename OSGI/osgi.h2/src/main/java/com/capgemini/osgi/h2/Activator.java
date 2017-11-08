package com.capgemini.osgi.h2;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class Activator implements BundleActivator, ServiceListener{

	public void serviceChanged(ServiceEvent event) {
		String[] listKeys = (String[]) event.getServiceReference().getPropertyKeys();
		
		for(String key: listKeys){
			System.out.println(key+" : "+event.getServiceReference().getProperty(key));
		}
		
		String[] objectClass = (String[])
	            event.getServiceReference().getProperty("objectClass");
		System.out.print(objectClass[0] );
		switch (event.getType()){
			case ServiceEvent.REGISTERED:
				System.out.println(" is registred.");
				break;
			case ServiceEvent.UNREGISTERING:
				System.out.println(" is unregistred.");
				break;
			case ServiceEvent.MODIFIED:
				System.out.println(" is modified.");
				break;
		}
	
	}

	public void start(BundleContext context) throws Exception {
		System.out.println("Service Started");
		context.addServiceListener(this);
	}

	public void stop(BundleContext context) throws Exception {
		context.removeServiceListener(this);
		System.out.println("Service Stopped");
	}

	
}
