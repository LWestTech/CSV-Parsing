package com.example;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;


public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        String fileFormat = ".csv";
        String fileName = "File";
        String path = "/workspaces/CSV-Parsing/rawmaven/src/main/resources/";

        List<String[]> inList;
        try (CSVReader reader = new CSVReader(new FileReader(path + fileName + fileFormat))) {
            inList = reader.readAll();
        }

        List<String[]> outList = new ArrayList<String[]>();
        outList.add(inList.get(0));

        for (String[] arr : inList) {
            if (arr[7].contains("lean")) {
                outList.add(arr);
            }
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(path + fileName + " - OUTPUT" + fileFormat))) {
            writer.writeAll(outList);
        }
    }
}
