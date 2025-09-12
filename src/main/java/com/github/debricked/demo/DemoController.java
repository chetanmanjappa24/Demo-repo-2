package com.github.debricked.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.apache.logging.log4j.core.lookup.StrLookup;
import org.apache.logging.log4j.core.lookup.Interpolator;

import java.io.IOException;
import java.util.Collections;

@RestController
public class DemoController {

    @GetMapping("/")
    public String index() throws IOException {
        Document doc = Jsoup.connect("https://debricked.com/").get();
        Elements loginButton = doc.select("div[class^=journey-button] > *:contains(Log in)");
        return "Please visit %s to log into Debricked!".formatted(loginButton.attr("href"));
    }

    @GetMapping("/test-log4j")
    public String testLog4j() {
        // Minimal code to trigger the vulnerable constructor
        StrLookup lookup = new StrLookup() {
            public String lookup(String key) { return "value"; }
            public String lookup(org.apache.logging.log4j.core.LogEvent event, String key) { return "value"; }
        };
        Interpolator interpolator = new Interpolator(lookup, Collections.emptyList());
        return "Interpolator created";
    }
}
