package main.java.com.pixolestudios.pswriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimaryWindow extends JFrame implements ActionListener {

    //Constants
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;


    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, viewMenu, aboutMenu;
    //File menu items
    private JMenuItem newFileMenuItem, openFileMenuItem, saveFileMenuItem;
    //About menu items
    private JMenuItem exitMenuItem;

    public PrimaryWindow() {
        setupWindow();
        setupTextArea();
        setupScrollbar();
        setupMenuBar();

        add(mainPanel);
        textArea.getDocument().addDocumentListener(new AutoComplete(textArea));
        textArea.getDocument().putProperty("name", "Text Area");
    }

    private void setupWindow() {
        setTitle(PSWriter.WINDOW_TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void setupTextArea() {
        textArea = new JTextArea("", 0, 0);
        textArea.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        textArea.setTabSize(2);
        textArea.setLineWrap(true);
    }

    private void setupScrollbar() {
        scrollPane = new JScrollPane(textArea);
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane);
    }

    private void setupMenuBar() {
        //Create objects
        //Create menu bar
        menuBar = new JMenuBar();
        //Create menus
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        aboutMenu = new JMenu("About");
        //Create "file menu" items
        newFileMenuItem = new JMenuItem("New");
        openFileMenuItem = new JMenuItem("Open");
        saveFileMenuItem = new JMenuItem("Save");
        //Create "about menu" items
        exitMenuItem = new JMenuItem("Exit");

        //Add listeners
        //New file menu item listener
        newFileMenuItem.addActionListener(this);
        //Exit menu item listener
        exitMenuItem.addActionListener(this);

        //Add objects
        //Add menu items
        fileMenu.add(newFileMenuItem);
        fileMenu.add(openFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        aboutMenu.add(exitMenuItem);
        //Add menus
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(aboutMenu);
        //Set menu bar
        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // If the event source was exitMenuItem
        if (e.getSource() == exitMenuItem) {
            doExitEvent();
        } else if (e.getSource() == newFileMenuItem) {
            doNewFileEvent();
        } else if (e.getSource() == openFileMenuItem) {
            doOpenFileEvent();
        } else if (e.getSource() == saveFileMenuItem) {
            doSaveFileEvent();
        }
    }

    private void doExitEvent() {
        dispose();
    }

    private void doNewFileEvent() {
    }

    private void doOpenFileEvent() {
    }

    private void doSaveFileEvent() {
    }
}
