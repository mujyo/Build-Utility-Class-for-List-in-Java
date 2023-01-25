package listadt;

import listadt.*;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListADTUtilities{
    public static <T> ListADT<T> toList(T[] elements){
        ListADTImpl<T> lsdt = new ListADTImpl<T>();
        for (int i = 0; i < elements.length; i++){
            if (elements[i] == null){
                throw new IllegalArgumentException("elements contain one or more null values!");
            }else{
                lsdt.addBack(elements[i]);
            }
        }
        return lsdt;
    }

    public static <T> void addAll(ListADT<T> list, T... elements) {
        if (elements == null){
            throw new IllegalArgumentException("elements is null!");
        }
        for (int i = 0; i < elements.length; i++){
            if (elements[i] == null){
                throw new IllegalArgumentException("elements contain one or more null values!");
            }else{
                list.addBack(elements[i]);
            }
        }
    }

    public static <T> int frequency(ListADT<T> list, T element) {
        int count = 0;
        for (int i=0; i<list.getSize(); i++){
            if (element == null && list.get(i) == null){
                count += 1;
            }else if (element.equals(list.get(i))){
                count += 1;
            }
        }
        return count;
    }

    public static boolean disjoint(ListADT<?> one, ListADT<?> two) {
        if (one == null || two == null){
            throw new IllegalArgumentException("ListADT is null!");
        } else {
            GenericListADTNode traverseOne = one.getHead();
            GenericListADTNode traverseTwo = two.getHead();

            List<Object> dummyOne = new ArrayList<>();
            List<Object> dummyTwo = new ArrayList<>();

            while (traverseOne !=null && traverseOne.getObject() != null) {
                dummyOne.add(traverseOne.getObject());
                traverseOne = traverseOne.getRest();
            }
            while (traverseTwo != null && traverseTwo.getObject() != null) {
                dummyTwo.add(traverseTwo.getObject());
                traverseTwo = traverseTwo.getRest();
            }
            Set<Object> oneSet = new HashSet<Object>(dummyOne);
            Set<Object> twoSet = new HashSet<Object>(dummyTwo);
            oneSet.retainAll(twoSet);
            int intersectNum = oneSet.size();

            if (intersectNum == 0) {
                return true;
            } else {
                return false;
            }
        }
    }


    public static boolean equals(ListADT<?> one, ListADT<?> two) {
        if (one == null || two == null || one.containNull() || two.containNull()){
            throw new IllegalArgumentException("ListADT is null!");
        }

        if (!(one.getSize() == two.getSize())){
            return false;
        }else{
            for (int i=0; i<one.getSize(); i++){
                if (one.get(i).equals(two.get(i))){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void reverse(ListADT<?> list) {
        ListADT<Object> dummyList = (ListADT<Object>) list;
        List<Object> vals = new ArrayList<Object>();
        ListADT<Object> tmpHead = new ListADTImpl();
        for (int index=0; index<list.getSize(); index++){
            vals.add(list.get(index));
        }
        for (int index = vals.size() - 1; index >=0; index--){
            tmpHead.addBack(vals.get(index));
        }
        dummyList.setHead(tmpHead.getHead());
        System.out.println(list);
        System.exit(0);
    }

    public static void swap(ListADT<?> list, int i, int j) {
        if (i >= list.getSize() || j >= list.getSize()){
            throw new IndexOutOfBoundsException("out of bound!");
        }else{
            if (i != j){
                ListADT<Object> dummyList = (ListADT<Object>) list;
                List<Object> vals = new ArrayList<Object>();
                for (int index=0; index<list.getSize(); index++){
                    vals.add(list.get(index));
                }
                Object iVal = list.get(i);
                Object jVal = list.get(j);
                vals.set(i, jVal);
                vals.set(j, iVal);

                ListADT<Object> tmp = new ListADTImpl();
                for (int index=0; index<vals.size(); index++){
                    tmp.addBack(vals.get(index));
                }
                dummyList.setHead(tmp.getHead());
            }
        }
    }
}
