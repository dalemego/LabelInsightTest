package labelinsighttest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test cases already defined in the main method. Please modify speed or init parameters if needed and use them through
 * the printStringArray method which will invoke the animate() method.
 *
 * Junit test cases provided in the test folder.
 */
public class Animation {

    public static void main(String[] args) {
        int speed0 = 2;
        String init0 = "..R....";
        int speed1 = 3;
        String init1 = "RR..LRL";
        int speed2 = 2;
        String init2 = "LRLR.LRLR";
        int speed3 = 10;
        String init3 = "RLRLRLRLRL";
        int speed4 = 1;
        String init4 = "...";
        int speed5 = 1;
        String init5 = "LRRL.LR.LRR.R.LRRL.";

        System.out.println("Test 0:");
        printStringArray(speed0, init0);
        System.out.println("Test 1:");
        printStringArray(speed1, init1);
        System.out.println("Test 2:");
        printStringArray(speed2, init2);
        System.out.println("Test 3:");
        printStringArray(speed3, init3);
        System.out.println("Test 4:");
        printStringArray(speed4, init4);
        System.out.println("Test 5:");
        printStringArray(speed5, init5);
    }

    /**
     * Auxiliary method to print the String array lines from the main() method
     * @param speed number of positions to be moved per instant
     * @param init starting position of the particles
     */
    private static void printStringArray(int speed, String init) {
        String[] result = animate(speed,init);

        for(String line : result) {
            System.out.println(line);
        }
    }

    /**
     * Method to invoke the necessary logic to map the state of particles for each instant until chamber is cleared.
     * @param speed number of positions to be moved per instant
     * @param init starting position of the particles
     * @return String[] array representing the position of particles until chamber is cleared.
     */
    public static String[] animate(int speed, String init) {
        int n = init.length();
        char[] particles = init.toCharArray();
        boolean empty = false;
        List<char[]> resultList = new ArrayList<>();
        int partCount = 0;

        //save initial state
        char[] start = new char[n];
        for(int i = 0 ; i<n ; i++) {
            if(particles[i] != '.') {
                start[i] = 'X';
                partCount++;
            }
            else {
                start[i] = '.';
            }
        }
        resultList.add(start);
        //if there are no particles we can skip the while loop
        if(partCount == 0) {
            empty = true;
        }
        //iterate over particles state array
        while(!empty) {
            char[] line = new char[n];
            char[] mappedLine = new char[n];

            for(int i = 0 ; i<n ; i++) {
                //M letter is used to identify two particles overlap
                if(particles[i] == 'M') {
                    move(line, i, speed, true);
                    move(line,i,speed,false);
                }
                if(particles[i] == 'L' && (i-speed) >= 0) {
                    move(line,i,speed,true);
                    if(!isOverlap(line,i)) {
                        line[i] = '.';
                    }
                }
                else if(particles[i] == 'R' && (i+speed) < n) {
                    move(line,i,speed,false);
                    if(!isOverlap(line,i)) {
                        line[i] = '.';
                    }
                }
                else if(line[i] != 'L' && line[i] != 'R'){
                    line[i] = '.';
                }
            }
            //set the particles array to its current state
            particles = line;

            //iterate over the line to map X and dots
            int count = 0;
            for(int i = 0 ; i< n; i++) {
                if(line[i] == '.') {
                    mappedLine[i] = '.';
                }
                else {
                    mappedLine[i] = 'X';
                    count++;
                }
            }
            //using an ArrayList as we don't know how many steps will get to clear the chamber
            resultList.add(mappedLine);

            //if X count is zero it means the chamber is empty already
            if(count == 0) {
                empty = true;
            }
        }
        //converting back to a String array as it is required by the exercise.
        String[] result = new String[resultList.size()];
        for(int i = 0 ; i < resultList.size() ; i++) {
            result[i] = Arrays.toString(resultList.get(i));
        }
        return result;
    }

    /**
     * Method to identify if the positions is already set to a value which will overlap two particles.
     * @param line character array containing the current state of particles in the chamber
     * @param i current position in the array
     * @return true if position at i is already set. Otherwise, false.
     */
    private static boolean isOverlap(char[] line, int i) {
        return line[i] == 'L' || line[i] == 'R';
    }

    /**
     * Method handling the logic for moving particles either to the left or right
     * @param line character array containing the current state of particles in the chamber
     * @param i current position in the array
     * @param speed initial parameter for the number of positions to move per instant
     * @param left true if the move is to the left. Otherwise false.
     */
    private static void move(char[] line, int i, int speed, boolean left) {
        if(left) {
            //Validates if there is this index is already set, if so, will mark as overlap.
            if(line[i-speed] == 'L' || line[i-speed] == 'R') {
                line[i-speed] = 'M';
            }
            else {
                line[i-speed] = 'L';
            }
        }
        else  {
            //Validates if there is this index is already set, if so, will mark as overlap.
            if(line[i+speed] == 'L' || line[i+speed] == 'R') {
                line[i+speed] = 'M';
            }
            else {
                line[i+speed] = 'R';
            }
        }
        //if position is not set already then set to empty
        if(line[i] != 'L' && line[i] != 'R') {
            line[i] = '.';
        }
    }

}
