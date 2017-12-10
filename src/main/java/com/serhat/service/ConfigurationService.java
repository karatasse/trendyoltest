package com.serhat.service;

import java.util.List;

import com.serhat.persistence.entity.Configuration;

public interface ConfigurationService
{
    public List<Configuration> findAll();

}
