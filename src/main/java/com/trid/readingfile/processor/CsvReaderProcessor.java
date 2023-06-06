package com.trid.readingfile.processor;

import com.opencsv.CSVReader;
import com.trid.readingfile.entities.Company;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderProcessor implements FileReaderProcessor<List<Company>> {
    private String fileName;

    public CsvReaderProcessor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Company> readFromFile() {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String values[];
            List<Company> companies = new ArrayList<>();
            reader.readNext();
            while ((values = reader.readNext()) != null) {
                int id = Integer.parseInt(values[0]);
                int capital = Integer.parseInt(values[3]);
                boolean isHeadQuarter = "1".equals(values[5]);
                companies.add(new Company(id, values[1], values[2], capital, values[4], isHeadQuarter));
            }
            return companies;
        } catch (Exception exception) {
            System.err.println(exception);
        }
        return null;
    }
}
