package com.asante.test;

import java.util.*;

public class Index {
	Map<Integer, String> dataSources;
	HashMap<String, HashSet<Integer>> dataIndex;

	Index() {
		dataSources = new HashMap<Integer, String>();
		dataIndex = new HashMap<String, HashSet<Integer>>();
	}

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

	public List<String> get(String phrase){
		List<String> strings = new ArrayList<String>();
		HashSet<Integer> res = new HashSet<Integer>(dataIndex.get(phrase.toLowerCase()));
		res.retainAll(dataIndex.get(phrase));

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
