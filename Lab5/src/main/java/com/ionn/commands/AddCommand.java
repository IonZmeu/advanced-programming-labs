package com.ionn.commands;

import com.ionn.exceptions.InvalidCatalogException;
import com.ionn.exceptions.InvalidDocumentException;
import com.ionn.models.Catalog;
import com.ionn.models.Document;

public class AddCommand implements Command {

    @Override
    public void execute(Catalog catalog, Document document) throws InvalidCatalogException, InvalidDocumentException {
        if (catalog == null) {
            throw new InvalidCatalogException("Catalog is null!");
        }

        if (document == null) {
            throw new InvalidDocumentException("Document is null!");
        }

        catalog.getDocs().add(document);
    }
}
