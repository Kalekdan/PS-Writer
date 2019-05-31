package main.java.com.pixolestudios.pswriter;

public class PSWriter {
    public static final String WINDOW_TITLE = "PS Writer";

    private PSWriter() {
    }

    public static void main(String[] args) {
        PrimaryWindow mainWindow = new PrimaryWindow();
        mainWindow.setVisible(true);
    }
}
