package edu.pvr.concepts.common.utils;

public class ConsoleUtil {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void success(String value) {
        System.out.println(ANSI_GREEN + value + ANSI_RESET);
    }

    public static void info(String value) {
        System.out.println(ANSI_BLUE + value + ANSI_RESET);
    }

    public static void warning(String value) {
        System.out.println(ANSI_YELLOW + value + ANSI_RESET);
    }

    public static void danger(String value) {
        System.out.println(ANSI_RED + value + ANSI_RESET);
    }
}
