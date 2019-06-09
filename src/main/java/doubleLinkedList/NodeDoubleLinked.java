package doubleLinkedList;

public class NodeDoubleLinked<E> {
    E element;// element listy dwukierunkowej
    NodeDoubleLinked<E> next;// następnik
    NodeDoubleLinked<E> previous;// poprzednik


    /**
     * Konstruktor 1 argumentowy, używany przy pierwszym węźle listy
     *
     * @param element w węźle
     */
    public NodeDoubleLinked(E element) {
        this.element = element;
    }

    /**
     * Konstruktor 3 argumentowy
     * @param element element przechowywany w węźle
     * @param next wskazanie na następnik
     * @param previous wskazanie na poprzednik
     */
    public NodeDoubleLinked (E element, NodeDoubleLinked next, NodeDoubleLinked previous){
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    //metody

    /**
     * Metoda
     * @return zwraca element z węzła
     */
    public E getElement() {
        return this.element;
    }
    /**
     * Metoda zwraca
     * @return poprednik
     */
    public NodeDoubleLinked<E> getPrevious() {
        return previous;
    }

    /**
     * Metoda ustawia
     * @param previous jako poprzednik
     */
    public void setPrevious(NodeDoubleLinked<E> previous) {
        this.previous = previous;
    }

    /**
     * Metoda zwraca
     * @return następnik
     */
    public NodeDoubleLinked<E> getNext() {
        return next;
    }
    /**
     * Metoda ustawia
     * @param next jako następnik
     */
    public void setNext(NodeDoubleLinked<E> next) {
        this.next = next;
    }

    /**
     * Metoda czyści element z węzła, następnik oraz poprzednik
     */
    public void clearNode(){
        this.element = null;
        this.next = null;
        this.previous = null;
    }
}
