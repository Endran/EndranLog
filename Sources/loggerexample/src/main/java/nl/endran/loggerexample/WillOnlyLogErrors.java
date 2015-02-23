package nl.endran.loggerexample;

import nl.endran.logger.LogLevel;
import nl.endran.logger.Logger;
import nl.endran.logger.LoggerFactory;

/**
 * (C) Koninklijke Philips N.V., 2014.
 * All rights reserved.
 */
public class WillOnlyLogErrors {

    {
        LoggerFactory.setSpecificLogLevel(this, LogLevel.ERROR);
    }
    
    Logger logger = LoggerFactory.getLogger(this);

    public void doStuff() {
        logger.info("This will not be logged, since we called setSpecificLogLevel with logLevel error");
        logger.error("This will be logged");
    }
}
