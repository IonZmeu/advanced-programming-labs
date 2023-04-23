package com.ionn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SharedMemory {
    private final List<Token> tokenList = new ArrayList<>();
    int matrixDimension;
    Random random = new Random();


    public SharedMemory(int matrixDimension) {
        this.matrixDimension = matrixDimension;
        for (int i = 1; i <= matrixDimension * matrixDimension * matrixDimension; i++) {
            tokenList.add(new Token(i));
        }
        Collections.shuffle(tokenList);
    }

    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokenList.isEmpty()) {
                break;
            }
            int randNumber = random.nextInt(0, tokenList.size());
            extracted.add(tokenList.get(randNumber));
            tokenList.remove(randNumber);
        }
        return extracted;
    }

}
