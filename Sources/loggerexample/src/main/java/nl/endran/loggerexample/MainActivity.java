package nl.endran.loggerexample;

import android.app.Activity;
import android.os.Bundle;

import nl.endran.logger.LogLevel;
import nl.endran.logger.Logger;
import nl.endran.logger.LoggerFactory;

public class MainActivity extends Activity {

    {
        LoggerFactory.setLogTag("EverythingIsAwesome");
        LoggerFactory.setLogLevel(LogLevel.INFO);
        LoggerFactory.setSpecificLogLevel(WillAlsoLogDebug.class, LogLevel.DEBUG);
    }
    
    Logger logger = LoggerFactory.getLogger(this);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logger.debug("Won't get logged");
        logger.info("But this will");

        WillAlsoLogDebug willAlsoLogDebug = new WillAlsoLogDebug();
        willAlsoLogDebug.doStuff();


        WillOnlyLogErrors willOnlyLogErrors = new WillOnlyLogErrors();
        willOnlyLogErrors.doStuff();
    }
}
