/*
 * Copyright (C) 2016 msg systems ag
 *
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
 *
 *
 * @author Michael Schaefer
 */

package de.msg;

import de.msg.service.CloudEnvironmentService;
import de.msg.service.DevelopmentEnvironmentService;
import de.msg.service.EnvironmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class ApplicationConfiguration {

	@Bean
	@Profile("development")
	public EnvironmentService getDefaultEnvironmentService() {
		
		return new DevelopmentEnvironmentService();
		
	}
	
	@Bean
	@Profile("cloud")
	public EnvironmentService getCloudEnvironmentService() {
		
		return new CloudEnvironmentService();
		
	}

}
