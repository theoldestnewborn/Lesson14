package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


    public static ArrayList<String> filesCollector() {
        System.out.println("Введите названия файлов, 0 - конец списка");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> docs = new ArrayList<>();
        for (; ; ) {
            String newDocs = scanner.nextLine();
            if (newDocs.equals("0")) {
                System.out.println("Вы вышли");
                break;
            } else if (!(new File(newDocs).exists())) {
                System.out.println("Файл не найден");
            } else {
                docs.add(newDocs);
            }
        }
        return docs;
    }
}
