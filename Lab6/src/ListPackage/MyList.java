package ListPackage;

import SaladAndComponents.Vegetable;

import java.util.*;

/**
 * Клас MyList реалізує інтерфейс List для зберігання об'єктів типу Vegetable
 * у вигляді однозв'язного списку.
 */
public class MyList implements List<Vegetable> {
    /**
     * Внутрішній клас Node представляє елемент списку.
     */
    static class Node {
        private Vegetable vegetable; // Дані, які зберігає вузол
        public Node next; // Посилання на наступний вузол

        /**
         * Конструктор для створення вузла з заданим об'єктом Vegetable.
         *
         * @param vegetable овоч, який буде збережений у вузлі
         */
        public Node(Vegetable vegetable) {
            this.vegetable = vegetable;
            this.next = null;
        }
    }

    private Node head; // Головний (перший) елемент списку
    private int size; // Поточний розмір списку

    /**
     * Порожній конструктор. Створює порожній список.
     */
    public MyList() {
        head = null;
        size = 0;
    }

    /**
     * Конструктор, що створює список з одним елементом.
     *
     * @param vegetable овоч, який додається до списку
     */
    public MyList(Vegetable vegetable) {
        this();
        add(vegetable);
    }

    /**
     * Конструктор, що створює список з колекції об'єктів Vegetable.
     *
     * @param collection колекція об'єктів Vegetable
     */
    public MyList(Collection<Vegetable> collection) {
        this();
        addAll(collection);
    }

    /**
     * Повертає поточний розмір списку.
     *
     * @return розмір списку
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи є список порожнім.
     *
     * @return true, якщо список порожній, інакше false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Перевіряє, чи містить список заданий об'єкт.
     *
     * @param o об'єкт для перевірки
     * @return true, якщо список містить об'єкт, інакше false
     */
    @Override
    public boolean contains(Object o) {
        Node current = head;

        while (current != null) {
            if (Objects.equals(current.vegetable, o)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Повертає ітератор для проходження по списку.
     *
     * @return ітератор
     */
    @Override
    public Iterator<Vegetable> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Vegetable next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the list.");
                }
                Vegetable data = current.vegetable;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Конвертує список у масив об'єктів.
     *
     * @return масив об'єктів
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int index = 0;

        while (current != null) {
            array[index++] = current.vegetable;
            current = current.next;
        }

        return array;
    }

    /**
     * Конвертує список у масив заданого типу.
     *
     * @param a масив, в який копіюються елементи
     * @return масив з елементами списку
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }

        Node current = head;
        int index = 0;
        Object[] result = a;

        while (current != null) {
            result[index++] = current.vegetable;
            current = current.next;
        }

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    /**
     * Додає новий об'єкт до кінця списку.
     *
     * @param vegetable овоч для додавання
     * @return true, якщо додавання виконано успішно
     */
    @Override
    public boolean add(Vegetable vegetable) {
        Node newNode = new Node(vegetable);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

        return true;
    }

    /**
     * Видаляє об'єкт зі списку.
     *
     * @param o об'єкт для видалення
     * @return true, якщо об'єкт видалено
     */
    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }

        if (Objects.equals(head.vegetable, o)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && !Objects.equals(current.next.vegetable, o)) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        size--;
        return true;
    }

    /**
     * Перевіряє, чи всі об'єкти з заданої колекції містяться в списку.
     *
     * @param c колекція для перевірки
     * @return true, якщо всі об'єкти містяться
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Додає всі елементи з заданої колекції до списку.
     *
     * @param c колекція для додавання
     * @return true, якщо список було змінено
     */
    @Override
    public boolean addAll(Collection<? extends Vegetable> c) {
        for (Vegetable vegetable : c) {
            add(vegetable);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            modified |= remove(o);
        }
        return modified;
    }

    /**
     * Очищає список.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Повертає елемент списку за заданим індексом.
     *
     * @param index індекс елемента
     * @return елемент типу Vegetable
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі списку
     */
    @Override
    public Vegetable get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.vegetable;
    }

    /**
     * Замінює елемент за заданим індексом новим елементом.
     *
     * @param index індекс елемента, який потрібно замінити
     * @param element новий елемент для заміни
     * @return попередній елемент, що був на цьому індексі
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі списку
     */
    @Override
    public Vegetable set(int index, Vegetable element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Vegetable oldData = current.vegetable;
        current.vegetable = element;
        return oldData;
    }

    /**
     * @throws UnsupportedOperationException Метод додавання за індексом не реалізовано.
     */
    @Override
    public void add(int index, Vegetable element) {
        throw new UnsupportedOperationException("add at index is not implemented");
    }

    /**
     * @throws UnsupportedOperationException Метод додавання по індексу не реалізовано.
     */
    @Override
    public boolean addAll(int index, Collection<? extends Vegetable> c) {
        throw new UnsupportedOperationException("addAll at index is not implemented");
    }

    /**
     * @throws UnsupportedOperationException Метод видалення всіх, крім заданих, не реалізовано.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll is not implemented");
    }

    /**
     * @throws UnsupportedOperationException Метод видалення елемента за індексом не реалізовано.
     */
    @Override
    public Vegetable remove(int index) {
        throw new UnsupportedOperationException("remove at index is not implemented");
    }

    /**
     * @throws UnsupportedOperationException Метод отримання індексу першої появи не реалізовано.
     */
    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("indexOf is not implemented");
    }

    /**
     * @throws UnsupportedOperationException Метод отримання індексу останньої появи не реалізовано.
     */
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("lastIndexOf is not implemented");
    }

    /**
     * @throws UnsupportedOperationException Метод для створення ітератора зі списком не реалізовано.
     */
    @Override
    public ListIterator<Vegetable> listIterator() {
        throw new UnsupportedOperationException("listIterator is not implemented");
    }

    /**
     * @throws UnsupportedOperationException Метод для створення ітератора зі вказаного індексу не реалізовано.
     */
    @Override
    public ListIterator<Vegetable> listIterator(int index) {
        throw new UnsupportedOperationException("listIterator at index is not implemented");
    }

    /**
     * @throws UnsupportedOperationException Метод отримання підсписку не реалізовано.
     */
    @Override
    public List<Vegetable> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList is not implemented");
    }

    /**
     * @return Рядкове представлення списку
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (head == null) {
            sb.append("List is empty");
            return sb.toString();
        }

        sb.append("---------------LinkedList---------------\n");
        Node current = head;
        while (current != null) {
            sb.append(current.vegetable);
            sb.append("\n---------------\n");
            current = current.next;
        }
        sb.append("\n");

        return sb.toString();
    }
}
