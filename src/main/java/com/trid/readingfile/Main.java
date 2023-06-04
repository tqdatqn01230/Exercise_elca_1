package com.trid.readingfile;

import com.trid.readingfile.entities.Company;
import com.trid.readingfile.processor.CsvReaderProcessor;
import com.trid.readingfile.processor.FileReaderProcessor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReaderProcessor reader = new CsvReaderProcessor("asd");
    }
    public static void readFile(FileReaderProcessor<List<Company>> reader){
        List<Company> results = reader.readFromFile();

    }
}
