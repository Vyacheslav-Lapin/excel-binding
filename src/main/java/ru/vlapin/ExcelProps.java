package ru.vlapin;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.util.List;
import java.util.Properties;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor(access = PRIVATE)
public class ExcelProps {

    String excelFileName;
    String sheetName;
    Properties properties;

    @SneakyThrows
    public ExcelProps(String excelFileName, String sheetName, String mappingFileName) {
        this(excelFileName, sheetName, new Properties());
        String propertiesPath = String.format("/%s.properties", mappingFileName);
        try (val resource = ExcelProps.class.getResourceAsStream(propertiesPath)) {
            properties.load(resource);
        }
    }

    private List<String> getListForRealKey(String realKey) {
        // TODO: 11/03/2018 realize it!
        return List.of(realKey);
    }

    private String toRealKey(String key) {
        return properties.getProperty(key, key);
    }

    protected List<String> getListForKey(String key) {
        return getListForRealKey(toRealKey(key));
    }
}
