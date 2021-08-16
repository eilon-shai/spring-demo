package com.imperva.spring.demo.ioc.events;

import com.imperva.spring.demo.ioc.services.IPersonService;
import com.imperva.spring.demo.ioc.services.PersonServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class PersonReadyListener {

    @Autowired
    IPersonService personService;

    @Autowired
    PersonServiceHelper personServiceHelper;

    @TransactionalEventListener
    public void handleAfterCommit(PersonReadyEvent event) {
        personService.updateName(event.getId(), "new name");
        //personServiceHelper.updatePerson(event.getId());
    }
}
