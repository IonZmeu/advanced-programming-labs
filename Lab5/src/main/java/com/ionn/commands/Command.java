package com.ionn.commands;

import com.ionn.exceptions.InvalidCatalogException;
import com.ionn.exceptions.InvalidDocumentException;
import com.ionn.models.Catalog;
import com.ionn.models.Document;

public interface Command {
        public void execute(Catalog catalog, Document document) throws InvalidCatalogException, InvalidDocumentException;
}
