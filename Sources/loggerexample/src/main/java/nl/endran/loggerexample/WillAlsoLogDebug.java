package nl.endran.loggerexample;

import nl.endran.logger.Logger;
import nl.endran.logger.LoggerFactory;

/**
 * (C) Koninklijke Philips N.V., 2014.
 * All rights reserved.
 */
public class WillAlsoLogDebug {

    Logger logger = LoggerFactory.getLogger(this);

    public void doStuff() {
        logger.debug("Eventhough the global settings say that only INFO and higher get logged " +
                "this will also get logged, because of the setSpecificLogLevel call");
    }
}
