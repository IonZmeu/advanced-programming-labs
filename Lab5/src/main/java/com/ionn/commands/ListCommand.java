package com.ionn.commands;

import com.ionn.exceptions.InvalidCatalogException;
import com.ionn.models.Catalog;
import com.ionn.models.Document;

public class ListCommand implements Command {

    @Override
    public void execute(Catalog catalog, Document document) throws InvalidCatalogException {
        if (catalog == null) {
            throw new InvalidCatalogException("Catalog is null!");
        }

        catalog.getDocs().forEach(doc -> System.out.println(doc.getName()));
    }
}
