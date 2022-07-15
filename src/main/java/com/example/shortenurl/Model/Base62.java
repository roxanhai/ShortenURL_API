package com.example.shortenurl.Model;

import javax.swing.text.IconView;

public class Base62 {
    static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String to_Base62(long value) {
        final StringBuilder sb = new StringBuilder(1);
        do {
            sb.insert(0, BASE62[(int) (value % 62)]);
            value /= 62;
        } while (value > 0);
        return sb.toString();
    }

    public static int convert(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 36;
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        }
        return -1;
    }

    public static Long to_Base10(String value) {
        long result = 0L;
        for (int i = 0; i < value.length(); i++) {
            result += convert(value.charAt(i)) * Math.pow(62, value.length() - i - 1);
        }
        return result;

        //If SnowFlake Bit == 64 bit -> Return Result -1024
    }

}

