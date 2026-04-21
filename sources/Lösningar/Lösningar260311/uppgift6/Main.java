package uppgift6;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        String[] text = {"hej", "hej", "hej", "hej", "hej", "hej", "på", "på", "på", "dig", "dig", "har", "har", "har", "har", "du", "du", "du", "på", "på", "på", "dig",
                "mobilen", "har", "har", "har", "du", "du", "på", "på", "på", "dig", "dig", "dig", "allt"};
        System.out.println(mostRepeated(text));
    }

    static String mostRepeated(String[] text){
        int nrMost=0,nrRepeats=0;
        String mostWord="",lastWord="";
        HashMap<String,Integer> map = new HashMap<>();
        for(String word:text){
            if(word.equals(lastWord)){
                nrRepeats++;
                if(nrRepeats==3) {
                    if (map.containsKey(word))
                        map.put(word, map.get(word) + 1);
                    else
                        map.put(word, 1);
                    if(map.get(word)>nrMost){
                        nrMost=map.get(word);
                        mostWord=word;
                    }
                }
            }else{
                lastWord=word;
                nrRepeats=1;
            }
        }
        return mostWord;
    }
}