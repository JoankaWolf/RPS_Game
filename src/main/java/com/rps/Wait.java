package com.rps;

public class Wait {

        public static void wait(int time) {
            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
}
