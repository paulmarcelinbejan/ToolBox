package io.github.paulmarcelinbejan.toolbox.utils.time.format.common;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class for creating and customizing {@link DateTimeFormatter} instances.
 *
 * <p>
 * This class provides static methods to create formatters and customize them
 * with localization settings, such as locale and timezone.
 * </p>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FormatUtils {

    /**
     * Creates a {@link DateTimeFormatter} based on the specified pattern.
     *
     * @param pattern the pattern string for the formatter
     * @return a new {@link DateTimeFormatter} instance
     */
    public static final DateTimeFormatter formatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    /**
     * Creates a localized {@link DateTimeFormatter} based on the specified pattern and locale.
     *
     * @param pattern the pattern string for the formatter
     * @param locale the locale for localization settings
     * @return a new localized {@link DateTimeFormatter} instance
     */
    public static final DateTimeFormatter formatterLocalized(String pattern, Locale locale) {
        return formatter(pattern).localizedBy(locale);
    }

    /**
     * Creates a localized {@link DateTimeFormatter} based on the specified formatter and locale.
     *
     * @param formatter the base formatter
     * @param locale the locale for localization settings
     * @return a new localized {@link DateTimeFormatter} instance
     */
    public static final DateTimeFormatter formatterLocalized(DateTimeFormatter formatter, Locale locale) {
        return formatter.localizedBy(locale);
    }
    
}
