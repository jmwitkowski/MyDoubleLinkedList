package doubleLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> list;

    @Before
    public void setUp(){
        // given
        list = new DoubleLinkedListImpl();
    }

    @Test
    public void shouldAddNumberTest() {

        // when
        list.add(1);

        // then
        assertTrue("Lista powinna miec tylko jeden element",list.size()==1);

    }

    @Test
    public void shouldAddTwoNumberTest() {

        // when
        list.add(1);
        list.add(2);

        // then
        assertTrue("Lista powinna miec tylko dwa elementy",list.size()==2);

    }

    @Test
    public void shouldAddHundredNumberTest() {

        // when
        for (int i=0 ;i <100;i++){
            list.add(i);
        }

        // then
        assertTrue("Lista powinna miec tylko 100 elementów",list.size()==100);

    }

    @Test
    public void shouldGetOneNumberTest() {
        // given
        int numberIn1 = 1;

        // when
        list.add(numberIn1);
        int numberGet1 = list.get(0);

        // then
        assertTrue("Pobrany pierwszy element powinien być równy "+numberIn1, numberIn1==numberGet1);

    }

    @Test
    public void shouldGetTwoNumberTest() {
        // given
        int numberIn1 = 1;
        int numberIn2 = 2;

        // when
        list.add(numberIn1);
        list.add(numberIn2);

        int numberGet1 = list.get(0);
        int numberGet2 = list.get(1);

        // then
        assertTrue("Pobrany pierwszy element powinien być równy "+numberIn1, numberIn1==numberGet1);
        assertTrue("Pobrany drugi element powinien być równy "+numberIn2, numberIn2==numberGet2);

    }


    @Test
    public void shouldDeleteOneNumberTest() {

        int numberIn1 = 1;

        //when
        list.add(numberIn1);
        list.remove(0);

        //then
        assertTrue("Lista powinna być pusta po usunięciu jedynego elementu", list.isEmpty());
    }

    @Test
    public void shouldDeleteTwoNumberTest() {

        int numberIn1 = 1;
        int numberIn2 = 2;


        //when
        list.add(numberIn1);
        list.add(numberIn2);

        list.remove(0);
        list.remove(0);

        //then
        assertTrue("Lista powinna być pusta po usunięciu jedynego elementu", list.isEmpty());
    }

    @Test
    public void shouldDeleteSecondNumberFromThreeTest() {
        // TODO testy usuwania dwóch elementów z listy
        int numberIn1 = 1;
        int numberIn2 = 2;
        int numberIn3 = 3;


        //when
        list.add(numberIn1);
        list.add(numberIn2);
        list.add(numberIn3);

        int numberGet3 = list.get(2);

        list.remove(1);
        //then
        assertTrue("Po usunięciu elementu drugiego trzeci powinien być równy drugiemu", list.get(1)==numberGet3);
        assertTrue("Lista po usunięciu elementu powinna mieć 2 elementy", list.size()==2);

    }

    @Test
    public void shouldSetOneNumberTest() {
        int numberIn1 = 1;
        int valueSet = 7;

        //when
        list.add(numberIn1);
        list.set(0,valueSet);

        //then
        assertTrue("Po zmianie element indeks 0 powinien miec wartość 7", list.get(0)==valueSet);

    }

    @Test
    public void shouldSetTwoNumberTest() {
        int numberIn1 = 1;
        int valueSet1 = 7;
        int numberIn2 = 3;
        int valueSet2 = 5;

        //when
        list.add(numberIn1);
        list.add(numberIn2);
        list.set(0,valueSet1);
        list.set(1,valueSet2);

        //then
        assertTrue("Po zmianie element indeks 0 powinien miec wartość 7", list.get(0)==valueSet1);
        assertTrue("Po zmianie element indeks 1 powinien miec wartość 5", list.get(1)==valueSet2);


    }


}