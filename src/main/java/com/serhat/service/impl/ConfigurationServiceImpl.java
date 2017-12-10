package com.serhat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.serhat.persistence.dao.ConfigurationRepository;
import com.serhat.persistence.entity.Configuration;
import com.serhat.service.ConfigurationService;

@Service
public class ConfigurationServiceImpl implements ConfigurationService
{

    private final ConfigurationRepository configRepository;


    public ConfigurationServiceImpl(final ConfigurationRepository configRepository)
    {
        this.configRepository = configRepository;
    }


    @Override
    public List<Configuration> findAll()
    {
        Iterable<Configuration> configurations = configRepository.findAll();
		return Lists.newArrayList(configurations);
    }

}
