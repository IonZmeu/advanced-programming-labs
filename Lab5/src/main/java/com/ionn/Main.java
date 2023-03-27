package com.ionn;

import com.ionn.commands.*;
import com.ionn.exceptions.InvalidCatalogException;
import com.ionn.models.Catalog;
import com.ionn.models.Document;
import com.ionn.report.Freemaker;

import java.io.IOException;

public class Main {

        public static void main(String args[]) throws Exception {
            Main app = new Main ();
            app.testCreateSave();
            app.testLoadView();
        }

        private void testCreateSave() throws Exception {
            AddCommand addCommand = new AddCommand();
            ListCommand listCommand = new ListCommand();

            Catalog catalog = new Catalog();
            catalog.setName("MyDocuments");

            var book = new Document("article1");
            book.setId("1");
            var article = new Document("book1");
            article.setId("2");

            addCommand.execute(catalog, book);
            addCommand.execute(catalog, article);

            listCommand.execute(catalog, null);

            SaveCommand saveCommand = new SaveCommand();
            saveCommand.execute(catalog,null);
            saveCommand.save("D:/lab/catalog.json");

            testFreemaker(catalog);
        }

        private void testLoadView() throws InvalidCatalogException, IOException {
            LoadCommand loadCommand = new LoadCommand();
            ViewCommand viewCommand = new ViewCommand();

            loadCommand.load("D:/lab/catalog.json");
            //System.out.println(catalog);

            viewCommand.view("D:/lab/catalog.json");
        }

    private void testFreemaker(Catalog catalog) throws Exception {
        Freemaker freemaker = new Freemaker(catalog);
        freemaker.CreateHtml();
    }
}
