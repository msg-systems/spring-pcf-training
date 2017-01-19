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
 * @author Rafael Kansy
 * @author Michael Schaefer
 */

package de.msg;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.msg.domain.route.Route;
import de.msg.repository.RouteRepository;

@RestController
@SpringBootApplication
public class Application {
	
	@Autowired
	private RouteRepository routeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/helloWorld")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("Hello World");
    }
    
        
    @RequestMapping("/routes")
    public ResponseEntity<Iterable<Route>> get() {
    	
    	 return new ResponseEntity<Iterable<Route>>(routeRepository.findAll(), HttpStatus.OK);
    } 
}
