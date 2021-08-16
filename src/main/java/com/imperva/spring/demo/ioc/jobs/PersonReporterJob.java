package com.imperva.spring.demo.ioc.jobs;

import com.imperva.spring.demo.ioc.jpa.model.Person;
import com.imperva.spring.demo.ioc.jpa.repositories.PersonRepository;
import com.imperva.spring.demo.ioc.services.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

public class PersonReporterJob {

    private static final Logger logger = LoggerFactory.getLogger( PersonReporterJob.class );

    @Autowired
    IPersonService personService;

    @Scheduled(fixedDelay = 1000)
    public void reportPersons(){
        logger.info("we have {} persons in the system", personService.getPersonsCount());
    }
}
