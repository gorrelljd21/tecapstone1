package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {

        String[] mainMenu = {"[1] Display Items", "[2] Purchase", "[3] Exit"};

        Scanner userInput = new Scanner(System.in);

        System.out.println("Please make a selection by number: ");
        for(int i = 0; i < mainMenu.length; i++){
            System.out.println(mainMenu[i]);
        }
//        int userSelection = Integer.parseInt(userInput.nextLine());

    }

}
