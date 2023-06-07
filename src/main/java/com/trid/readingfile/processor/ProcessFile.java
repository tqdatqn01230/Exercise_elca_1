package com.trid.readingfile.processor;

import com.trid.readingfile.entities.Company;

import java.util.List;

public class ProcessFile {
    public  void processFileV1(List<Company> companies) {
        int total = companies.stream()
                .filter(company -> "CH".equals(company.getCountry().toUpperCase()))
                .map(company -> company.getCapital())
                .reduce(0, Integer::sum);
        System.out.println("Total: " + total);
    }

    public  void processFileV2(List<Company> companies) {
        System.out.println("Company Name: ");
        companies.stream()
                .filter(company -> "CH".equals(company.getCountry().toUpperCase()))
                .sorted((Company c1, Company c2) -> c2.getCapital() - c1.getCapital())
                .map(x -> x.getName())
                .forEach(System.out::println);
    }
}
