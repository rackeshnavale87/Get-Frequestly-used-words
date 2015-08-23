package Topk;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class Words
{
	int count=1;
	String word;
	Words(int count, String word)
	{
		this.count = count;
		this.word = word;
	}
}

public class TopK 
{
	public static void main(String argv[]) throws IOException
	{
		int Tcount = 0;
		Map<String,Integer> map = new TreeMap<String,Integer>();
		BufferedReader br = new BufferedReader(new FileReader("text.txt"));
		String line;
		while((line = br.readLine())!=null)
		{
			//System.out.println(line);
			String[] words = line.split("\\W");
			for(String word:words)
			{
				word = word.toLowerCase();
				Tcount++;
				if(word.equals(" ")||word.equals(",")||word.equals("")||word.equals(":"))
					continue;
				insert(word,map);
			}
		}				
		Multimap<Integer, String> mm = ArrayListMultimap.create();
		Iterator<String> itr = map.keySet().iterator();
		while(itr.hasNext())
		{
			String key = (String) itr.next();
			int tempi = map.get(key);
			String temps = key;
			mm.put(tempi,temps);
			//System.out.println("Key :"+i+", Value :"+ mm.get(i));
		}
		
		Map<String,Integer> fmap = new HashMap<String,Integer>();
		Set<Integer> keys = mm.keySet();
		for(int i : keys)
		{
			int value = i;
			String temps = (mm.get(i).toString());
			fmap.put(temps,value);
		}
		
		List<Entry<String, Integer>> wordList =  sorting(fmap);
		display(wordList,Tcount);
		br.close();
	}
	
	// INSERTING INTO THE MAP////////////////////////////////////////////////////////////////////////////////////////////////
	private static void insert(String word, Map<String, Integer> map) 
	{
		if(map.containsKey(word))
		{
			int temp = map.get(word);
			temp++;
			map.put(word, temp);
		}
		else
		{
			map.put(word, 1);
		}
	}
	
	// SORTING METHOD/////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static List<Entry<String, Integer>> sorting(Map<String, Integer> fmap) 
	{
		Set<Entry<String, Integer>> wordSet = fmap.entrySet();
        List<Entry<String, Integer>> wordList = new ArrayList<Entry<String, Integer>>(wordSet);
        
        Collections.sort(
	        				wordList, 
	        				new Comparator<Map.Entry<String, Integer>>()
					        {
					            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
					            {
					            	return (o2.getValue()).compareTo( o1.getValue() );
					            }
					        }
        				);		
		return wordList;
	}

	// DISPLAY METHOD/////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void display(List<Entry<String, Integer>> wordList, int tcount) 
	{
		// Display all the words & count ---------------------------------------------------------------------------------------
    	for(Map.Entry<String, Integer> entry:wordList) // for every word search the frequency
    	{
    		System.out.println(entry.getValue()+": "+entry.getKey());
        }
    	// Top frequently used word --------------------------------------------------------------------------------------------
    	Entry<String, Integer> max = wordList.get(0);
		System.out.println("-------------------------------------------------------------------------------------------");
    	System.out.println("Maximum frueqncy word - ["+ max.getKey()+"] : "+max.getValue()+" times.");
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("Total words : "+tcount);	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
