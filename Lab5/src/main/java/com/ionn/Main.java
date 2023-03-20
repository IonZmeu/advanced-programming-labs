package com.ionn;

import java.io.IOException;

public class Main {

        public static void main(String args[]) throws IOException, InvalidCatalogException {
            Main app = new Main();
            app.testCreateSave();
            app.testLoadView();
        }

        private void testCreateSave() throws IOException {
            Catalog catalog =
                    new Catalog();
            catalog.setName("MyDocuments");
            var book = new Document("article1" );
            var article = new Document("book1" );
            catalog.add(book);
            catalog.add(article);
            System.out.println(catalog.toString());
            CatalogUtil.save(catalog, "D:/lab/catalog.json");
        }

        private void testLoadView() throws InvalidCatalogException, IOException {
            Catalog catalog = CatalogUtil.load("D:/lab/catalog.json");
            CatalogUtil.view(catalog.findById("article1"));
        }

}
