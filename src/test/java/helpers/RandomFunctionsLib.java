package helpers;

import java.util.Random;

public class RandomFunctionsLib {

    public static String getRandomLetterString(int targetStringLength){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static float getRandomFloat(){
        Random random = new Random();
        return random.nextFloat();
    }

    public static int getRandomInt(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }
}
