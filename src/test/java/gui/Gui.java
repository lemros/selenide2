package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import enumerators.Constants.DOMENS;
import enumerators.Constants.BROWSER;

import runners.GuiRunner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;


import static javax.swing.UIManager.getSystemLookAndFeelClassName;

public class Gui extends JFrame {

    static private final String newline = "\n";

    private JPanel mainPanel;
    private JComboBox domensComboBox;
    private JProgressBar featureProgressBar;
    private JProgressBar scenarioProgressBar;
    private JButton startButton;
    private JButton chooseFileButton;
    private JList scenariosList;
    private JButton deleteFileButton;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JButton stopButton;
    private JLabel domensComboBoxLabel;
    private JLabel scenarioListLabel;
    private JLabel logTextAreaLabel;
    private JLabel browserComboBoxLabel;
    private JComboBox browserComboBox;
    private JTextPane textPane1;

    public static JTextPane log;

    private JFileChooser chooser;
    DefaultListModel defaultListModel = new DefaultListModel();

    public static String textLogAreaText = "";

    private static GuiRunner runner;

    public Gui() {

        //$$$setupUI$$$();
        initialize();

        add(mainPanel);
        setTitle("Automatizovaný testing");
        setSize(1100, 800);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        setDomens();
        setBrowsers();
        //logTextAreaScroll = new JScrollPane(log, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooser = new JFileChooser("./src/test/resources/features");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("FEATURES", "feature");
                chooser.setFileFilter(filter);

                if (chooser.showOpenDialog(Gui.this) == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    scenariosList.setModel(defaultListModel);
                    defaultListModel.addElement(file.getAbsolutePath());


                }
            }
        });

        deleteFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = scenariosList.getSelectedIndex();
                if (selectedIndex != -1) {
                    defaultListModel.remove(selectedIndex);
                }
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
                    AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                        System.out.println(button.getText());
                    }
                }

                ListModel listModel = scenariosList.getModel();

                featureProgressBar.setMaximum(listModel.getSize());
                featureProgressBar.setValue(1);
                scenarioProgressBar.setValue(1);

                String domain = DOMENS.valueOf(domensComboBox.getSelectedItem().toString()).value;
                runner = new GuiRunner(domain, listModel);
                runner.start();

            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runner.stop();
            }
        });
    }


    private void initialize() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(7, 6, new Insets(10, 10, 10, 10), -1, -1));
        panel1.add(mainPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        scenarioListLabel = new JLabel();
        scenarioListLabel.setText("Zoznam Scenarov");
        mainPanel.add(scenarioListLabel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logTextAreaLabel = new JLabel();
        logTextAreaLabel.setText("Logy");
        mainPanel.add(logTextAreaLabel, new GridConstraints(0, 3, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        featureProgressBar = new JProgressBar();
        mainPanel.add(featureProgressBar, new GridConstraints(6, 1, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scenarioProgressBar = new JProgressBar();
        mainPanel.add(scenarioProgressBar, new GridConstraints(5, 1, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scenariosList = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        scenariosList.setModel(defaultListModel1);
        mainPanel.add(scenariosList, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(300, 400), null, 0, false));
        radioButton1 = new JRadioButton();
        radioButton1.setSelected(true);
        radioButton1.setText("Všetky");
        mainPanel.add(radioButton1, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton2 = new JRadioButton();
        radioButton2.setText("Smoke");
        mainPanel.add(radioButton2, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton3 = new JRadioButton();
        radioButton3.setSelected(false);
        radioButton3.setText("Release");
        mainPanel.add(radioButton3, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startButton = new JButton();
        startButton.setText("Spusti");
        mainPanel.add(startButton, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stopButton = new JButton();
        stopButton.setHideActionText(true);
        stopButton.setText("Stop");
        mainPanel.add(stopButton, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        domensComboBoxLabel = new JLabel();
        domensComboBoxLabel.setText("Prostredie");
        mainPanel.add(domensComboBoxLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        domensComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        domensComboBox.setModel(defaultComboBoxModel1);
        mainPanel.add(domensComboBox, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteFileButton = new JButton();
        deleteFileButton.setText("Vymaž súbor");
        mainPanel.add(deleteFileButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        browserComboBoxLabel = new JLabel();
        browserComboBoxLabel.setText("Prehliadač");
        mainPanel.add(browserComboBoxLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        browserComboBox = new JComboBox();
        mainPanel.add(browserComboBox, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chooseFileButton = new JButton();
        chooseFileButton.setText("Vyber súbor");
        mainPanel.add(chooseFileButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Scenario progress bar");
        mainPanel.add(label1, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Feature progress bar");
        mainPanel.add(label2, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Vyber testov");
        mainPanel.add(label3, new GridConstraints(2, 3, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        log = new JTextPane();
        mainPanel.add(log, new GridConstraints(1, 3, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));

    }

    public static void updateLogTextArea(String text) {
        if (textLogAreaText != null && log != null) {
            textLogAreaText += text;
            HTMLDocument doc = (HTMLDocument) log.getDocument();
            HTMLEditorKit editorKit = (HTMLEditorKit) log.getEditorKit();
            try {
                editorKit.insertHTML(doc, doc.getLength(), textLogAreaText, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    private static void clearLogTextArea() {
        log.setText("");
        textLogAreaText = "";
        HTMLDocument doc = (HTMLDocument) log.getDocument();
        HTMLEditorKit editorKit = (HTMLEditorKit) log.getEditorKit();
        try {
            editorKit.insertHTML(doc, doc.getLength(), textLogAreaText, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void setBrowsers() {
        List<BROWSER> browserList = Arrays.asList(BROWSER.values());
        for (BROWSER browser : browserList)
            browserComboBox.addItem(browser.toString());
    }

    private void setDomens() {
        List<DOMENS> domensList = Arrays.asList(DOMENS.values());
        for (DOMENS domens : domensList)
            domensComboBox.addItem(domens.toString());
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Gui testGui2 = new Gui();
                testGui2.setVisible(true);
            }
        });


    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        //$$$setupUI$$$();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(7, 6, new Insets(10, 10, 10, 10), -1, -1));
        panel1.add(mainPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        scenarioListLabel = new JLabel();
        scenarioListLabel.setText("Zoznam Scenarov");
        mainPanel.add(scenarioListLabel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logTextAreaLabel = new JLabel();
        logTextAreaLabel.setText("Logy");
        mainPanel.add(logTextAreaLabel, new GridConstraints(0, 3, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        featureProgressBar = new JProgressBar();
        mainPanel.add(featureProgressBar, new GridConstraints(6, 1, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scenarioProgressBar = new JProgressBar();
        mainPanel.add(scenarioProgressBar, new GridConstraints(5, 1, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scenariosList = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        scenariosList.setModel(defaultListModel1);
        mainPanel.add(scenariosList, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(300, 400), null, 0, false));
        radioButton1 = new JRadioButton();
        radioButton1.setSelected(true);
        radioButton1.setText("Všetky");
        mainPanel.add(radioButton1, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton2 = new JRadioButton();
        radioButton2.setText("Smoke");
        mainPanel.add(radioButton2, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton3 = new JRadioButton();
        radioButton3.setSelected(false);
        radioButton3.setText("Release");
        mainPanel.add(radioButton3, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startButton = new JButton();
        startButton.setText("Spusti");
        mainPanel.add(startButton, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stopButton = new JButton();
        stopButton.setHideActionText(true);
        stopButton.setText("Stop");
        mainPanel.add(stopButton, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        domensComboBoxLabel = new JLabel();
        domensComboBoxLabel.setText("Prostredie");
        mainPanel.add(domensComboBoxLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        domensComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        domensComboBox.setModel(defaultComboBoxModel1);
        mainPanel.add(domensComboBox, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteFileButton = new JButton();
        deleteFileButton.setText("Vymaž súbor");
        mainPanel.add(deleteFileButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        browserComboBoxLabel = new JLabel();
        browserComboBoxLabel.setText("Prehliadač");
        mainPanel.add(browserComboBoxLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        browserComboBox = new JComboBox();
        mainPanel.add(browserComboBox, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chooseFileButton = new JButton();
        chooseFileButton.setText("Vyber súbor");
        mainPanel.add(chooseFileButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Scenario progress bar");
        mainPanel.add(label1, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Feature progress bar");
        mainPanel.add(label2, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Vyber testov");
        mainPanel.add(label3, new GridConstraints(2, 3, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textPane1 = new JTextPane();
        mainPanel.add(textPane1, new GridConstraints(1, 3, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }
}
