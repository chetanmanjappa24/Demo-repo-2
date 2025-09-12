package com.github.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Log4j imports
import org.apache.logging.log4j.core.lookup.Interpolator;
import org.apache.logging.log4j.core.lookup.StrLookup;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Log4jReachabilityController {

    @GetMapping("/test-log4j")
    public String testLog4j() {
        // Dummy implementation to trigger vulnerable constructor
        StrLookup lookup = key -> "value";
        List<String> list = new ArrayList<>();

        // This directly calls the vulnerable constructor
        Interpolator interpolator = new Interpolator(lookup, list);

        return "Interpolator created: " + interpolator.toString();
    }
}
