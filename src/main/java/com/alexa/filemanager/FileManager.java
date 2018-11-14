package com.alexa.filemanager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileManager {
    public int calculateFiles(String path) {
        File targetDirectory = new File(path);
        File[] files = targetDirectory.listFiles();
        int counter = 0;

        for (int i = 0; i < files.length; i++) { //File file : files <- forloop
            File file = files[i];
            if (file.isFile() && !file.isHidden()) {
                System.out.println((String.valueOf(i) + " - " + files[i].getName()));
                counter += 1;
            }
        }
        return counter;
    }

    public int calculateDirs(String path) {
        int counter = 0;
        File dir = new File(path);
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "  \t folder");
                    counter += 1;
                }
            }
        }
        return counter;
    }

    public  void copyFile(String sourceFile, String targetDirectory) throws IOException{
        Path pathSourceFile  = Paths.get(sourceFile);
        Path pathTargetDirectory = Paths.get(targetDirectory);

        Files.copy(pathSourceFile, pathTargetDirectory);
    }

}

