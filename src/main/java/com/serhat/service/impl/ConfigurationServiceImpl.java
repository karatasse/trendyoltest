package com.serhat.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.serhat.dto.ConfigurationDTO;
import com.serhat.exception.EntityNotFoundException;
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
    @Cacheable("configurations")
    public List<Configuration> findAll()
    {
        Iterable<Configuration> configurations = configRepository.findAll();
		return Lists.newArrayList(configurations);
    }


	@Override
	@Cacheable("configurations")
	public Configuration find(long id) throws EntityNotFoundException 
	{
		Configuration conf = configRepository.findOne(id);
        if (conf == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + id);
        }
        return conf;
	}


	@Override
	public Configuration create(Configuration conf) 
	{
		return configRepository.save(conf);
	}


	@Override
	@Cacheable("configurations")
	public Configuration findByName(String name) 
	{
		return configRepository.findByName(name);
	}


	@Override
	public Configuration update(long id, ConfigurationDTO configurationDTO)	throws EntityNotFoundException 
	{
		Configuration conf = find(id);
        conf.setName(configurationDTO.getName());
		conf.setType(configurationDTO.getType());
		conf.setValue(configurationDTO.getValue());
		conf.setIsActive(configurationDTO.getIsActive());
		conf.setApplicationName(configurationDTO.getApplicationName());
       
		conf = configRepository.save(conf);
        return conf;
	}


	@Override
	@Cacheable("configurations")
	public String findByApplicationName(String applicationName, String name) {
		List<Configuration> confs = configRepository.findByApplicationName(applicationName);
		return confs.stream()
					.filter(x -> x.getName().equals(name))
					.findFirst()
					.get()
					.getValue();
	}
	

}
