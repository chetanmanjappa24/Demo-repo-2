package com.github.debricked.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.core.lookup.Interpolator;
import org.apache.logging.log4j.core.lookup.StrLookup;

import java.util.Collections;

/**
 * Demo controller that produces a compile-time bytecode reference to:
 * org.apache.logging.log4j.core.lookup.Interpolator.<init>(StrLookup, List)
 *
 * This mirrors the style of your jsoup controller so Debricked static analysis
 * can detect the vulnerable symbol without running the code locally.
 */
@RestController
public class Log4jReachabilityDemoController {

    static class DemoLookup implements StrLookup {
        @Override
        public String lookup(String key) {
            return "demo";
        }
    }

    @GetMapping("/log4j-reach-demo")
    public String index() {
        // Direct constructor call — this will be present in compiled .class files
        Interpolator interpolator = new Interpolator(new DemoLookup(), Collections.emptyList());
        // Keep response simple; we are only using this endpoint as a demo artifact
        return "Interpolator created: " + interpolator.getClass().getName();
    }
}
