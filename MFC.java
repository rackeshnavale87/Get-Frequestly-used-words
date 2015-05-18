package pkg;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class MFC 
{     
    public Map<String, Integer> getMaxFreqOfWord(String document)
    {
    	int Twords=0,Dwords=0;
        FileInputStream FileInputPtr = null;
        DataInputStream DataInputPtr = null;
        BufferedReader bufferR = null;
        
        Map<String, Integer> WordOnMap = new HashMap<String, Integer>();
        
        try 
        {
            FileInputPtr = new FileInputStream(document);
            DataInputPtr = new DataInputStream(FileInputPtr);
            bufferR = new BufferedReader(new InputStreamReader(DataInputPtr));
            String ReadLine = null;       
            
            while((ReadLine = bufferR.readLine()) != null)
            {
                StringTokenizer delimiter = new StringTokenizer(ReadLine, " /,.;,:,\\\",[,],{,},?,(,),!,-,—,\t//\n,/\0,',");
                while(delimiter.hasMoreTokens())
                {
                    String Temp = delimiter.nextToken().toLowerCase();
                    if(WordOnMap.containsKey(Temp))
                    {
                        WordOnMap.put(Temp, WordOnMap.get(Temp)+1); // existing word, increment count
						Twords++;
                    } 
                    else 
                    {
                        WordOnMap.put(Temp, 1); // new word
                        Dwords++;
                        Twords++;
                    }
                }
            }
        } 
        catch (FileNotFoundException err) 
        {
            err.printStackTrace();
        } 
        catch (IOException err) 
        {
            err.printStackTrace();
        } 
        finally
        {
            try
            {
            	if(bufferR != null) bufferR.close();
            }
            catch(Exception ex)
            {
            	
            }
        }
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("There are total "+Twords+" in the document & "+Dwords+" distinct words (case in-sensitive)");
		System.out.println("Count : Word");
		System.out.println("-------------------------------------------------------------------------------------------");
        return WordOnMap;
    }
 
    public static void main(String args[])
	{
    	MFC maxWF = new MFC();
    	Entry<String, Integer> max;
    	Map<String, Integer> WordOnMap = maxWF.getMaxFreqOfWord("doc.txt"); // get document text to map
 
// Sort all the distinct words on the frequency count------------------------------------------------------------------  	
    	Set<Entry<String, Integer>> wordSet = WordOnMap.entrySet();
        List<Entry<String, Integer>> wordList = new ArrayList<Entry<String, Integer>>(wordSet);
        Collections.sort( wordList, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {return (o2.getValue()).compareTo( o1.getValue() );}
        } );

// Display all the words & count ---------------------------------------------------------------------------------------
    	for(Map.Entry<String, Integer> entry:wordList) // for every word search the frequency
    	{
    		System.out.println(entry.getValue()+": "+entry.getKey());
        }
    	
// Top frequently used word --------------------------------------------------------------------------------------------
    	max = wordList.get(0);
		System.out.println("-------------------------------------------------------------------------------------------");
    	System.out.println("Maximum frueqncy word - ["+ max.getKey()+"] : "+max.getValue()+" times.");
		System.out.println("-------------------------------------------------------------------------------------------");
    }
}
