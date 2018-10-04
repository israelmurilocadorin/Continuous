package com.mycompany.continuous;

import java.io.IOException;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
    
    private static final Logger LOG = Logger.getLogger(App.class.getCanonicalName());

    public static void main(String[] args) {
        Document doc;
        try {
            doc = Jsoup.connect("http://en.wikipedia.org/").get();
            LOG.fine(doc.title());
            Elements newsHeadlines = doc.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                LOG.fine(String.format("%s\n\t%s",
                        headline.attr("title"), headline.absUrl("href")));
            }
        } catch (IOException e) {
            LOG.severe(e.toString());
        }

    }
}
