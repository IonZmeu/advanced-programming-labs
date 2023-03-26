package com.ionn.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ionn.exceptions.InvalidCatalogException;
import com.ionn.models.Catalog;
import com.ionn.models.Document;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command {
    Catalog catalog = new Catalog();

    @Override
    public void execute(Catalog catalog, Document document) throws InvalidCatalogException {
        if (catalog == null) {
            throw new InvalidCatalogException("Catalog is null!");
        }
        this.catalog = catalog;
    }

    public void save(String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }
}
