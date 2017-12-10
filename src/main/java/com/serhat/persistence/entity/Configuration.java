package com.serhat.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "uc_configuration", columnNames = {"id"}))
public class Configuration
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "conf_type")
    private String type;
    
    @Column(name = "conf_value")
    private String value;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "application_name")
    private String applicationName;


    private Configuration()
    {}


    public Configuration(String name, String type, String value, Boolean isActive, String applicationName)
    {
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
