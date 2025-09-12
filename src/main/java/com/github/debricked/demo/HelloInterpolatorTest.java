package com.example.demo;

import org.apache.logging.log4j.core.lookup.Interpolator;
import org.apache.logging.log4j.core.lookup.StrLookup;
import java.util.Collections;

public class HelloInterpolatorTest {
    // Dummy StrLookup implementation so we can instantiate Interpolator
    static class DummyLookup implements StrLookup {
        @Override
        public String lookup(String key) {
            return "dummy";
        }
    }

    public static void main(String[] args) {
        // This line directly calls the vulnerable constructor:
        Interpolator interpolator = new Interpolator(new DummyLookup(), Collections.emptyList());
        System.out.println("Created: " + interpolator);
    }
}
