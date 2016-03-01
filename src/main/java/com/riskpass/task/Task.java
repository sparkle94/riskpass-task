package com.riskpass.task;


import com.riskpass.task.config.Config;
import com.riskpass.task.services.ExtractionService;

import static java.util.regex.Pattern.compile;

public class Task {

    public static void main(String[] args) {
        Config config = new Config();
        config.setCommaPattern(compile(";"));
        config.setNextQuotePattern(compile("\"\\s*;"));

        new ExtractionService(config).extract(args[0]).forEach(System.out::println);
    }
}
