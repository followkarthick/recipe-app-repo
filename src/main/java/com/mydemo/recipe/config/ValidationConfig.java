package com.mydemo.recipe.config;

public class ValidationConfig {


    /**
     * Max length of recipe
     */
    public static final int MAX_LENGTH_NAME = 100;

    /**
     * Default max length
     */
    public static final int MAX_LENGTH_DEFAULT = 255;

    /**
     * Matches for free text fields in our case instructions
     */
    public static final String PATTERN_FREE_TEXT = "^(?:\\p{L}\\p{M}*|[0-9]*|[\\/\\-+.,?!*();\"]|\\s)*$";

}
