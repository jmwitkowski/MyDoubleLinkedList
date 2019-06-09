package doubleLinkedList;

public interface DoubleLinkedList<E> {
    public boolean isEmpty(); //Metoda zwraca prawdę gdy lista jest pusta

    public int size(); //Metoda zwraca rozmiar listy

    public NodeDoubleLinked<E> getNode(int index); //Metoda dla podanego numeru węzła z listy zwraca węzeł

    public E get(int index); //Metoda dla podanego numeru węzła w liście zwraca jego element

    public boolean add(E element); //Metoda dodaje węzeł do listy

    public void set(int index, E element); //Metoda podmienia wartość węzła o podanym numerze listy

    public boolean addByIndex(int index, E element); //Metoda dodaje węzeł do listy w wskazanym miejscu

    public E remove(int index); //Metoda usuwa węzeł z listy w wskazanym miejscu


}
