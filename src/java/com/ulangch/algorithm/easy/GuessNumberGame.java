package com.ulangch.algorithm.easy;

class GuessGame {
    static int supposed = 67;
    int guess(int num) {
        if (supposed < num) {
            return 1;
        }
        if (supposed > num) {
            return -1;
        }
        return 0;
    }
}

public class GuessNumberGame extends GuessGame{
    public int guessNumber(int n) {
        int m = n;
        while (true) {
            int cmp = guess(m);
            if (cmp == 0) {
                return m;
            } else if (cmp > 0) {
                m = m / 2;
            } else {
                m = m + m / 2;
            }
        }
    }
    public static void main(String[] args) {
        GuessNumberGame game = new GuessNumberGame();
        System.out.println(game.guessNumber(100));
    }
}
