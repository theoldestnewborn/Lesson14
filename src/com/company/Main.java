package com.company;


import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        ArrayList <String> filesList = Menu.filesCollector();
        DocReader file1 = new DocReader();

        HashSet <String> mainSet = new HashSet<>();
        for (int j = 0; j < filesList.size(); j++) {
        mainSet.addAll(file1.readFromFile(filesList.get(j)));
        }
        DocWriter.newDocFile(mainSet);
    }
}


