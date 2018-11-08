package no.kristiania.prg200;

import java.util.Map;
import java.util.TreeMap;

public class HttpHeader {
    private Map<String, String> header = new TreeMap<> (String.CASE_INSENSITIVE_ORDER);

    public HttpHeader put(String key, String value) {
        header.put(key, value);
        return this;
    }
}
