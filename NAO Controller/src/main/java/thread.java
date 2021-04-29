/*
 * Multithreading oefening code
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 28-04-2021
 * Edit Date:  28-04-2021
 */

// Don't use for robot!


class two implements Runnable
{
    public void run() {

        for (int j = 0; j < 5; j++) {
            System.out.println("B");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class One {
    public static void main(String[] args) throws InterruptedException {

        int a = 10;
        two t = new two();
        Thread thread = new Thread(t);

        thread.start(); // You may see this as starting a second Main, it wil run together with the original Main.

        for (int i = 0; i < 5; i++) {
            System.out.println("A");
            Thread.sleep(100);
        }
    }
}

/*
Sleeps have been added to show that the two loops are in fact running together.
 */
