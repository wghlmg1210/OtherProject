package com.genericity;

import java.util.ArrayList;

import com.genericity.generic.GenericT;

public class GenericTest {

	public static void main(String[] args) {
		GenericT<ArrayList<Number>> generic = new GenericT<ArrayList<Number>>();
//		generic.addT(new ArrayList<String>());
//		generic.addT(new ArrayList<Integer>());
		generic.addT(new ArrayList<Number>());
	}

}
