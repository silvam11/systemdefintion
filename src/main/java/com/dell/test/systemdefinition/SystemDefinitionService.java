package com.dell.test.systemdefinition;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.views.Key;
import com.cloudant.client.api.views.ViewRequest;
import com.dell.cpsd.systemdefinition.model.SystemDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemDefinitionService {
	@Autowired
	Database mydb;

	@RequestMapping("/")
	public String index() {
		return "This a test for System Definition!";
	}

	@RequestMapping(path = "/systemdefinition", method = RequestMethod.POST,  consumes = "application/json")
	public String saveSystemDefinitio(@RequestBody SystemDefinition systemDefinitionBody,
            HttpServletRequest servletRequest) {

		mydb.save(systemDefinitionBody);

		return "saved";
	}
	
	@RequestMapping(path = "/allsystemdefinitions", produces = "application/json")
	public List<SystemDefinition> getAllSystemDefinitions() {
		List<SystemDefinition> result = null;
		
		try {
			result = mydb.getAllDocsRequestBuilder().includeDocs(true).build()
				.getResponse().getDocsAs(SystemDefinition.class);
			
			if(result == null)
			{
				result = new ArrayList<SystemDefinition>();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping(path = "/systemdefinitionbyid/{csID}", method = RequestMethod.GET, produces = "application/json")
	public SystemDefinition getSystemDefinitionByID(final @PathVariable String csID, final HttpServletRequest servletRequest) {
		SystemDefinition result = null;
		
		result = mydb.find(SystemDefinition.class, csID);
		
		if(result == null)
		{
			result = null;
		}
		
		return result;
	}
	
	@RequestMapping(path = "/systemdefinitionbyidentity/{identityID}", method = RequestMethod.GET,  produces = "application/json")
	public List<SystemDefinition> getSystemDefinitionByIdentity(final @PathVariable String identityID, final HttpServletRequest servletRequest) {
		List<SystemDefinition> result = new ArrayList<SystemDefinition>();
		String designDocment = "systemdefinition";
		String viewName = "byIdentity";
		
		ViewRequest<String, SystemDefinition> viewRequest = mydb.getViewRequestBuilder(designDocment, viewName)
			.newRequest(Key.Type.STRING, SystemDefinition.class)
			.includeDocs(true)
			.keys(identityID)
			.build();

		try {
			List<SystemDefinition> systemDefinitions = viewRequest.getResponse()
					.getDocsAs(SystemDefinition.class);
			
			if(systemDefinitions != null && systemDefinitions.size() > 0)
			{
				result = systemDefinitions;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
//	@RequestMapping(path = "/convergedsystembyidentity/{identityID}", method = RequestMethod.GET)
//	public String getConvergedSystemByIdentity(final @PathVariable String identityID, final HttpServletRequest servletRequest) {
//		String result = "";
//		String designDocment = "systemdefinition";
//		String viewName = "byIdentity";
//		
//		ViewRequest<String, SystemDefinition> viewRequest = mydb.getViewRequestBuilder(designDocment, viewName)
//			.newRequest(Key.Type.STRING, SystemDefinition.class)
//			.includeDocs(true)
//			.build();
//
//		try {
//			List<SystemDefinition> systemDefinitions = viewRequest.getResponse()
//					.getDocsAs(SystemDefinition.class);
//			
//			if(systemDefinitions != null && systemDefinitions.size() > 0)
//			{
//				result = systemDefinitions.toString();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
//	@RequestMapping(path = "/convergedsystembyid/{csID}", method = RequestMethod.GET)
//	public String getConvergedSystemByID(final @PathVariable String csID, final HttpServletRequest servletRequest) {
//		StringBuffer strBuf = new StringBuffer();
//		String line;
//		
//		InputStream inputStream = mydb.find(csID);
//		BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
//		
//		try {
//			while((line = bufReader.readLine()) != null) {
//				strBuf.append(line);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return strBuf.toString();
//	}
}