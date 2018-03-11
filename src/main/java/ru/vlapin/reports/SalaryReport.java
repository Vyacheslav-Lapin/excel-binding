package ru.vlapin.reports;

import lombok.experimental.FieldDefaults;
import ru.vlapin.ExcelProps;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class SalaryReport extends ExcelProps {

    private enum Column {COLUMN1, NAME, SURNAME}

    public SalaryReport() {
        super("report1",
                "salaries",
                "real-names");
    }

    private List<String> getListForKey(Column column) {
        return getListForKey(column.name().toLowerCase());
    }

    public List<String> getNames() {
        return getListForKey(Column.NAME);
    }

    public List<String> getColumn1() {
        return getListForKey(Column.COLUMN1);
    }

    public List<String> getSurname() {
        return getListForKey(Column.SURNAME);
    }
}
