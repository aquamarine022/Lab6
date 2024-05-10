package client.Utils;

import java.util.Scanner;

public class Input {
    private static Scanner scanner;
    private static boolean fileMode = false;

    public static Scanner getUserScanner() {
        return scanner;
    }

    public static void setUserScanner(Scanner userScanner) {
        Input.scanner = userScanner;
    }

    public static boolean isFileMode() {
        return fileMode;
    }

    public static void setFileMode(boolean fileMode) {
        Input.fileMode = fileMode;
    }

}
