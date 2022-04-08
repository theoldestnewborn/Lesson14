package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class DocWriter {
    private static String newFileNameDocs;
    static Scanner scanner = new Scanner(java.lang.System.in);

    public static void newDocFile(HashSet<String> strings) {

        java.lang.System.out.println("Укажите имя файла для отчета");
        newFileNameDocs = scanner.nextLine();

        try (PrintWriter pw1 = new PrintWriter(newFileNameDocs + ".txt")) {
            int arrayLength = strings.size();
            String[] filesToString = new String[arrayLength];
            strings.toArray(filesToString);
            HashMap<String, String> log = new HashMap<>();
            for (String string : filesToString) {
                if (string.toCharArray().length == 15
                        && (string.startsWith("docnum")
                        || string.startsWith("contract"))) {
                    String comment = " - верный формат";
                    log.put(string, comment);
                    pw1.write(string + log.get(string) + "\n");
                } else if (!(string.toCharArray().length == 15)) {
                    String comment = " - менее 15 символов";
                    log.put(string, comment);
                    pw1.write(string + log.get(string) + "\n");
                } else if (!(string.startsWith("docnum")
                        || string.startsWith("contract"))) {
                    String comment = " - не начинается с docnum или contract";
                    log.put(string, comment);
                    pw1.write(string + log.get(string) + "\n");
                }
            }
            System.out.println(log);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

