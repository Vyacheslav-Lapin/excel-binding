package ru.vlapin;

import lombok.val;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class ExcelPropsTest {

    @Test
    @DisplayName("Name method works correctly")
    void name() {
        val realNames = new ExcelProps(
                "report1",
                "salaries",
                "real-names");

        assertThat(realNames.getListForKey("column1"),
                containsInAnyOrder("column0"));

        assertThat(realNames.getListForKey("name"),
                containsInAnyOrder("fio"));

        assertThat(realNames.getListForKey("surname"),
                containsInAnyOrder("surname"));
    }
}