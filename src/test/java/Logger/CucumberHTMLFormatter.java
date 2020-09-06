package Logger;


import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;

import java.util.LinkedList;

public class CucumberHTMLFormatter implements Formatter, Reporter {
    CustomLogger customLogger;
    private LinkedList<String> steps;
    public CucumberHTMLFormatter(){
        customLogger = new CustomLogger();
        steps = new LinkedList<String>();
    }
    @Override
    public void uri(String uri){
        customLogger.setupNewLofFile(uri);
    }
}
