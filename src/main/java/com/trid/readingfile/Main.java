package com.trid.readingfile;

import com.trid.readingfile.entities.Company;
import com.trid.readingfile.processor.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final String folderPath = "./src/main/resources/import";

    public static void main(String[] args) {

        try {
            String fileName = getFileName();
            fileName = folderPath + "/" + fileName;

            FileFactoryProcessor factoryProcessor = new FileFactoryProcessor();

            //cast fileName to FileExtension
            FileReaderProcessor fileReaderProcessor = factoryProcessor.createReaderProcessor(fileName);

            long startTime = System.nanoTime();

            List companies = readFile(fileReaderProcessor);
            System.out.println("Run time reading file:" + (System.nanoTime() - startTime));

            ProcessFile processFile = new ProcessFile();
            processFile.processFileV1(companies);
            processFile.processFileV2(companies);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Not found any file with defined extensions");
        }
    }

    public static List<Company> readFile(FileReaderProcessor<List<Company>> reader) {
        List<Company> results = reader.readFromFile();
        return results;
    }

    public static Set<String> listFilesUsingFilesList(String dir) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }

    public static String getFileName() throws Exception {
        Set<String> files = listFilesUsingFilesList(folderPath);
        return files.stream()
                .filter(x -> x.endsWith(".csv"))
                .findFirst().orElseThrow(Exception::new);
    }

}
