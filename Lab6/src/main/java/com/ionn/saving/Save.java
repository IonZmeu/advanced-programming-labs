package com.ionn.saving;

import javax.swing.*;
import java.io.*;

public class Save {
    private FileOutputStream fileStream;
    private ObjectOutputStream objectStream;
    public void saveGameDataToFile(File file) throws IOException {

            fileStream = new FileOutputStream(file);
            objectStream = new ObjectOutputStream(fileStream);
    }

    public void saveObject(Object o) throws IOException {
        objectStream.writeObject(o);
    }

    public void endSave() throws IOException {
        objectStream.close();
        fileStream.close();
    }
}
