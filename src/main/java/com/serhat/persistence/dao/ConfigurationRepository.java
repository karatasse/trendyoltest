package com.serhat.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.serhat.persistence.entity.Configuration;

public interface ConfigurationRepository extends CrudRepository<Configuration, Long>
{
	List<Configuration> findByName(String name);
}
