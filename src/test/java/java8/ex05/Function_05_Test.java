package java8.ex05;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.function.Consumer;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

    //tag::functions[]
    // modifie le mot de passe en "secret"
    Consumer<Person> changePasswordToSecret = p -> p.setPassword("secret");;

    // vérifie que l'age > 4 avec une assertion JUnit
    Consumer<Person> verifyAge = p -> assertTrue(p.getAge()>4); ;

    // vérifie que le mot de passe est "secret" avec une assertion JUnit
    Consumer<Person> verifyPassword = p -> assertEquals("secret", p.getPassword());
    //end::functions[]


    @Test
    public void test_consumer() throws Exception {
        List<Person> personList = Data.buildPersonList();

        // on invoque la méthode personList.forEach pour modifier les mots de passe en "secret"
        // personList.forEach...
        personList.forEach(changePasswordToSecret);

        // on a remplacé la boucle for par l'invocation de la méthode forEach
        // Et on a utilisé la méthode andThen pour chaîner les vérifications verifyAge et verifyPassword
        // personList.forEach...
        personList.forEach(verifyAge.andThen(verifyPassword));

    }
}
