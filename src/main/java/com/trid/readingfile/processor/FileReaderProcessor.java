package com.trid.readingfile.processor;

public interface FileReaderProcessor<T> {
    public abstract T readFromFile();
}