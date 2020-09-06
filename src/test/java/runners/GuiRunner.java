package runners;
import base.TaggedHooks;
import com.codeborne.selenide.Configuration;

import enumerators.Constants;
import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunNotifier;
import io.cucumber.junit.CucumberOptions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class GuiRunner implements Runnable {
    private RunNotifier runNotifier;
    private File tempDir;

    public GuiRunner(String domain, ListModel listOfFeature) {
        tempDir = new File(Constants.DESTINATION + "/temp");
        makeTempFeatureCopies(tempDir, listOfFeature);
        Configuration.baseUrl = domain;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/win/chromedriver84_win.exe");

    }

    private void makeTempFeatureCopies(File tempDir, ListModel listOfFeature) {
        deleteTempFeatureCopies();
        tempDir.mkdirs();
        for (int i = 0; i < listOfFeature.getSize(); i++) {
            try {
                FileUtils.copyFileToDirectory(new File(listOfFeature.getElementAt(i).toString()), tempDir);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void deleteTempFeatureCopies() {
        for (int i = 0; i < 10; i++) {
            System.gc();
        }
        if (tempDir.exists()) {
            try {
                FileUtils.forceDelete(tempDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        Thread testThread = new Thread(this);
        testThread.start();
    }

    public void stop(){
        runNotifier.pleaseStop();
    }

    @Override
    public void run() {
        JUnitCore jUnitCore = new JUnitCore();
        Field field ;
        try {
            field = JUnitCore.class.getDeclaredField("notifier");
            field.setAccessible(true);
            runNotifier = null;
            runNotifier = (RunNotifier) field.get(jUnitCore);
            jUnitCore.run(Runner.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
