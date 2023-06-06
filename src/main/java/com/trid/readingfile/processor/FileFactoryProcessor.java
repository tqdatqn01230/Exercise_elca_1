package com.trid.readingfile.processor;

public class FileFactoryProcessor {
    public FileReaderProcessor createReaderProcessor(String fileName, FileExtension fileExtension){
        if (fileExtension.equals(FileExtension.CSV)){
            return new CsvReaderProcessor(fileName);
        }
        return null;
    }
}
