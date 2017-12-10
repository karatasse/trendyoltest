package com.serhat.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.serhat.persistence.entity.Configuration;

public interface ConfigurationRepository extends CrudRepository<Configuration, Long>
{}
