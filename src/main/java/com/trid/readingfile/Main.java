package com.trid.readingfile;

import com.trid.readingfile.entities.Company;
import com.trid.readingfile.processor.CsvReaderProcessor;
import com.trid.readingfile.processor.FileReaderProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    private static final String fileName = "./src/main/resources/companies.csv";

    public static void main(String[] args) {
//        List companies = readFile(new CsvReaderProcessor(fileName));
//        processFileV1(companies);
//        processFileV2(companies);
        Integer a = 900, b =900;


        if (a == b) System.err.println("OK");
    }

    public static List<Company> readFile(FileReaderProcessor<List<Company>> reader) {
        List<Company> results = reader.readFromFile();
        return results;
    }

    public static void processFileV1(List<Company> companies) {
        int total = companies.stream()
                .filter(company -> "CH".equals(company.getCountry().toUpperCase()))
                .map(company -> company.getCapital())
                .reduce(0, Integer::sum);
        System.out.println("Total: " + total);
        String a = "abc";
        StringBuilder s = new StringBuilder();
        s.append("a");

    }

    public static void processFileV2(List<Company> companies) {
        System.out.println("Company Name: ");
        companies.stream()
                .filter(company -> "CH".equals(company.getCountry().toUpperCase()))
                .sorted((Company c1, Company c2) -> c2.getCapital() - c1.getCapital())
                .map(x -> x.getName())
                .forEach(System.out::println);
    }
}
