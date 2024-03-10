package com.ebson.skillserver.util;

import org.springframework.stereotype.Component;

@Component
public class UUIDFormatter {
    public static String formatToUUID(String input) {
        return input.replaceAll(
                "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})",
                "$1-$2-$3-$4-$5"
        );
    }

}
