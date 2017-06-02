package main;

import sun.net.www.content.text.Generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by developer on 02/06/17.
 */
public class GenericMethod {
    public static <T> boolean areTwins(T... arr) {
        List<T> list= new ArrayList<T>();
        T first = arr[0];
        for (T el:arr) {
            if (!first.equals(el)) {
                return false;
            }
        };
        return true;
    }

    public static <U,T> List<U> returnSiblings(List<T> list,U instance) {
        List<U> siblings = new ArrayList<U>();
        for (T elem: list) {
            if (instance.getClass().equals(elem.getClass())) {
                siblings.add((U) elem);
            }
        }
        return siblings;
    }

    public static <T> boolean areTwins(List<T> list) {
        T first = list.get(0);
        for (T el:list) {
            if (!first.equals(el)) {
                return false;
            }
        };
        return true;
    }

    public static <T> boolean areTwinsWIthoutForEach(List<T> list) {
        T first = list.get(0);
        for (Iterator<T> it = list.iterator(); it.hasNext();) {
            if (!first.equals(it.next())) {
                return false;
            }
        };
        return true;
    }

    public static <T> List<T> toList(T... arr) {
        List<T> list= new ArrayList<T>();
        for (T el:arr) list.add(el);
        return list;
    }
    public static void main(String [] args) {
        List ints = GenericMethod.<Number>toList(2,2,2,2.3);
        System.out.println(ints.get(2).getClass());
        System.out.println(GenericMethod.areTwins(2,2,3));
        System.out.println(GenericMethod.areTwinsWIthoutForEach(ints));
        System.out.println(GenericMethod.areTwins(ints));
        System.out.println(GenericMethod.returnSiblings(ints,2));
    }

}
