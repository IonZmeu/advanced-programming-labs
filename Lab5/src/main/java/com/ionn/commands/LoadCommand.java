package com.ionn.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ionn.exceptions.InvalidCatalogException;
import com.ionn.models.Catalog;
import com.ionn.models.Document;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {

    @Override
    public void execute(Catalog catalog, Document document) throws InvalidCatalogException {
        if(catalog == null){
            throw new InvalidCatalogException("Catalog is null!");
        }

    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(path),
                Catalog.class);
    }
}
