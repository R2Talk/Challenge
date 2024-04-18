package com.aichallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SimilarityCheckTest {

    @Test
    public void testCosineSimilarity() {
        Map<String, Integer> vector1 = new HashMap<>();
        vector1.put("Hello", 1);
        vector1.put("AI", 1);
        vector1.put("Challenging", 1);
        vector1.put("World!", 1);

        Map<String, Integer> vector2 = new HashMap<>();
        vector2.put("The", 1);
        vector2.put("world", 1);
        vector2.put("is", 1);
        vector2.put("being", 1);
        vector2.put("challenged", 1);
        vector2.put("by", 1);
        vector2.put("AI!", 1);

        double expectedSimilarity = 0;
        double actualSimilarity = SimilarityCheck.cosineSimilarity(vector1, vector2);

        assertEquals(expectedSimilarity, actualSimilarity, 0.0001);
    }

    @Test
    public void testVectorizeString() throws IOException {
        String inputString = "Hello AI Challenging World!";
        Map<String, Integer> expectedVector = new HashMap<>();
        expectedVector.put("Hello", 1);
        expectedVector.put("AI", 1);
        expectedVector.put("Challenging", 1);
        expectedVector.put("World", 1);

        Map<String, Integer> actualVector = SimilarityCheck.vectorizeString(inputString);

        assertEquals(expectedVector, actualVector);
    }
}