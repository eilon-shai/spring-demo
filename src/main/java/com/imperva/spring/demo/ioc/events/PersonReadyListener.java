package com.imperva.spring.demo.ioc.events;

import com.imperva.spring.demo.ioc.services.IPersonService;
import com.imperva.spring.demo.ioc.services.PersonServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class PersonReadyListener {

   private static final Logger logger = LoggerFactory.getLogger( PersonReadyListener.class );

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleAfterCommit(PersonRollBack event) {
        logger.error("failed to create person, rollback");
    }
}
