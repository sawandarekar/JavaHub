package javatest.others;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CsvToJson {

    // static String csvFileName = "";
    // static String jsonFileName = "";

    static String csvFileName = "E:\\workspace Machine Learning\\CFL Database\\Jan2016-Jun2016\\Apr2016.csv";
    static String jsonFileName = "E:\\workspace Machine Learning\\CFL Database\\Jan2016-Jun2016\\Apr2016.json";

    final static String csvFolder = "E:\\workspace Machine Learning\\CFL Database\\Jan2016-Jun2016";

    public static void main(final String[] args) {
        try {

            final File input = new File(csvFileName);
            final File output = new File(jsonFileName);
            final List<Map<?, ?>> data = CsvToJson.readObjectsFromCsv(input, output);
            /*
             * final File folder = new File(csvFolder); final File[] listOfFiles = folder.listFiles(); for (final File
             * listOfFile : listOfFiles) { if (listOfFile.isFile() && listOfFile.getName().contains(".csv")) { csvFileName =
             * csvFolder + "\\" + listOfFile.getName(); jsonFileName = csvFolder + "\\" + listOfFile.getName() + ".json";
             * final File input = new File(csvFileName); final File output = new File(jsonFileName);
             * System.out.println("reading file:" + csvFileName); CsvToJson.readObjectsFromCsv(input, output);
             * System.out.println("write complete : " + jsonFileName); } else if (listOfFile.isDirectory()) {
             * System.out.println("Directory " + listOfFile.getName()); } }
             */
            // CsvToJson.writeAsJson(data, output);

            // readCSV(csvFileName);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Map<?, ?>> readObjectsFromCsv(final File file, final File output) throws IOException {
        final CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
        final CsvMapper csvMapper = new CsvMapper();
        final MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(file);

        final Writer writer = new OutputStreamWriter(new FileOutputStream(output));
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        int i = 1;
        final ObjectNode rootNode = mapper.createObjectNode();
        final ArrayNode arrayNode = mapper.createArrayNode();
        Map<String, String> map = new HashMap<String, String>(10000);
        while (mappingIterator.hasNext()) {

            map = (Map<String, String>)mappingIterator.next();
            final ObjectNode game1 = mapper.createObjectNode();
            for (final Object entryObject : map.entrySet()) {
                final Map.Entry<String, String> entry = (Map.Entry<String, String>)entryObject;
                game1.put(entry.getKey(), entry.getValue());
            }
            arrayNode.add(game1);
            if (i++ % 10 == 0) {
                break;
            }
        }
        rootNode.put("anomalies", arrayNode);
        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, rootNode);
        return null;
    }

    public static void writeAsJson(final Map<String, String> map) {

    }

    public static void writeAsJson(final List<Map<?, ?>> data, final File file) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, data);
    }

    public static void readCSV(final String csvFileName) {

        BufferedReader br = null;
        String line = "";
        final String cvsSplitBy = ",";

        String[] csvHeader = null;

        try {

            br = new BufferedReader(new FileReader(csvFileName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                final String[] data = line.split(cvsSplitBy);
                if (csvHeader == null) {
                    csvHeader = data;
                    System.out.println(Arrays.toString(csvHeader));
                    System.out.println(csvHeader.length);
                }
                writeJson(csvHeader, data);
                // System.out.println(line);

            }

        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }

    public static void writeJson(final String[] csvHeader, final String[] values) {
        System.out.println("values:" + values.length);

        final Map<String, String> data = new HashMap<String, String>();
        for (int i = 0; i < csvHeader.length; i++) {
            if (values[i] != null) {
                data.put(csvHeader[i], values[i]);
            } else {
                data.put(csvHeader[i], null);
            }
        }
        final ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(jsonFileName), data);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}