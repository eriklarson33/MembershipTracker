/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmembership.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author eriklarson-laptop
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner kb = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.println(prompt);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.println(prompt);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public float readFloat(String prompt) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.println(prompt);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.println(prompt);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + 
                            min + " and " + max + ".");
                    failed = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public int readInt(String prompt) {
        boolean failed;
        int ret = 0;

        do {
            failed = false;
            System.out.println(prompt);
            try {
                ret = kb.nextInt();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.println(prompt);
            try {
                ret = kb.nextInt();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + min + " and "
                            + max + ".");
                    failed = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public long readLong(String prompt) {
        boolean failed;
        long ret = 0;
        do {
            failed = false;
            System.out.println(prompt);
            try {
                ret = kb.nextLong();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        boolean failed;
        long ret = 0;
        do {
            failed = false;
            System.out.println(prompt);
            try {
                ret = kb.nextLong();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + min
                            + " and " + max + ".");
                    failed = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return kb.nextLine();
    }

}
