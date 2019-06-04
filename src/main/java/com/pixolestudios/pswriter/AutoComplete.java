package main.java.com.pixolestudios.pswriter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.TreeMap;

public class AutoComplete implements DocumentListener {

    // TreeMap <Alias, ActualString>
    TreeMap<String, String> keywords = new TreeMap<String, String>();
    private JTextArea textArea;


    public AutoComplete(JTextArea textArea) {
        this.textArea = textArea;

        keywords.put("mc", "charactername");
        keywords.put("test", "test");
        keywords.put("another", "Another");
        System.out.println(keywords);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        String[] wordsArray = textArea.getText().split("\\s+");
        String lastWord = wordsArray[wordsArray.length - 1];
        String keyWordBeingTyped = checkIfTypingWord(lastWord);
        System.out.print(keyWordBeingTyped);
        Runnable doCompleteWord = new Runnable() {
            public void run() {
                if (!keyWordBeingTyped.isEmpty()){
                    textArea.setText(textArea.getText().substring(0, textArea.getText().length() - lastWord.length()) + keyWordBeingTyped);
                }
            }
        };
        SwingUtilities.invokeLater(doCompleteWord);
    }

    /**
     * Checks if word being typed is a keyword
     * If it is, returns keyword, otherwise returns empty string
     *
     * @param lastWord last word typed
     * @return keyword if found
     */
    private String checkIfTypingWord(String lastWord) {
        String closestMatch = keywords.higherKey(lastWord);
        if (closestMatch != null && closestMatch.startsWith(lastWord)) {
            return keywords.get(keywords.higherKey(lastWord));
        }
        return "";
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
       // System.out.println(e.getType());

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        //System.out.println(e.getType());

    }

    protected void addKeyWord(String alias, String actualWord) {
        if (!keywords.containsKey(alias)){
            keywords.put(alias, actualWord);
        }
    }

    protected void removeKeyWord(String word) {
        keywords.remove(word);
    }
}
