package com.riskpass.task.config;

import java.util.regex.Pattern;

public class Config {
  private static final Pattern COMMA_PATTERN = Pattern.compile(",");
  private static final Pattern NEXT_QUOTE_PATTERN = Pattern.compile("\"\\s*,");
  private static final Pattern LAST_QUOTE_PATTERN = Pattern.compile("\"$");

  Pattern commaPattern = Config.COMMA_PATTERN;
  public Pattern commaPattern() {return this.commaPattern;}

  Pattern nextQuotePattern = Config.NEXT_QUOTE_PATTERN;
  public Pattern nextQuotePattern() {return this.nextQuotePattern;}

  Pattern lastQuotePattern = Config.LAST_QUOTE_PATTERN;
  public Pattern lastQuotePattern() {return this.lastQuotePattern;}

  public Config() {
  }

  public Config(
    final Pattern commaPattern,
    final Pattern nextQuotePattern,
    final Pattern lastQuotePattern
  ) {
    this.commaPattern = commaPattern;
    this.nextQuotePattern = nextQuotePattern;
    this.lastQuotePattern = lastQuotePattern;
  }

  public static class Modifiable extends Config {
    public void commaPattern(final Pattern value) {this.commaPattern = value;}
    public void nextQuotePattern(final Pattern value) {this.nextQuotePattern = value;}
    public void lastQuotePattern(final Pattern value) {this.lastQuotePattern = value;}

    public Modifiable() {
    }

    public Modifiable(
      final Pattern commaPattern,
      final Pattern nextQuotePattern,
      final Pattern lastQuotePattern
    ) {
      super(commaPattern, nextQuotePattern, lastQuotePattern);
    }
  }
}
