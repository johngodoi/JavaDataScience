package br.unifesp.henrique.john.research.datascience.io;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import java.io.FileReader;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by john on 14/06/16.
 */
public class CSVReaderTest {

            //CSV file header order
    private static final String [] FILE_HEADER_MAPPING = {"Last Name", "First Name"};

    @Test
    public void readWithHeader() throws Exception {
        FileReader reader = new FileReader("/home/john/IdeaProjects/JavaDataScience/src/test/resources/test.csv");
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
        CSVParser csvFileParser = new CSVParser(reader, csvFileFormat);
        List<CSVRecord> csvRecords = csvFileParser.getRecords();
        assertEquals("Primeira Linha", "First Name, Last Name" ,csvRecords.get(0).get("First Name").trim()+", "+csvRecords.get(0).get("Last Name").trim());
        assertEquals("Segunda Linha Primeira Coluna", "John",csvRecords.get(1).get("First Name").trim());
        assertEquals("Segunda Linha Segunda Coluna", "Godoi",csvRecords.get(1).get("Last Name").trim());
        assertEquals("Terceira Linha Primeira Coluna", "Diane",csvRecords.get(2).get("First Name").trim());
        assertEquals("Terceira Linha Segunda Coluna", "Quintanilha",csvRecords.get(2).get("Last Name").trim());
        reader.close();
        csvFileParser.close();
    }
}
