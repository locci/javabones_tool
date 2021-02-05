package br.ime.usp.parser.filemanager;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFile {

    public void buildCSVFile(List<Integer>  dataLines, String type) throws IOException {

        String fileName = "csv" + type + ".csv";


        final FileWriter sw = new FileWriter(fileName);
        final CSVPrinter printer = new CSVPrinter(sw, CSVFormat.DEFAULT);

        for (int i = 0; i < dataLines.size(); i++) {
            printer.printRecord(dataLines.get(i));
        }

        printer.flush();
        printer.close();

    }



}
