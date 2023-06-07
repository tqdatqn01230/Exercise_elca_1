package com.trid.readingfile.processor;

import com.trid.readingfile.exception.NotSupportedFileExtensionException;

public class FileFactoryProcessor {
    public FileReaderProcessor createReaderProcessor(String fileName) throws NotSupportedFileExtensionException {
        FileExtension fileExtension = castToFileExtension(fileName);
        if (FileExtension.CSV.equals(fileExtension)) {
            return new CsvCompanyReaderProcessor(fileName);
        }
        throw new NotSupportedFileExtensionException("Not Supported file extension: " + fileExtension);
    }

    private FileExtension castToFileExtension(String fileName) throws NotSupportedFileExtensionException {
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
        if ("csv".equals(fileExtension)) {
            return FileExtension.CSV;
        }
        throw new NotSupportedFileExtensionException("Not Supported file extension: " + fileExtension);
    }
}
