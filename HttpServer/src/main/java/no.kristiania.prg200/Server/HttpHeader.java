package no.kristiania.prg200.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

public class HttpHeader {
    private Map<String, String> header = new TreeMap<> (String.CASE_INSENSITIVE_ORDER);

    public HttpHeader put(String key, String value) {
        header.put(key, value);
        return this;
    }

    public HttpHeader setContentLength(int contentLength){
        return put("Content-Length", String.valueOf(contentLength));
    }
    public int getContentLength() {
        String contentLength = get("Content-Length");
        return contentLength != null ? Integer.parseInt(contentLength) : -1;
    }

    public String get(String key) {
        return header.get(key);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        writeHeaders(outputStream);
        writeEmptyLine(outputStream);
    }

    private void writeHeaders(OutputStream outputStream) throws IOException {
        for (Map.Entry<String, String> entry : header.entrySet()) {
            outputStream.write((entry.getKey() + ": " + entry.getValue() + "\r\n").getBytes());
        }
    }

    private void writeEmptyLine(OutputStream outputStream) throws IOException {
        outputStream.write("\r\n".getBytes());
    }

    public void readHeader(InputStream inputStream) throws IOException {
        String headerLine;
        while (!(headerLine = HttpIO.readLine(inputStream)).isEmpty()) {
            parseHeaderLine(headerLine);
        }
    }

    public void parseHeaderLine(String headerLine) throws UnsupportedEncodingException {
        int colonPos = headerLine.indexOf(':');
        String key = headerLine.substring(0, colonPos).trim();
        String value = headerLine.substring(colonPos+1).trim();
        header.put(key, value);
    }
}
