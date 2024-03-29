/*-
 * ============LICENSE_START=======================================================
 * ONAP Policy Engine
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */
 package org.onap.dmaap.service;

import org.onap.dmaap.dmf.mr.beans.DMaaPContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.onap.dmaap.dmf.mr.utils.ConfigurationReader;

public class ServiceUtil {
	private static DMaaPContext dmaaPContext;
	
	
	public static DMaaPContext getDMaaPContext(ConfigurationReader configReader,HttpServletRequest request,HttpServletResponse response) {
		dmaaPContext = new DMaaPContext();
		dmaaPContext.setConfigReader(configReader);
		dmaaPContext.setRequest(request);
		dmaaPContext.setResponse(response);
		return dmaaPContext;
	}

}
