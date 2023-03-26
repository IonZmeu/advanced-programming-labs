package com.ionn;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.print.Doc;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CatalogUtil {

    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

    public static void view(Document doc,String path) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File file = new File(path);
        desktop.open(file);
    }



}
