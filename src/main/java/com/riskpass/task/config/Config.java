package com.riskpass.task.config;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class Config {

    Pattern commaPattern = compile(",");
    Pattern nextQuotePattern = compile("\"\\s*,");
    Pattern lastQuotePattern = compile("\"$");

    public Pattern getCommaPattern() {
        return commaPattern;
    }

    public Pattern getNextQuotePattern() {
        return nextQuotePattern;
    }


    public Pattern getLastQuotePattern() {
        return lastQuotePattern;
    }

    public void setCommaPattern(Pattern commaPattern) {
        this.commaPattern = commaPattern;
    }

    public void setNextQuotePattern(Pattern nextQuotePattern) {
        this.nextQuotePattern = nextQuotePattern;
    }

    public void setLastQuotePattern(Pattern lastQuotePattern) {
        this.lastQuotePattern = lastQuotePattern;
    }
}
