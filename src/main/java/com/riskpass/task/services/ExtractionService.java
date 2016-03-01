package com.riskpass.task.services;

import com.riskpass.task.config.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class ExtractionService {

    private static final String EMPTY = "";
    private final Config config;

    public ExtractionService(Config config) {
        this.config = config;
    }

    public List<String> extract(String line) {
        List<String> values = new ArrayList<>();

        String text = line.trim();
        while (!text.isEmpty()) {
            text = text.startsWith("\"") ? addQuotedCell(text, values) : addCell(text, values);
        }

        return values;
    }

    private String addQuotedCell(String text, List<String> values) {
        String unquotedText = text.substring(1);
        Matcher matcher = config.getNextQuotePattern().matcher(unquotedText);

        if (matcher.find()) {
            return addCell(unquotedText, values, matcher);
        }

        addLastQuotedCell(unquotedText, values);
        return EMPTY;
    }

    private String addCell(String text, List<String> values) {
        Matcher matcher = config.getCommaPattern().matcher(text);

        if (matcher.find()) {
            values.add(text.substring(0, matcher.start()).trim());
            return addCell(text, values, matcher);
        }

        values.add(text.trim());
        return EMPTY;
    }

    private void addLastQuotedCell(String text, List<String> values) {
        if (!config.getLastQuotePattern().matcher(text).find()) {
            throw new IllegalStateException();
        }

        values.add(text.substring(0, text.length() - 1));
    }

    private String addCell(String text, List<String> values, Matcher matcher) {
        String newText = text.substring(matcher.end()).trim();
        if (newText.isEmpty()) {
            values.add(EMPTY);
        }

        return newText;
    }
}
