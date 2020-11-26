package com.zemrow.messenger.json;

import com.dslplatform.json.JsonReader;
import com.dslplatform.json.JsonWriter;
import com.dslplatform.json.Nullable;

import java.io.IOException;

/**
 * Конвертация Long в Hex представление и обратно, плюс обработчики Json
 * <p>
 * В Java {@link java.lang.Long#MAX_VALUE}<br>
 * 2<sup>63</sup> - 1 = 9 223 372 036 854 775 807<br>
 * Максимальное целое число, которое можно безопасно использовать в JavaScript<br>
 * 2<sup>53</sup> - 1 = 9 007 199 254 740 991<br>
 * Грубо все числа (Long) переводятся в HEX представление (16 символов = 64 бита)
 * </p>
 *
 * @author Alexandr Polyakov on 2020.12.13
 */
public class LongAsHex {

    /**
     * Чтение long из Json
     */
    public static final JsonReader.ReadObject<Long> LONG_READER = new JsonReader.ReadObject<Long>() {
        @Override
        public Long read(JsonReader reader) throws IOException {
            final char[] chars;
            if (reader.last() == '"') {
                chars = reader.readSimpleQuote();
            } else {
                chars = reader.readNumber();
            }
            final int len = reader.getCurrentIndex() - reader.getTokenStart() - 1;
            return hexStringToLong(chars, len);
        }
    };

    /**
     * Чтение Long из Json
     */
    public static final JsonReader.ReadObject<Long> NULLABLE_LONG_READER = new JsonReader.ReadObject<Long>() {
        @Nullable
        @Override
        public Long read(JsonReader reader) throws IOException {
            return reader.wasNull() ? null : LONG_READER.read(reader);
        }
    };

    /**
     * Запись Long в Json
     */
    public static final JsonWriter.WriteObject<Long> LONG_WRITER = new JsonWriter.WriteObject<Long>() {
        @Override
        public void write(JsonWriter writer, @Nullable Long value) {
            if (value == null) {
                writer.writeNull();
            } else {
                writer.writeString(longToHexString(value));
            }
        }
    };

    /**
     * Словарь
     */
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * Число в строку (HEX)
     *
     * @param l Число
     * @return Строка в шестнадцатеричном виде
     * @see Long#toHexString(long)
     */
    public static String longToHexString(long l) {
        final char array[] = new char[16];
        for (int i = 15; i >= 0; i--) {
            array[i] = digits[(int) l & 15];
            l >>= 4;
        }
        return new String(array);
    }

    /**
     * Строку(HEX) в число
     *
     * @param s Строка в шестнадцатеричном виде
     * @return Число
     */
    public static long hexStringToLong(final String s) {
        long l = 0;
        if (s.length() != 16) {
            throw new NumberFormatException("For input string: \"" + s + "\"");
        }
        for (int i = 0; i < 16; i++) {
            l <<= 4;
            final char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                l |= c - '0';
            } else if (c >= 'A' && c <= 'F') {
                l |= c - '7';
            } else if (c >= 'a' && c <= 'f') {
                l |= c - 'W';
            } else {
                throw new NumberFormatException("For input string: \"" + s + "\"");
            }
        }
        return l;
    }

    /**
     * Строку(HEX) в число
     *
     * @param array Строка в шестнадцатеричном виде
     * @param len   Количество символов которое необходимо обработать
     * @return Число
     */
    public static long hexStringToLong(final char array[], final int len) {
        long l = 0;
        if (len != 16 || array.length < len) {
            throw new NumberFormatException("For input string: \"" + new String(array) + "\"");
        }
        for (int i = 0; i < len; i++) {
            l <<= 4;
            final char c = array[i];
            if (c >= '0' && c <= '9') {
                l |= c - '0';
            } else if (c >= 'A' && c <= 'F') {
                l |= c - '7';
            } else if (c >= 'a' && c <= 'f') {
                l |= c - 'W';
            } else {
                throw new NumberFormatException("For input string: \"" + new String(array) + "\"");
            }
        }
        return l;
    }

}
