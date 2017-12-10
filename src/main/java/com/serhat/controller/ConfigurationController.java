package com.serhat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serhat.controller.mapper.ConfigurationMapper;
import com.serhat.dto.ConfigurationDTO;
import com.serhat.service.ConfigurationService;

@RestController
public class ConfigurationController {

    @Autowired
    private ConfigurationService service;

    @GetMapping("all")
    public List<ConfigurationDTO> getAll() {
        return ConfigurationMapper.mapConfigurationDTOList(service.findAll());
    }
}
