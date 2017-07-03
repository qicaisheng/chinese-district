package com.qicaisheng.util.cndistrict;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressParser {
    public static AddressParser getInstance() {
        return new AddressParser();
    }

    private AddressParser() {
    }

    public Map<String, String> parse() {
        List<String> lineList = getLineList("file/cn-district.text");
        Map<String, String> map = getCodeAddressMap(lineList);
        return map;
    }

    private Map<String,String> getCodeAddressMap(List<String> list) {
        return list.stream().collect(Collectors.toMap(AddressParser::getCodeFromLine, AddressParser::getAddressFromLine));
    }

    private static String getAddressFromLine(String line) {
        return line.substring(6);
    }

    private static String getCodeFromLine(String line) {
        return line.substring(0,6);
    }

    private List<String> getLineList(String fileName) {

        List<String> list = new ArrayList<>();

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
