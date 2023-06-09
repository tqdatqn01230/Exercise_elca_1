package com.trid.readingfile.processor;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.trid.readingfile.entities.Company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvCompanyReaderProcessor implements FileReaderProcessor<List<Company>> {
    private String fileName;

    public CsvCompanyReaderProcessor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Company> readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value;
            List<Company> companies = new ArrayList<>();
            reader.readLine();
            while ((value = reader.readLine()) != null) {
                String[] values = value.split(",");
                int id = Integer.parseInt(values[0]);
                int capital = Integer.parseInt(values[3]);
                boolean isHeadQuarter;
                if (values.length ==6) isHeadQuarter = "1".equals(values[5]);
                else isHeadQuarter = false;
                companies.add(new Company(id, values[1], values[2], capital, values[4], isHeadQuarter));
            }
            return companies;
        } catch (IOException exception) {
            System.err.println(exception);
        }
        return null;
    }
}