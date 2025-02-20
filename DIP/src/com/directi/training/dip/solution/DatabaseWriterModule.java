package com.directi.training.dip.solution;

public class DatabaseWriterModule implements IWriter {
    private final MyDatabase database;

    public DatabaseWriterModule(MyDatabase database) {
        this.database = database;
    }

    @Override
    public void write(String encodedData) {
        database.write(encodedData);
    }
}
