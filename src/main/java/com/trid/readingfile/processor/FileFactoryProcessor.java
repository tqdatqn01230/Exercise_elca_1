package com.trid.readingfile.processor;

import com.trid.readingfile.exception.NotSupportedEntityException;
import com.trid.readingfile.exception.NotSupportedFileExtensionException;

public class FileFactoryProcessor {

    public FileReaderProcessor createReaderProcessor(String fileName) throws NotSupportedFileExtensionException, IndexOutOfBoundsException, NotSupportedEntityException {
        FileExtension fileExtension = castToFileExtension(fileName);
        if (FileExtension.CSV.equals(fileExtension)) {
            if (fileName.contains("companies")){
                return new CsvCompanyReaderProcessor1(fileName);
            }
            throw new NotSupportedEntityException();
        }
        throw new NotSupportedFileExtensionException("Not Supported file extension: " + fileExtension);
    }

    private FileExtension castToFileExtension(String fileName) throws NotSupportedFileExtensionException, IndexOutOfBoundsException {
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
        if ("csv".equals(fileExtension)) {
            return FileExtension.CSV;
        }
        throw new NotSupportedFileExtensionException("Not Supported file extension: " + fileExtension);
    }
}