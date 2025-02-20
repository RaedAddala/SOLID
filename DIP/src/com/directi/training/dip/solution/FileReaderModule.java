package com.directi.training.dip.solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderModule implements IReader {
    private final String filePath;

    public FileReaderModule(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String read() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
        return content.toString().trim();
    }
}
