package java8.ex04;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Exercice 4 - java.util.function.Predicate
 */
public class Function_04_Test {

    // tag::filterMethod[]
    <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                result.add(el);
            }
        }
        return result;
    }
    // end::filterMethod[]

    // PART 1 - ADULT

    // tag::adult[]
    // AGE >=18
    Predicate<Person> adult = p -> p.getAge()>=18;
    // end::adult[]

    @Test
    public void test_predicate() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // on invoque la méthode filter pour que le test soit passant
        List<Person> result =  filter(personList,adult);

        assert result.size() == 4;

    }

    // PART 2 - ADULT AND LASTNAME=France AND FIRSTNAME=Armor

    // tag::predicateand[]
    // le prédicat vérifie que le nom est "France"
    Predicate<Person> lastnameIsFrance = p -> p.getLastname().equals("France");


    // le prédicat vérifie que le prénom est "Armor"
    Predicate<Person> firstnameIsArmor = p -> p.getFirstname().equals("Armor");
    // end::predicateand[]

    @Test
    public void test_predicate_and() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // on invoque la méthode filter pour que le test soit passant
        // en chaînant les prédicats adult, lastnameIsFrance et firstnameIsArmor avec la méthode and
        List<Person> result = filter(personList, adult.and(lastnameIsFrance).and(firstnameIsArmor));

        assert result.size() == 1;
        assert result.get(0).getFirstname().equals("Armor");
        assert result.get(0).getLastname().equals("France");
        assert result.get(0).getAge().equals(25);

    }
}
