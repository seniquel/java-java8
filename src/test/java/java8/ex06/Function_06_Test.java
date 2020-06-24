package java8.ex06;


import java.util.function.Supplier;

import org.junit.Test;

import java8.data.Person;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {


    // tag::formatAge[]
    // la méthode retourne une chaîne de caractères de la forme [age=<AGE>] (exemple : [age=12])
    String formatAge(Supplier<Person> supplier) {
        return "[age="+supplier.get().getAge()+"]";
    }
    // end::formatAge[]


    @Test
    public void test_supplier_formatAge() throws Exception {
        // on crée un nouveau supplier contenant une Person pour qu'il soit passant
    	Supplier<Person> supplierPerson = () -> new Person("Jean-Leo","De la Chaussette",35,"pass");
        String result = formatAge(supplierPerson);

        assert result.equals("[age=35]");
    }

}
