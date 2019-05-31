package main.java.com.pixolestudios.pswriter;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.util.ArrayList;
import java.util.Collections;

public class AutoComplete implements DocumentListener {

    private ArrayList<String> keywords = new ArrayList<String>();
    private JTextArea textArea;


    public AutoComplete(JTextArea textArea) {
        this.textArea = textArea;
        keywords.add("brill");
        keywords.add("test");
        keywords.add("another");

        Collections.sort(keywords);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
//        System.out.println(e.getType());
        try {
            System.out.print(textArea.getText(e.getOffset(),1));
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println(e.getType());

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println(e.getType());

    }

    protected void addKeyWord(String word) {
        if (!keywords.contains(word)) {
            keywords.add(word);
            Collections.sort(keywords);
        }
    }

    protected void removeKeyWord(String word) {
        keywords.remove(word);
    }
}
