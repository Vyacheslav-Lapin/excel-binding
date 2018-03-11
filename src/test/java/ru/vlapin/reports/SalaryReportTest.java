package ru.vlapin.reports;

import lombok.val;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

class SalaryReportTest {

    @Test
    @DisplayName("Name method works correctly")
    void name() {
        val salaryReport = new SalaryReport();
        List<String> names = salaryReport.getNames();
        assertThat(names, hasSize(1));
        assertThat(names, containsInAnyOrder("fio"));
    }
}