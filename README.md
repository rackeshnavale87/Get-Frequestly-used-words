Name: R N
# Max-Freq-Word-Sorting-Java-Code
Max-Freq-Word-Sorting-Java-Code

- <b>High level algorithm:</b><br>
Word seperation based on different delimiter such as ",/,[,],'... & Case IN-sensitive.<br>
1) Open document <br>
2) Use Map and List to seperate the words. O(K) TC consideirng K distinct words.<br>
3) If the word already exists in teh List, increment the count of frequency. else new word. constant TC<br>
4) Use Collection to sort the list on the basis of frequency of usage.  n*log(n) TC.<br>
5) Print the list & Entry.getKey (max count word) & its Entry.getValue (max count)<br>

- <b>NOTE:</b><br>
TopK.java : this program contains MultiMap collection (Google Guava lib JAR) so that the same frequency count words are stored together, this will decrease the time complexity required to sort the Map. The important thing for sorting is Frequency which is unique number in MultiMap collection

- <b>Java Code with: </b><br>
Collection adn Map which solving this problem statement with easy operations and efficiently.
In program Collection sorting algorithm is a modified mergesort (in which the merge is omitted if the highest element in the low sublist is less than the lowest element in the high sublist). This algorithm offers guaranteed <b>n log(n)</b> performance. The specified list must be modifiable, but need not be resizable. This implementation dumps the specified list into an array, sorts the array, and iterates over the list resetting each element from the corresponding position in the array. This avoids the n^2*log(n) performance that would result from attempting to sort a linked list in place.<br>
The string tokenizer class allows an application to break a string into tokens. The tokenization method is much simpler than the one used by the StreamTokenizer class.<br>

- <b>Time Complexity:</b><br>
Collection .sort() = n*log(n) TC<br>
The number of distinct word will be much more smaller than compared to the total count of words in the document. so this will result in the time complexity = <b>n*log(n)</b>
