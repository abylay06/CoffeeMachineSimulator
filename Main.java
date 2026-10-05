import java.util.Scanner;

public class Main {
    
    public static void print(String text){
        System.out.println(text);
    }
    public static void main(String[] args){

        // while (true){
            
        //     Scanner sc = new Scanner(System.in);

        //     print("\nWrite action (buy, fill, take, remaining, exit):");
        //     String action = sc.next();
            
        //     if (action.equals("buy")){
        //         print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        //         int choice = sc.nextInt();
        //         if (choice == 1){
        //             if (water >= 250 && beans >= 16){
        //                 water -= 250; beans -= 16; cups -= 1; money += 4;
        //                 print("Yes we can make it!");
        //             }
        //             else {
        //                 print("Not enough ingredients!");
        //             }
        //         }
        //         else if (choice == 2){
        //             if (water >= 350 && milk >= 75 && beans >= 20){
        //                 water -= 350; milk -= 75; beans -= 20; cups -= 1; money += 7;
        //                 print("Yes we can make it!");
        //             }
        //             else {
        //                 print("Not enough ingredients!");
        //             }
        //         }
        //         else if (choice == 3){
        //             if (water >= 200 && milk >= 100 && beans >= 12){
        //                 water -= 200; milk -= 100; beans -= 12; cups -= 1; money += 6;
        //                 print("Yes we can make it!");
        //             }
        //             else {
        //                 print("Not enough ingredients!");
        //             }
        //         }
        //         else print("Invalid choice!");
                
        //     }
        //     else if (action.equals("fill")){
        //         print("Water to add:");
        //         water += sc.nextInt();
        //         print("Milk to add:");
        //         milk += sc.nextInt();
        //         print("Beans to add:");
        //         beans += sc.nextInt();
        //         print("Cups to add");
        //         cups += sc.nextInt();
        //     }
        //     else if (action.equals("take")){
        //         print("I gave you $" + money);
        //         money = 0;
        //     }
        //     else if (action.equals("remaining")){
        //         printState(water, milk, beans, cups, money);
        //     }
        //     else if (action.equals("exit")){
        //         sc.close();
        //         break;
        //     }
        //     else print("Incorrect action command!");
        // }

        CoffeeMachine machine = new CoffeeMachine();
        // scanner outside to not create scanner everytime.
        Scanner sc = new Scanner(System.in); 
        while (true){
            if (machine.getState().equals("action")) {
                System.out.println("\nWrite action (buy, fill, take, remaining, exit)");
            }
            String action = sc.next();
            
            if (action.equals("exit")){break;}
            
            machine.operate(action);
        }
    }
}