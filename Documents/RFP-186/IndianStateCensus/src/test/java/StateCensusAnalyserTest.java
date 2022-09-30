import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import java.io.IOException;

import static org.testng.Assert.assertThrows;

public class StateCensusAnalyserTest {
    private static final String CSV_FILE_PATH = "src/main/resources/IndiaStateCensusData (1).csv";
    private static final String CSV_WRONG_FILE_PATH = "src\\main\\resources\\StateCensusDat.csv";
    private static final String CSV_WRONG_FILE_EXTENSION = "src\\main\\resources\\IndiaStateCensusDat.txt";

    //    private static final String CSV_WRONG_FILE_HEADER = "C:\\Users\\abhis\\IdeaProjects\\CensusAnalyser\\src\\main\\resources\\IndianStateCensus.csv";
    @Test
    void givenFileToMatchTheNoOfRecords() throws IOException, CsvException, StateCensusAnalyserException {
        int noOfrecord = StateCensusAnalyser.readDataLineByLine(CSV_FILE_PATH);
        Assert.assertEquals(29, noOfrecord);
    }

    @Test
    void givenWrongFileNameShouldThrowCustomException() {
        StateCensusAnalyserException exception = Assert.expectThrows(StateCensusAnalyserException.class, () -> StateCensusAnalyser.readDataLineByLine(CSV_WRONG_FILE_PATH));
        Assert.assertEquals("file not exist", exception.getMessage());
    }

    @Test
    void givenWrongFileTypeShouldThrowCustomException() {
        StateCensusAnalyserException exception = Assert.expectThrows(StateCensusAnalyserException.class, () -> StateCensusAnalyser.checkExtensionOfFile(CSV_WRONG_FILE_EXTENSION));
        Assert.assertEquals("file type doesn't match", exception.getMessage());

    }
}

