package com.alexa.filemanager;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileManagerTest {

    private FileManager fileManager = new FileManager();

    @Test
    public void calculateFiles() throws Exception {
        String path = "C:\\Users\\Alexa\\Downloads";
        assertEquals(11, fileManager.calculateFiles(path));
    }

    @Test
    public void calculateDirs() throws Exception {
        String path = "C:\\Users\\Alexa\\IdeaProjects";
        assertEquals(4, fileManager.calculateDirs(path));
    }

    @Test //copy
    public void copyFile() throws Exception{
        String sourceFile  = "C:\\Users\\Alexa\\text.txt";
        String targetDirectory = "C:\\Users\\Alexa\\Downloads\\new\\text.txt";

        fileManager.copyFile(sourceFile,targetDirectory);
        Path copiedFile = Paths.get(targetDirectory + "\\text.txt");
        Files.exists(copiedFile);
    }

}