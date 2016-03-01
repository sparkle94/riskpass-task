package com.riskpass.task;

import com.riskpass.task.config.Config;
import com.riskpass.task.services.ExtractionService;

import java.util.regex.Pattern;

public class Task {
  public static void main(final String[] args) {
    Config.Modifiable config = new Config.Modifiable();
    config.commaPattern(Pattern.compile(";"));
    config.nextQuotePattern(Pattern.compile("\"\\s*;"));

    ExtractionService extractionService = new ExtractionService(config);
    extractionService.extract(args[0]).forEach(System.out::println);
  }
}
