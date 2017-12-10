package com.serhat.service;

import java.util.List;

import com.serhat.dto.ConfigurationDTO;
import com.serhat.exception.EntityNotFoundException;
import com.serhat.persistence.entity.Configuration;

public interface ConfigurationService
{
    public List<Configuration> findAll();

	public Configuration find(long id) throws EntityNotFoundException;

	public Configuration create(Configuration conf);

	public Configuration findByName(String name);

	public String findByApplicationName(String applicationName, String name);

	public Configuration update(long id, ConfigurationDTO configurationDTO) throws EntityNotFoundException;

}
