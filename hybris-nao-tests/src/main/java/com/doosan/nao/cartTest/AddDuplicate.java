package com.doosan.nao.cartTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.MultiValueMap;

import com.google.common.base.Objects;

public class AddDuplicate {
	public static void main(String[] args) {
		String item="85D10,85D10,6988097,85D10,6684577";
		String binl="bin1,bin2,bin1,bin4,bin5,bin1,bin2,bin1,bin4,bin5";
		String qt="1,2,1,2,1,1,3,4,1,1";
		/*String it[]=binl.split(",");
		String bnl[]=binl.split(",");
		String qty[]=qt.split(",");
		
		Map<String, String> m=new HashMap<>();
		Map<String, Integer> b=new HashMap<>();
		for(int i=0;i<it.length;i++) {
			if(m.containsKey(it[i])) {
				m.put(it[i],m.get(it[i])+qty[i]);
				b.put(it[i], b.get(it[i])+Integer.valueOf(qty[i]));
			}else {
				m.put(it[i], qty[i]);
				b.put(it[i], Integer.valueOf(qty[i]));
			}
		}
		System.out.println(m);
		System.out.println(b);
	//	System.out.println(m+"\n"+b);
	}
		*/
		
		
	//	Map<Integer, List<String>> ma1p = new LinkedHashMap< Integer, List<String>>();
		//{6677830=[Bin], 85D10=[Bin2, Bin2, Bin], 6679836=[Bin1, Bin]}
		//{6677830=[5], 85D10=[2, 1, 4], 6679836=[1, 2]}
		
		List list;
        MultiValueMap map = new MultiValueMap();
        map.put("85D10", 4);
        map.put("6677830", 6);
        map.put("85D10", 7);
        map.put("6679836", 1);
        map.put("6679836", 9);
        map.put("85D10", 5);
        MultiValueMap mapqt = new MultiValueMap();
        mapqt.put("85D10", "Bin2");
        mapqt.put("6677830", "Bin");
        mapqt.put("85D10", "Bin2");
        mapqt.put("6679836", "Bin");
        mapqt.put("6679836", "Bin1");
        mapqt.put("85D10", "Bin");
        Set<String> keys = map.keySet();
        Set<String> keysqty = mapqt.keySet();
        List<String>liste=new ArrayList<>(keys);
        List<String>listqty=new ArrayList<>(keysqty);
        // iterate through the key set and display key and value
        for(int i=0;i<liste.size();i++) {
        	System.out.println("Key map"+liste.get(i));
        	System.out.println("Key Value"+map.get(liste.get(i)));
        	System.out.println("Key mapqty"+listqty.get(i));
        	System.out.println("Key qty Value"+mapqt.get(listqty.get(i)));
        List<Object>bin=new ArrayList();
        List<Object>lvaue=new ArrayList();
        bin=(List<Object>)mapqt.get(listqty.get(i));
        	System.out.println("Get values "+bin);
        	lvaue=(List<Object>) map.get(liste.get(i));
        	String w=String.valueOf(map.get(liste.get(i)));
        	System.out.println(" String value"+w);
        	for (Object string : lvaue) {
				System.out.println(Integer.parseInt(string.toString()));
			}
        	
        }
        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + map.get(key) + "n");
        }
       for (String string : keysqty) {
		
	}
System.out.println(map);
System.out.println(mapqt);

}
	
}
