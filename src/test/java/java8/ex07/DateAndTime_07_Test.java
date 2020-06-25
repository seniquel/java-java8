package java8.ex07;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

/**
 * Exercice 07 - Instant
 */
public class DateAndTime_07_Test {

    @Test
    public void test_date_to_localdate() throws Exception {

        // On crée une date Java 1 (12/02/2017)
        Date date = new Date(117,1,12);

        // On transforme la date en Instant
        Instant instant = date.toInstant();

        // on transforme la date en LocalDate  

        LocalDate result = LocalDateTime.ofInstant(instant,ZoneId.systemDefault()).toLocalDate();

        assertThat(result.getYear(), is(2017));
        assertThat(result.getMonth(), is(Month.FEBRUARY));
        assertThat(result.getDayOfMonth(), is(12));

    }
}
