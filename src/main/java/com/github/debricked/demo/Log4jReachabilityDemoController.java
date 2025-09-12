package com.github.debricked.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.core.lookup.Interpolator;
import org.apache.logging.log4j.core.lookup.StrLookup;

import java.util.Collections;

@RestController
public class Log4jReachabilityDemoController {

    static class DemoLookup implements StrLookup {
        @Override
        public String lookup(String key) {
            return "demo";
        }

        @Override
        public String lookup(org.apache.logging.log4j.core.LogEvent event, String key) {
            return "demo";
        }
    }

    @GetMapping("/log4j-reach-demo")
    public String index() {
        Interpolator interpolator = new Interpolator(new DemoLookup(), Collections.emptyList());
        return "Interpolator created: " + interpolator.getClass().getName();
    }
}
