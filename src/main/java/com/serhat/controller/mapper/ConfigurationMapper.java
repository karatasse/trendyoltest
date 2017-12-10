package com.serhat.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.serhat.dto.ConfigurationDTO;
import com.serhat.persistence.entity.Configuration;

public class ConfigurationMapper {
	
	public static ConfigurationDTO mapConfigurationDTO(Configuration configuration){
		return new ConfigurationDTO(configuration.getId(), 
				configuration.getName(), configuration.getType(), configuration.getValue(), configuration.getIsActive(), 
				configuration.getApplicationName());
    }
	
	public static List<ConfigurationDTO> mapConfigurationDTOList(Collection<Configuration> configurations){
        return configurations.stream()
            .map(ConfigurationMapper::mapConfigurationDTO)
            .collect(Collectors.toList());
    }

}
