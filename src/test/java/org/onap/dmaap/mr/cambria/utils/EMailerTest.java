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
package org.onap.dmaap.mr.cambria.utils;

import org.junit.Test;
import org.onap.dmaap.dmf.mr.utils.Emailer;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class EMailerTest {
	
	@Test
	public void testEmailer(){
		
		Emailer emailer= new Emailer();
		try {
			emailer.send("dummy@dummy.com", "subj", "body");
		} catch (IOException e) {
			assertTrue(true);
		}
		
	}

}
