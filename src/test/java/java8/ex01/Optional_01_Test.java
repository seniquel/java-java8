package java8.ex01;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Filter, Map
 */
public class Optional_01_Test {
	
	class NotPresentException extends RuntimeException {
		
	}

    @Test
    public void test_optional_ifPresent() throws Exception {
    	
    	List<Person> persons = Data.buildPersonList(100);

        // recherche dans la liste ci-dessus la 1ère personne ayant 18 ans
        // en utilisant la méthode "findFirst"
        Optional<Person> optPerson = persons.stream().filter(p -> p.getAge()==18).findFirst();
         assertThat(optPerson.isPresent(), is(true));
        
        // TODO afficher la personne en question si l'optional contient une personne
        if(optPerson.isPresent()) {
        	System.out.println(optPerson.get().getFirstname() + " " + optPerson.get().getLastname());
        }
    }

    @Test(expected=NotPresentException.class)
    public void test_optional_notPresent() throws Exception {
    	List<Person> persons = Data.buildPersonList(50);

        // recherche dans la liste ci-dessus la 1ère personne ayant 75 ans
        // en utilisant la méthode "findFirst"
        Optional<Person> optPerson = persons.stream().filter(p -> p.getAge()==75).findFirst();
        assertThat(optPerson.isPresent(), is(false));
        
        // si la personne n'existe pas, jète une exception NotPresentException
        // en utilisant la méthode "orElseThrow" avec un supplier
        optPerson.orElseThrow( () -> new NotPresentException() );

    }
}
