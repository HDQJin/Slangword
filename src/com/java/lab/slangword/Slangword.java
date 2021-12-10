package com.java.lab.slangword;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Admin\\Documents\\19127530_Lab02\\src\\com\\java\\slangword\\slang.txt")));
        String line, str[];

        while ((line = br.readLine()) != null) {

            str = line.split("`");
            map.put(str[0], str[1]);

        }

    }


    public void show()
    {
        for (String i : map.keySet()) {
            System.out.println(i + "  -  " + map.get(i));
        }

    }

    public void searchSlang()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the key: ");
        String str = scanner.nextLine();
        System.out.println(map.get(str));
    }
}
