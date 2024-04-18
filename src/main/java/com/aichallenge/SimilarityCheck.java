package com.aichallenge;

import org.apache.lucene.analysis.standard.ClassicTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.StringReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimilarityCheck 
{

    public static double cosineSimilarity(Map<String, Integer> vector1, Map<String, Integer> vector2) {
        Set<String> both = new HashSet<>(vector1.keySet());
        both.retainAll(vector2.keySet());
        double dotProduct = 0.0, magnitude1 = 0.0, magnitude2 = 0.0;

        for (String key : both) {
            dotProduct += vector1.get(key) * vector2.get(key);
        }
        for (String key : vector1.keySet()) {
            magnitude1 += Math.pow(vector1.get(key), 2);
        }
        for (String key : vector2.keySet()) {
            magnitude2 += Math.pow(vector2.get(key), 2);
        }
        return dotProduct / (Math.sqrt(magnitude1) * Math.sqrt(magnitude2));
    }


    public static Map<String, Integer> vectorizeString(String inputString) throws IOException 
    {
        Map<String, Integer> wordCount = new HashMap<>();
        ClassicTokenizer tokenizer = new ClassicTokenizer();
        tokenizer.setReader(new StringReader(inputString));
        tokenizer.reset();

        while (tokenizer.incrementToken()) 
        {
            String token = tokenizer.getAttribute(CharTermAttribute.class).toString();
            wordCount.put(token, wordCount.getOrDefault(token, 0) + 1);
        }

        tokenizer.end();
        tokenizer.close();

        return wordCount;
    }

    public static void main( String[] args ) throws IOException
    {
        System.out.println(vectorizeString("Hello AI Challenging World!"));
        System.out.println(cosineSimilarity(vectorizeString("Hello AI Challenging World!"),vectorizeString("The world is being challenged by AI!") ));
    }
}
