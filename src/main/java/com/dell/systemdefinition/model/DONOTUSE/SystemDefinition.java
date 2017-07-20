package com.dell.systemdefinition.model.DONOTUSE;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

public class SystemDefinition {
	private String identity = "IDENTITY TEST";
	private String definition = "DEFINITION TEST";
	private String systemDefinitionStrStr;
	private List<Group> groups = new ArrayList<Group>();
	
	public SystemDefinition(String systemDefinitionStrStr) {
		this.systemDefinitionStrStr = systemDefinitionStrStr;
		
		this.groups.add(new Group("SystemMgmtNetwork", "NETWORK"));
		this.groups.add(new Group("SystemNetwork", "NETWORK"));
	}

//	@Override
//	public String toString() {
//		StringBuffer strBuf = new StringBuffer();
//		strBuf.append("{ identity: " + identity);
//		strBuf.append(", definition: " + definition);
//		strBuf.append(", convergedSystem: " + convergedSystem);
//		strBuf.append(", numberOfGroups: " + groups.size());
//		strBuf.append("}");
//	
//		return strBuf.toString();
//	}
	
	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
}
