package java8.ex01;

import java8.data.Account;
import java8.data.Person;
import org.junit.Test;

import java.util.function.Function;


/**
 * Exercice 01 - java.util.function.Function
 */
public class Function_01_Test {

    /******** PART 1 - Integer -> Person *******/

    // tag::intToPerson[]
    // Cette fonction permet de transformer un entier en objet Person
    // le prenom sera de la forme "first_<ENTIER>"
    // le nom sera de la forme "last_<ENTIER>"
    // l'age sera de la forme "<ENTIER>"
    // le mot de passe sera de la forme "pass_<ENTIER>"
    private Function<Integer, Person> intToPerson = i -> new Person("first_"+i,"last_"+i,i,"pass_"+i);
    // end::intToPerson[]

    @Test
    public void test_intToPerson() throws Exception {

        // on invoque la fonction intToPerson avec en paramètre l'entier 10.
        Person result = intToPerson.apply(10);

        assert result.getFirstname().equals("first_10");
        assert result.getLastname().equals("last_10");
        assert result.getAge().equals(10);
        assert result.getPassword().equals("pass_10");
    }

    /******** PART 2 - Person -> Account *******/

    // tag::personToAccount[]
    // la propriété owner est valorisé avec la personne en paramètre
    // la propriété balance est valorisé à 1000
    private Function<Person, Account> personToAccount = p -> {
    	Account a = new Account();
    	a.setOwner(p);
    	a.setBalance(1000);
    	return a;
    };
    // end::personToAccount[]

    @Test
    public void test_personToAccount() throws Exception {

        Person person = new Person("Jules", "France", 10, "pass");

        //on invoque la fonction personToAccount
        Account result = personToAccount.apply(person);

        assert result.getOwner().equals(person);
        assert result.getBalance().equals(1000);
    }


    /******** PART 3 - Integer -> Account avec compose *******/

    // tag::intToAccountWithCompose[]
    // On utilise la méthode compose pour réutiliser les fonctions intToPerson et personToAccount
    private Function<Integer, Account> intToAccountWithCompose = personToAccount.compose(intToPerson);
    // end::intToAccountWithCompose[]


    @Test
    public void test_intToAccount_with_Compose() throws Exception {

        //on invoque la fonction intToAccountWithCompose avec l'entier 10
        Account result = intToAccountWithCompose.apply(10);

        assert result.getOwner().getFirstname().equals("first_10");
        assert result.getBalance().equals(1000);
    }

    /******** PART 4 - Integer -> Account avec andThen *******/

    // tag::intToAccountWithAndThen[]
    //on utilise la méthode andThen pour réutiliser les fonctions intToPerson et personToAccount
    private Function<Integer, Account> intToAccountWithAndThen = intToPerson.andThen(personToAccount);
    // end::intToAccountWithAndThen[]

    @Test
    public void test_intToAccount_with_AndThen() throws Exception {

        // on invoque la fonction intToAccountWithAndThen avec l'entier 11
        Account result = intToAccountWithAndThen.apply(11);

        assert result.getOwner().getFirstname().equals("first_11");
        assert result.getBalance().equals(1000);
    }
}
