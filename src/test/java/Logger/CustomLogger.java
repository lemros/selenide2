package Logger;

import enumerators.Constants;
import gui.Gui;

import javax.swing.*;
import java.io.File;
import java.util.logging.*;

public class CustomLogger extends Formatter {

    private FileHandler fileHTML;
    private Formatter formatterHTML;
    private Logger customLogger;
    private File logDirectory;

    private String getFeatureName(String name){

        Gui.updateLogTextArea("<b>Feature: " + name + "</b><br>");
        return "<h2 style=font:bold 10pt Tahoma;>\n"+"Feature"+name+"</h2>\n";
    }

    @Override
    public String format(LogRecord rec){
        String msg = rec.getMessage();

        /*if(msg.equals("end scenario")
            return getTableEnd;
        */
        String[] message = msg.split(";");
        String constant = message[0];
        String name = "";
        try {
            name = message[1];
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(constant.equals("new feature"))
            return getFeatureName(name);
        if(constant.equals("new scenario"))
            return getFeatureName(name);


        return "";
    }

    @Override
    public String getHead(Handler h){
        return "<!DOCTYPE html>\n<head>\n<style type=\"text/css\">\n</style></head><body>";
    }
    @Override
    public String getTail(Handler h){
        String result = "</body>\n</html>";
        return result;
    }

    public void setupNewLofFile(String fileName) {
        fileName = fileName.replace(".feature", "");
       // String logFile = logDirectory.get
    }
}
