# Build-Utility-Class-for-List-in-Java
In order to complete an implementation of any collection, a class library will usually create a utility class consisting exclusively of static methods that operate on that collection. This utility class could include the following:

ListADT<T> toList(T[] elements) that creates a new instance of the ListADT that contains all of the specified elements in the order they appeared in elements. This method should throw a IllegalArgumentException if elements contains one or more null values.

void addAll(ListADT<T> list, T... elements) that adds the specified elements to the end of the specified list. Elements should be added in the same order they appear in elements. This method should throw a IllegalArgumentException if elments contains one more more null values.

int frequency(ListADT<T> list, T element) that returns the number of elements in the specified list equal to the specified element. More formally, it should return the number of elements in the list such that (o == null) ? e == null : o.equals(e))

boolean disjoint(ListADT<?> one, ListADT<?> two that returns true if the two lists have no elements in common. This method should throw a IllegalArgumentException if either list is null or if either list contains a null element.

boolean equals(ListADT<?> one, ListADT<?> two) that returns true if the two lists are equal. Two lists are equal if they have the same elements in the same order. If either list is null, or if either list contains a null element, this method should throw a IllegalArgumentException.

void reverse(ListADT<?> list) that reverses the order of the elements in the specified list.

void swap(ListADT<?> list, int i, int j) that swaps the elements at the specified position in the specified list. This method should throw an IndexOutOfBoundsException if either i or j are out of range.
