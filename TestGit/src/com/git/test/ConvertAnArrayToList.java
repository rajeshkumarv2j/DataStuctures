package com.jatin.ps.spoj;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertAnArrayToList {
	public static void main(String[] args) {
		
		final int[] a = {1,1,4,5,6,6,7,7,7,8,9,0};
		ArrayList<Integer> al = new ArrayList<Integer>();
		
//		1 way
		for(int i=0; i<a.length; i++){
			al.add(a[i]);
		}
		System.out.println(al);
		al.clear();
		
//		2nd way
		List<int[]> list = Arrays.asList(a);
		for(int i=0; i<list.get(0).length; i++)
		al.add(list.get(0)[i]);
		
		System.out.println(al);
		
		
//		3 rd way
		List<Integer> integers = new AbstractList<Integer>() {

			@Override
			public Integer get(int index) {
				return a[index];
			}

			@Override
			public int size() {
				return a.length;
			}
			
		};
		
		System.out.println(integers);
		
		
//		4 th way
		List<Integer> ints = PrimitiveWrapper.ofIntegers(a);
		System.out.println(ints);
	}
}

class PrimitiveWrapper<T> extends AbstractList<T>{

	private final T[] data;

    private PrimitiveWrapper(T[] data) {
        this.data = data; // you can clone this array for preventing aliasing
    }

    public static <T> List<T> ofIntegers(int[] data) {
        return new PrimitiveWrapper(toBoxedArray(Integer.class, data));
    }

    public static <T> List<T> ofCharacters(char[] data) {
        return new PrimitiveWrapper(toBoxedArray(Character.class, data));
    }

    public static <T> List<T> ofDoubles(double[] data) {
        return new PrimitiveWrapper(toBoxedArray(Double.class, data));
    }  

    // ditto for byte, float, boolean, long

    private static <T> T[] toBoxedArray(Class<T> boxClass, Object components) {
        final int length = Array.getLength(components);
        Object res = Array.newInstance(boxClass, length);

        for (int i = 0; i < length; i++) {
            Array.set(res, i, Array.get(components, i));
        }

        return (T[]) res;
    }

    @Override
    public T get(int index) {
        return data[index];
    }

    @Override
    public int size() {
        return data.length;
    }
}