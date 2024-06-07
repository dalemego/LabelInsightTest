package labelinsighttest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimationTest {

    final String[] expected0 = new String[]{"[., ., X, ., ., ., .]",
                                            "[., ., ., ., X, ., .]",
                                            "[., ., ., ., ., ., X]",
                                            "[., ., ., ., ., ., .]"};

    final String[] expected1 = new String[]{"[X, X, ., ., X, X, X]",
                                            "[., X, ., X, X, ., .]",
                                            "[X, ., ., ., ., ., X]",
                                            "[., ., ., ., ., ., .]"};

    final String[] expected2 = new String[]{"[X, X, X, X, ., X, X, X, X]",
                                            "[X, ., ., X, ., X, ., ., X]",
                                            "[., X, ., X, ., X, ., X, .]",
                                            "[., X, ., ., ., ., ., X, .]",
                                            "[., ., ., ., ., ., ., ., .]"};

    final String[] expected3 = new String[]{"[X, X, X, X, X, X, X, X, X, X]",
                                            "[., ., ., ., ., ., ., ., ., .]"};

    final String[] expected4 = new String[]{"[., ., .]"};

    final String[] expected5 = new String[]{"[X, X, X, X, ., X, X, ., X, X, X, ., X, ., X, X, X, X, .]",
                                            "[., ., X, X, X, ., ., X, ., ., X, X, ., X, ., ., X, X, .]",
                                            "[., X, ., X, X, ., X, ., X, ., ., X, X, ., X, X, ., X, X]",
                                            "[X, ., X, ., X, X, ., ., ., X, ., X, X, X, X, X, ., ., X]",
                                            "[., X, ., ., X, X, X, ., ., ., X, ., ., X, X, ., X, ., .]",
                                            "[X, ., ., X, ., ., X, X, ., X, ., X, X, ., X, X, ., X, .]",
                                            "[., ., X, ., ., ., ., X, X, ., ., X, X, ., ., X, X, ., X]",
                                            "[., X, ., ., ., ., ., X, X, X, X, ., ., X, ., ., X, X, .]",
                                            "[X, ., ., ., ., ., X, ., ., X, X, ., ., ., X, ., ., X, X]",
                                            "[., ., ., ., ., X, ., ., X, ., X, X, ., ., ., X, ., ., X]",
                                            "[., ., ., ., X, ., ., X, ., ., ., X, X, ., ., ., X, ., .]",
                                            "[., ., ., X, ., ., X, ., ., ., ., ., X, X, ., ., ., X, .]",
                                            "[., ., X, ., ., X, ., ., ., ., ., ., ., X, X, ., ., ., X]",
                                            "[., X, ., ., X, ., ., ., ., ., ., ., ., ., X, X, ., ., .]",
                                            "[X, ., ., X, ., ., ., ., ., ., ., ., ., ., ., X, X, ., .]",
                                            "[., ., X, ., ., ., ., ., ., ., ., ., ., ., ., ., X, X, .]",
                                            "[., X, ., ., ., ., ., ., ., ., ., ., ., ., ., ., ., X, X]",
                                            "[X, ., ., ., ., ., ., ., ., ., ., ., ., ., ., ., ., ., X]",
                                            "[., ., ., ., ., ., ., ., ., ., ., ., ., ., ., ., ., ., .]"};
    @Test
    void testAnimationString0() {
        String[] result = Animation.animate(2, "..R....");
        assertArrayEquals(expected0,result);
    }

    @Test
    void testAnimationString1() {
        String[] result = Animation.animate(3, "RR..LRL");
        assertArrayEquals(expected1,result);
    }

    @Test
    void testAnimationString2() {
        String[] result = Animation.animate(2, "LRLR.LRLR");
        assertArrayEquals(expected2,result);
    }

    @Test
    void testAnimationString3() {
        String[] result = Animation.animate(10, "RLRLRLRLRL");
        assertArrayEquals(expected3,result);
    }

    @Test
    void testAnimationString4() {
        String[] result = Animation.animate(1, "...");
        assertArrayEquals(expected4,result);
    }

    @Test
    void testAnimationString5() {
        String[] result = Animation.animate(1, "LRRL.LR.LRR.R.LRRL.");
        assertArrayEquals(expected5,result);
    }

}