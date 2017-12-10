package com.serhat.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serhat.controller.mapper.ConfigurationMapper;
import com.serhat.dto.ConfigurationDTO;
import com.serhat.exception.EntityNotFoundException;
import com.serhat.persistence.entity.Configuration;
import com.serhat.service.ConfigurationService;

@RestController
public class ConfigurationController {

    @Autowired
    private ConfigurationService service;

    @GetMapping("all")
    public List<ConfigurationDTO> getAll() {
        return ConfigurationMapper.mapConfigurationDTOList(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ConfigurationDTO getConfiguration(@Valid @PathVariable long id) throws EntityNotFoundException
    {
        return ConfigurationMapper.mapConfigurationDTO(service.find(id));
    }
    
    @GetMapping("/name/{name}")
    public ConfigurationDTO getConfigurationByName(@Valid @PathVariable String name) throws EntityNotFoundException
    {
        return ConfigurationMapper.mapConfigurationDTO(service.findByName(name));
    }
    
    @GetMapping("/value")
    public String getConfigurationValue(@Valid @RequestParam(required=true) String applicationName, @RequestParam(required=true) String name) throws EntityNotFoundException
    {
   		 return service.findByApplicationName(applicationName, name);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConfigurationDTO createConfiguration(@Valid @RequestBody ConfigurationDTO configurationDTO)
    {
    	Configuration conf = ConfigurationMapper.mapConfiguration(configurationDTO);
        return ConfigurationMapper.mapConfigurationDTO(service.create(conf));
    }
    
    @PutMapping("/{id}")
    public ConfigurationDTO updateConfiguration(@PathVariable long id, @Valid @RequestBody ConfigurationDTO configurationDTO )
        throws EntityNotFoundException
    {
        return ConfigurationMapper.mapConfigurationDTO(service.update(id, configurationDTO));
    }
}
