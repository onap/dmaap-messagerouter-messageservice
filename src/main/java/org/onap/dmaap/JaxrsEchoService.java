/*******************************************************************************
 *  ============LICENSE_START=======================================================
 *  org.onap.dmaap
 *  ================================================================================
 *  Copyright © 2017 AT&T Intellectual Property. All rights reserved.
 *  ================================================================================
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
*  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  ============LICENSE_END=========================================================
 *  
 *  ECOMP is a trademark and service mark of AT&T Intellectual Property.
 *  
 *******************************************************************************/
 package org.onap.dmaap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.att.eelf.configuration.EELFLogger;
import com.att.eelf.configuration.EELFManager;


import com.att.ajsc.beans.PropertiesMapBean;
import org.onap.dmaap.filemonitor.ServicePropertiesMap;

/**
 * Example JAX-RS Service
 * @author rajashree.khare
 *
 */
@Path("/jaxrs-services")
public class JaxrsEchoService {
  
	/**
	 * Logger obj
	 */
	/*private static final Logger LOGGER = Logger
			.getLogger(JaxrsEchoService.class);*/
	
	private static final EELFLogger LOGGER = EELFManager.getInstance().getLogger(JaxrsEchoService.class);
	
	/**
    * Method ping 
    * @param input input
    * @return str
    */
	@GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input) {
        return "Hello, " + input + ".";
    }
    
   /**
    * Method to fetch property
    * @param fileName file
    * @param input input
    * @return prop
    */
    @GET
    @Path("/property/{fileName}/{input:.*}")
    @Produces("text/plain")
    public String getProperty(@PathParam("fileName") String fileName, @PathParam("input") String input) {
    	String val=null;
    	try {
    		val = ServicePropertiesMap.getProperty(fileName, input);
    		if(val == null || val.isEmpty() || val.length() < 1){
    			val = PropertiesMapBean.getProperty(fileName, input);
    		}
    	}
    	catch(Exception ex) {
    		LOGGER.info("*** Error retrieving property "+input+": "+ex);
    		
    	} 	 
    	if (val ==null) {
   		 	return "Property is not available";
    	}
    	return "Property value is, " + val +".";
    }  
    
}