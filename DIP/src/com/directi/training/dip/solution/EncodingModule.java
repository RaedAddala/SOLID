package com.directi.training.dip.solution;

import java.util.Base64;

public class EncodingModule {
    private final IReader reader;
    private final IWriter writer;

    public EncodingModule(IReader reader, IWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void encode() {
        String inputData = reader.read();
        String encodedData = Base64.getEncoder().encodeToString(inputData.getBytes());
        writer.write(encodedData);
    }
}

