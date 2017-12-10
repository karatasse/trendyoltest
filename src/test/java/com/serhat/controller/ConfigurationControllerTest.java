package com.serhat.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serhat.Application;
import com.serhat.dto.ConfigurationDTO;
import com.serhat.exception.EntityNotFoundException;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ConfigurationControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper jacksonObjectMapper;
    
    @Test
    public void test_getConfiguration() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
            "http://localhost:8080/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        ConfigurationDTO returnValue = jacksonObjectMapper.readValue(result.getResponse().getContentAsString(), ConfigurationDTO.class);

        Assert.assertEquals("SERVICE-A", returnValue.getApplicationName());
    }
    
    @Test
    public void test_getConfiguration_non_existing() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
            "http://localhost:8080/11").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isBadRequest()).andReturn();
        Assert.assertEquals(EntityNotFoundException.class, result.getResolvedException().getClass());
    }
    
    @Test
    public void test_getConfigurationByName() throws Exception
    {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
            "http://localhost:8080/name/SiteName").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        List<ConfigurationDTO> returnValue = jacksonObjectMapper.readValue(result.getResponse().getContentAsString(), List.class);

        Assert.assertEquals(1, returnValue.size());
    }
    
    @Test
    public void test_createConfiguration() throws Exception
    {
        ConfigurationDTO conf = createTestConfiguration();

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
            "http://localhost:8080").contentType(MediaType.APPLICATION_JSON)
            .content(jacksonObjectMapper.writeValueAsString(conf))
            .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isCreated()).andReturn();
        ConfigurationDTO returnValue = jacksonObjectMapper.readValue(result.getResponse().getContentAsString(), ConfigurationDTO.class);

        Assert.assertEquals("trendyol-test.com", returnValue.getValue());
        Assert.assertEquals("SERVICE-A", returnValue.getApplicationName());
        Assert.assertEquals(4, returnValue.getId().intValue());
    }

	private ConfigurationDTO createTestConfiguration() {
		return new ConfigurationDTO(null, "SiteName", "String", "trendyol-test.com", false, "SERVICE-A");
	}
    
    @Test
    public void test_updateConfiguration() throws Exception
    {
    	ConfigurationDTO conf = createTestConfiguration();
    	conf.setApplicationName("SERVICE-A-test");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
            "http://localhost:8080/3")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jacksonObjectMapper.writeValueAsString(conf))
            .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        ConfigurationDTO returnValue = jacksonObjectMapper.readValue(result.getResponse().getContentAsString(), ConfigurationDTO.class);

        Assert.assertEquals("SERVICE-A-test", returnValue.getApplicationName());
    	
    }

}
