package com.directi.training.dip.solution;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkReaderModule implements IReader {
    private final String url;

    public NetworkReaderModule(String url) {
        this.url = url;
    }

    @Override
    public String read() {
        StringBuilder content = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            InputStream in = urlObj.openStream();
            InputStreamReader reader = new InputStreamReader(in);
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading from URL: " + url, e);
        }
        return content.toString();
    }
}
