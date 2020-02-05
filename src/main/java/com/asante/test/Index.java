package com.asante.test;

import java.util.*;

/**
 * La clase parse una lista de strings para luego indexar sus palabras de modo inverso
 * 
 * @author mcamelli
 *
 */
public class Index {
	Map<Integer, String> dataSources;
	HashMap<String, HashSet<Integer>> dataIndex;

	Index() {
		dataSources = new HashMap<Integer, String>();
		dataIndex = new HashMap<String, HashSet<Integer>>();
	}

	/**
	 * 
	 * @param strings Array de strings como input de la app
	 */
	public void buildIndex(String[] strings) {
		int i = 0;
		for (String dataString : strings) {

			dataSources.put(i, dataString);

			String[] words = dataString.split("\\W+");
			for (String word : words) {
				word = word.toLowerCase();
				if (!dataIndex.containsKey(word))
					dataIndex.put(word, new HashSet<Integer>());
				dataIndex.get(word).add(i);
			}
			i++;
		}
	}

	/**
	 * 
	 * @param pattern patron de busqueda
	 * 
	 * @return lista de strings donde se encontro el patron de busqueda
	 */
	public List<String> get(String pattern){
		List<String> strings = new ArrayList<String>();
		HashSet<Integer> res = new HashSet<Integer>(dataIndex.get(pattern.toLowerCase()));
		res.retainAll(dataIndex.get(pattern));

        if(res.size()==0) {
            return null;
        }
        
        System.out.println("Pattern found: ");
        for(int num : res){
        	strings.add(dataSources.get(num));
        }
        
        return strings;
    }
}
