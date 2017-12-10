package com.serhat.dto;


public class ConfigurationDTO {
	private Long id;
    private String name;
    private String type;
    private String value;
    private Boolean isActive;
    private String applicationName;
    
	public ConfigurationDTO(Long id, String name, String type, String value,
			Boolean isActive, String applicationName) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.value = value;
		this.isActive = isActive;
		this.applicationName = applicationName;
	}

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
