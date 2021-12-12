package com.java.lab.slangword;


import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * com.java.slangword
 * Created by Admin
 * Date 12/10/2021 - 9:31 AM
 * Description: ...
 */
public class Slangword {
    HashMap<String, String> map = new HashMap<>();

    /**
     * function read file in hash map
     * @throws IOException
     */
    public Slangword() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Admin\\Documents\\SlangWord\\src\\com\\java\\lab\\slangword\\slang.txt")));
        String line, str[];

        while ((line = br.readLine()) != null) {

            str = line.split("`");
            map.put(str[0], str[1]);

        }
        br.close();
    }


    public void show()
    {
        for (String i : map.keySet()) {
            System.out.println(i + "  -  " + map.get(i));
        }

    }

    public static void menu()
    {
        System.out.println("-------------------MENU-----------------");
        System.out.println("1: search by slang word");
        System.out.println("2: search by the destination");
        System.out.println("3: show history");
        System.out.println("4: add to slang word");
        System.out.println("5: edit slang word");
        System.out.println("6: delete slang word");
        System.out.println("7: reset slang word of root");
        System.out.println("8: random slang word");
        System.out.println("9: game: display slang word");
        System.out.println("10: game: display destination");
        System.out.println("0: exit");
    }

    public void searchSlang() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the key: ");
        String str = scanner.nextLine();
        if(map.get(str) != null)
            System.out.println(map.get(str));
        else
            System.out.println("Not exist!");
        BufferedWriter bout = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Documents\\SlangWord\\src\\com\\java\\lab\\slangword\\save.txt", true));
        bout.write(str);
        bout.write("\n");
        bout.close();
    }

    public void searchDestination()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the destination: ");
        String str = scanner.nextLine();
        for (String i : map.keySet()) {
            if(map.get(i).equalsIgnoreCase(str)) {
                System.out.println(i);
            }
        }
    }


    public void history() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Admin\\Documents\\SlangWord\\src\\com\\java\\lab\\slangword\\save.txt")));
        String line;
        while((line = br.readLine()) != null)
            System.out.println(line);
        br.close();
    }

    public void add()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the slang word you want to add: ");
        String str = scanner.nextLine();
        System.out.print("Enter the destination you want to add: ");
        String des = scanner.nextLine();
        if(map.containsKey(str) == true)
        {
            System.out.println("1: overwrite");
            System.out.println("2: duplicate");
            System.out.print("Enter the chosen: ");
            int number = scanner.nextInt();
            switch(number)
            {
                case 1:
                    map.put(str, des);
                    break;
                case 2:
                    map.put(str, map.get(str) + " | " + des);
                    break;

            }
        }
        else
            map.put(str, des);
    }

    public void edit()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the slang word you want to edit: ");
        String str = scanner.nextLine();
        int chosen;
        do {
            System.out.println("1: edit slang word");
            System.out.println("2: edit destination");
            System.out.print("Enter the chosen: ");
            chosen = scanner.nextInt();
        }while(chosen < 1 || chosen > 2);

        switch (chosen)
        {
            case 1:
                System.out.print("Enter slang word: ");
                String temp1 = scanner.nextLine();
                String newSlw = scanner.nextLine();
                String s = map.get(str);
                map.remove(str);
                map.put(newSlw, s);
                break;
            case 2:
                System.out.print("Enter destination: ");
                String temp2 = scanner.nextLine();
                String newDes = scanner.nextLine();
                map.remove(str);
                map.put(str, newDes);
                break;
        }
    }

    public void delete()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the slang word: ");
        String str = scanner.nextLine();
        if(map.containsKey(str) == true)
        {
            String confirm;
            do {
                System.out.print("You want to delete! - Y/N: ");
                confirm = scanner.nextLine();
            }while(!confirm.equals("y") && !confirm.equals("Y") && !confirm.equals("n") && !confirm.equals("N"));
            if(confirm.equals("y") || confirm.equals("Y")) {
                map.remove(str);
                System.out.println("Delete success!");
            }
        }
        else
            System.out.println("Slang word not exit!");
    }

    public void reset() throws IOException {
        map.clear();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Admin\\Documents\\SlangWord\\src\\com\\java\\lab\\slangword\\slang.txt")));
        String line, str[];

        while ((line = br.readLine()) != null) {

            str = line.split("`");
            map.put(str[0], str[1]);

        }
        br.close();
    }

    public void random()
    {
        Random random = new Random();
        int number = random.nextInt(map.size()), index = 0;
        for (String i : map.keySet()) {
            if(index == number) {
                System.out.println(i + "  -  " + map.get(i));
                break;
            }
            index++;
        }
    }

    public void gameSlangWord()
    {

    }
}

