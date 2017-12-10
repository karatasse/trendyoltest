package com.serhat.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurationDTO {
	private Long id;
    private String name;
    private String type;
    private String value;
    private Boolean isActive;
    private String applicationName;
    
    private ConfigurationDTO(){}
    
	public ConfigurationDTO(Long id, String name, String type, String value,
			Boolean isActive, String applicationName) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.value = value;
		this.isActive = isActive;
		this.applicationName = applicationName;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
}
