package com.ionn.report;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ionn.models.Catalog;
import com.ionn.models.Document;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class Freemaker {
    Catalog catalog = new Catalog();

    public Freemaker(Catalog catalog) {
        this.catalog = catalog;
    }


    public void CreateHtml() throws Exception {

        // 1. Configure FreeMarker
        //
        // You should do this ONLY ONCE, when your application starts,
        // then reuse the same Configuration object elsewhere.

        Configuration cfg = new Configuration();

        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(Freemaker.class, "/templates");

        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // 2. Proccess template(s)
        //
        // You will do this for several times in typical applications.

        // 2.1. Prepare the template input
        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "Catalog");

        input.put("catalog",catalog);

        List<Document> documentList = catalog.getDocs();
        input.put("documentList", documentList);

        // 2.2. Get the template
        Template template = cfg.getTemplate("HtmlTemplate.ftl");
        // 2.3. Generate the output

        // Write output to the console
        //Writer consoleWriter = new OutputStreamWriter(System.out);
        //template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File("output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }

    }
}
