package ru.sergeev.corerest.common;

import java.util.HashMap;

import static org.apache.http.HttpHeaders.ACCEPT;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;

/**
 * Набор базовых хэдеров для запроса
 */
public class Headers extends HashMap<String, String> {

    public Headers() {
        put(CONTENT_TYPE, "application/json");
        put(ACCEPT, "*/*");
    }
}
