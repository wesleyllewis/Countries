

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Countries {
    static List<Country> countries = new ArrayList<>();
    static HashMap<String, List<Country>> countriesMap = new HashMap<>();
    public static void main(String[] args) throws Exception {

        fileReader();
        getUserInput();

    }
    static void getUserInput() throws Exception {
        System.out.println("Please Enter A Single Letter.");
        Scanner userInput = new Scanner(System.in);
        String beginningOfCountry = userInput.nextLine();
        if (beginningOfCountry.length() != 1) {
            throw new Exception("One Letter Only Please");
        } else {
            List countriesToFile = countriesMap.get(beginningOfCountry);
            writeFile(beginningOfCountry + "_countries.json", countriesToFile.toString());

        }
    }

    static void fileReader() throws FileNotFoundException{
        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        String letterInput = "#";

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);

            if (country.getName().startsWith(letterInput)) {
                countries.add(country);
                countriesMap.put(letterInput, countries);
            } else {
                letterInput = country.getName().substring(0, 1);
                countries = new ArrayList<>();
                countries.add(country);
                countriesMap.put(letterInput, countries);
            }
        }
        fileScanner.close();
    }

    static void writeFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(fileContent);
        fw.write(json);
        fw.close();

    }
}

