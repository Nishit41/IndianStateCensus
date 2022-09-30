import com.opencsv.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class StateCensusAnalyser {


    //    public static void readFile(String path) throws IOException, StateCensusAnalyserException, CsvException {
//        File file = new File(path);
    static int count = 0;

    public static int readDataLineByLine(String file) throws IOException, StateCensusAnalyserException {
        File file1 = new File(file);
        if (!file1.exists()) {
            throw new StateCensusAnalyserException("file not exist");
        }


        // Create an object of filereader class
        // with CSV file as a parameter.
        FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReaderBuilder(filereader).build();
        String[] nextRecord;


        // we are going to read data line by line
        while ((nextRecord = csvReader.readNext()) != null) {
            for (String ref : nextRecord) {
                System.out.print(ref + "\t");
            }
            count++;
        }
        //}
        // catch (Exception e) {
        //     e.printStackTrace();
        //}
        return count;
    }

    public static void checkExtensionOfFile(String file) throws IOException, StateCensusAnalyserException {
        String expectedFileType = "csv";
        int index = file.lastIndexOf(".");
        String actualFileType = file.toString().substring(index + 1);
        if (!expectedFileType.equals(actualFileType))
            throw new StateCensusAnalyserException("file type doesn't match");
    }
}