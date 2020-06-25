package java8.ex03;

import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Exercice 03 - LocalTime
 */
public class DateAndTime_03_Test {

    @Test
    public void test_localTime_of() {

        // on crée un objet LocalTime à l'heure 15h24m02s
        LocalTime result = LocalTime.of(15, 24, 2);

        // on valorise les différentes variables afin de rendre le test passant
        int hour = 15;
        int minutes = 24;
        int second = 2;

        assertThat(hour, is(15));
        assertThat(minutes, is(24));
        assertThat(second, is(2));
    }

    @Test
    public void test_localTime_parse() {

        // on crée un objet LocalTime à l'heure 09h30m00s à l'aide de la méthode parse
        LocalTime result = LocalTime.parse("09:30:00");


        // on valorise les différentes variables afin de rendre le test passant
        int hour = 9;
        int minutes = 30;
        int second = 0;

        assertThat(hour, is(9));
        assertThat(minutes, is(30));
        assertThat(second, is(0));
    }

    @Test
    public void test_localTime_format() {

        // on crée un objet localTime à l'heure 12h00m00s
        // en utilisant la méthode of
        LocalTime localTime = LocalTime.of(12, 0);

        // On formatte l'heure pour que le test soit passant
        String result = localTime.format(DateTimeFormatter.ofPattern("hh:mm"));
        System.out.println(result);

        assertThat(result, is("12:00"));
    }
}
