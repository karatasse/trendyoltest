package com.serhat.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationScheduler {
	private static Logger LOG = LoggerFactory.getLogger(ConfigurationScheduler.class);

    @Scheduled(fixedRate = 10000)//every 10 seconds
    @CacheEvict(value="configurations", allEntries=true)
    public void clearCache() {
    	LOG.info(">>>>>>>> Cache is cleared", new Date());
    }

}
