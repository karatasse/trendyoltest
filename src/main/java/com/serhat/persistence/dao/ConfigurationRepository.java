package com.serhat.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.serhat.persistence.entity.Configuration;

public interface ConfigurationRepository extends CrudRepository<Configuration, Long>
{
	Configuration findByName(String name);
	List<Configuration> findByApplicationName(String applicationName);
}
