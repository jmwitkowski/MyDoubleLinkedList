package doubleLinkedList;

public class DoubleLinkedListImpl<E> implements DoubleLinkedList<E> {
    /**
     * Pola dla węzła pierwszego oraz ostatniego w liście
     */
    private NodeDoubleLinked<E> first;
    private NodeDoubleLinked<E> last;
    /**
     * Metoda zwraca prawdę gdy lista jest pusta
     * @return prawda jeśli lista jest pusta
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * Metoda zwraca rozmiar listy
     * @return rozmiar listy
     */
    @Override
    public int size() {
        int size = 0;
        NodeDoubleLinked<E> checkNode = first;
        while (checkNode != null) {
            size++;
            checkNode = checkNode.next;
        }
        return size;
    }
    /**
     * Metoda dla podanego numeru węzła z listy zwraca węzeł
     * @param index - numer węzła w liśie
     * @return węzeł
     */
    @Override
    public NodeDoubleLinked<E> getNode(int index) {
        if(index > size()-1){throw new IndexOutOfBoundsException("Index " + index + " is out of bounds, actual size ");}

        NodeDoubleLinked<E> checkNode = first;
        int checkIndex = index;
        while (checkIndex >0) {
            checkNode = checkNode.next;
            checkIndex--;
        }
        return checkNode;
    }
    /**
     * Metoda dla podanego numeru węzła w liście zwraca jego element
     * @param index - numer węzła w liście
     * @return zwraca element z węzła
     */
    public E get (int index){
        if(index > size()-1){throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");}
        return getNode(index).element;
    }
    /**
     * Metoda dodaje węzeł do listy
     * @param element - dodany parametr do utworzonego węzła listy na jej końcu
     * @return zwraca true jeżeli doda
     */
    @Override
    public boolean add(E element) {

        if (first == null){
            first = new NodeDoubleLinked<>(element);
            last = first;
            return true;
        }
        NodeDoubleLinked oldLast = last;
        last = new NodeDoubleLinked<>(element);
        last.previous = oldLast;
        oldLast.next = last;
        return true;
    }

    /**
     * Metoda podmienia wartość węzła o podanym numerze listy
     * @param index - zadany numer węzła
     * @param element wartość do podmiany w węźle
     */
    @Override
    public void set(int index, E element) {
        getNode(index).element = element;
    }
    /**
     * Metoda dodaje węzeł do listy w wskazanym miejscu
     * @param index numer węzła w liście
     * @param element dodany parametr do utworzonego węzła
     * @return zwraca prawdę jeśli doda
     */


    @Override
    public boolean addByIndex(int index, E element) {
        if(index > size()-1){throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");}
        // dodawanie węzła gdy lista jest pusta
        if (first == null && index == 0){
            first = new NodeDoubleLinked<>(element);
            first = last;
            return true;
        }
        NodeDoubleLinked<E> nodeAtIndex = getNode(index);
        // dodawanie węzła na końcu listy
        if (nodeAtIndex == null){
            NodeDoubleLinked<E> oldLast = last;
            last = new NodeDoubleLinked<>(element);
            last.previous = oldLast;
            oldLast.next = last;
            return true;
        }
        // dodawanie węzła na początku listy
        if (nodeAtIndex.previous == null){
            NodeDoubleLinked<E> oldFirst = first;
            first = new NodeDoubleLinked<>(element);
            first.next = oldFirst;
            oldFirst.previous = first;
            return true;
        }
        //dodawanie węzła w środku listy
        NodeDoubleLinked<E> newNode = new NodeDoubleLinked<>(element);
        NodeDoubleLinked<E> previous = getNode(index).previous;
        previous.next = newNode;
        newNode.previous = previous;

        newNode.next = nodeAtIndex;
        nodeAtIndex.previous = newNode;
        return true;
    }

    /**
     * Metoda usuwa węzeł z listy w wskazanym miejscu
     * @param index - numer węzła w liście
     * @return zwraca element z usuniętego węzła
     */
    @Override
    public E remove(int index) {
        if(index > size()-1){throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");}

        NodeDoubleLinked<E> nodeToRemove = getNode(index);
        NodeDoubleLinked<E> previousNode = nodeToRemove.previous;
        NodeDoubleLinked<E> nextNode = nodeToRemove.next;

        //usunięcie węzła z początku listy
        if (previousNode == null){
            if (nextNode == null){
                first = null;
                last = null;
            }else{
                first = nextNode;
                nextNode.previous = null;
            }
            return nodeToRemove.element;
        }
        //usunięcie węzła z końca listy
        if (nextNode == null){
            last = previousNode;
            previousNode.next = null;
            return nodeToRemove.element;
        }
        //usunięcie węzła z środka listy
        previousNode.next = nextNode;
        nextNode.previous = previousNode;

        return nodeToRemove.element;
    }
}