package com.dell.systemdefinition.model.DONOTUSE;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private String name;
	private String type;
	private List<String> parentSystemIdentifiers = new ArrayList<String>();
	
	public Group(String name, String type) {
		this.name = name;
		this.type = type;
		
		this.parentSystemIdentifiers.add("VXRACKFLEX");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getParentSystemIdentifiers() {
		return parentSystemIdentifiers;
	}

	public void setParentSystemIdentifiers(List<String> parentSystemIdentifiers) {
		this.parentSystemIdentifiers = parentSystemIdentifiers;
	}
	
}
