import java.util.ArrayList;

public class CoffeeMachine {

    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;
    private String state = "action";

    public void print(String text){
        System.out.println(text);
    }

    public void printState(){
        print("The coffee machine has:");
        print(water + " ml of water");
        print(milk + " ml of milk");
        print(beans + " g of coffee beans");
        print(cups + " disposable cups");
        print("$" + money + " of money");
    }

    public ArrayList<String> canMake(int water, int milk, int beans){
        ArrayList<String> notEnough = new ArrayList<>();
        if (this.water < water) notEnough.add("water");
        if (this.milk < milk) notEnough.add("milk");
        if (this.beans < beans) notEnough.add("beans");
        if (this.cups < 1) notEnough.add("cups");
        return notEnough;
    }

   

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    
    public void operate(String command){
        print("\nCurrent state is " + getState() + "\n");

        if (getState().equals("action")){
            if (command.equals("buy")){
                print("Choose coffe: 1, 2, 3.");
                setState("buy");
                return;
            }
            else if (command.equals("fill")){
                print("How much water?");
                setState("water");
                return;
            }
            else if (command.equals("take")){
                print("I take your money!");
                setMoney(0);
            }
            else if (command.equals("remaining")){
                printState();
            }
            else print("The state is "+ getState() + ", so the command "+command+" is not valid!\n");
        }
        else if (getState().equals("buy")){
            int commandNum = Integer.parseInt(command);
            if (commandNum == 1){
                ArrayList<String> notEnough = canMake(250, 0, 16);
                if (notEnough.isEmpty()){
                    water -= 250; beans -= 16; cups -=1; money += 4;
                    print("Yes we can make it!");
                }
                else {
                    print("You dont have enough of " + String.join(", ", notEnough));
                }
            }
            else if (commandNum == 2){
                ArrayList<String> notEnough = canMake(350, 75, 20);
                if (notEnough.isEmpty()){
                    water -= 350; milk -= 75; beans -= 20; cups -=1; money += 7;
                    print("Yes we can make it!");
                }
                else {
                    print("You dont have enough of " + String.join(", ", notEnough));
                }
            }
            else if (commandNum == 3){
                ArrayList<String> notEnough = canMake(200, 100, 12);
                if (notEnough.isEmpty()){
                    water -= 200; milk -= 100; beans -= 12; cups -=1; money += 6;
                    print("Yes we can make it!");
                }
                else {
                    print("You dont have enough of " + String.join(", ", notEnough));
                }
            }
            else {
                print("Invalid choice!");
            }
            setState("action");
        }
        else if (getState().equals("water")){
            water += Integer.parseInt(command);
            setState("milk");
            print("how much milk?");
            return;
        }
        else if (getState().equals("milk")){
            milk += Integer.parseInt(command);
            setState("beans");
            print("how much beans?");
            return;
        }
        else if (getState().equals("beans")){
            beans += Integer.parseInt(command);
            setState("cups");
            print("how many cups?");
            return;
        }
        else if (getState().equals("cups")){
            cups += Integer.parseInt(command);
            setState("action");
            return;
        }
        else {
            print("Not a valid command!");
        }
    }
}

// else if X change to case, enum.