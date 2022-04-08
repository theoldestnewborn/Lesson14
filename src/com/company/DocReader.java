package com.company;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DocReader {


    public Set<String> readFromFile(String path) {
        Set<String> docsList = null;
        int arrayLength = 0;
        try (FileReader fis1 = new FileReader(path)) {
            while ((fis1.read()) != -1) {
                arrayLength++;
            }
            try (FileReader fis = new FileReader(path)) {
                int i = 0;
                int j = 0;
                char[] chars = new char[arrayLength];
                while ((i = fis.read()) != -1) {
                    chars[j] = ((char) i);
                    i++;
                    j++;
                }
                docsList = new HashSet<>();
                String string = new String(chars);
                String[] tempArray = string.split("\n");
                for (int k = 0; k < tempArray.length; k++) {
                    if (docsList.contains(tempArray[k])) {
                    } else {
                        docsList.add(tempArray[k]);
                    }
                }
            }
        } catch (NullPointerException | IOException e) {
            java.lang.System.out.println("Такого файла не существует");
        }
        return docsList;
    }
}

