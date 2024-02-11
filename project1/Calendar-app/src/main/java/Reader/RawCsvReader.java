package Reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class RawCsvReader {

	public List<String[]> readAll(String path) throws IOException, CsvException{
		InputStream in = getClass().getResourceAsStream(path);
		InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
		
		CSVReader csvReader = new CSVReader(reader);
		return csvReader.readAll();
	}
}
