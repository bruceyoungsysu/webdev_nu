package com.example.webseverjavatyang.services;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HttpSessionExamples {
    @GetMapping("api/session/set/{attr}/{value}")
    public String setSessionAttribute(@PathVariable("attr") String attr,
    		@PathVariable("value") String value,
    		HttpSession session)
    		{
    	session.setAttribute(attr, value);
    	return attr + "=" + value;
    }
    
    @GetMapping("api/session/get/{attr}")
    public String getSessionAttribute(@PathVariable("attr") String attr,
    		HttpSession session)
    		{
    	return (String) session.getAttribute(attr);
    }
}
