package com.java.lab.slangword;

import java.io.IOException;
import java.util.Scanner;

/**
 * com.java.slangword
 * Created by Admin
 * Date 12/10/2021 - 9:30 AM
 * Description: ...
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Slangword s = new Slangword();
        Scanner scanner = new Scanner(System.in);
        int chosen, exit = 0;
        while(true) {
            s.menu();
            do {
                System.out.print("Enter the chosen: ");
                chosen = scanner.nextInt();
            }while(chosen < 0 || chosen > 11);

            switch (chosen)
            {
                case 0:
                    System.out.println("You exited!");
                    exit = 1;
                    break;
                case 1:
                    s.searchSlang();
                    break;
                case 2:
                    s.searchDestination();
                    break;
                case 3:
                    s.history();
                    break;
                case 4:
                    s.add();
                    break;
                case 5:
                    s.edit();
                    break;
                case 6:
                    s.delete();
                    break;
                case 7:
                    s.reset();
                    break;
                case 8:
                    s.random();
                    break;
//                case 9:
//
//                    break;
//                case 10:
//
//                    break;

            }
            if(exit == 1)
                break;
        }

    }

}
