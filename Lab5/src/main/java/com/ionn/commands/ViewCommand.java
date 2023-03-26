package com.ionn.commands;

import com.ionn.models.Catalog;
import com.ionn.models.Document;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {

    @Override
    public void execute(Catalog catalog, Document document){}

    public void view(String path) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File file = new File(path);
        desktop.open(file);
    }
}
