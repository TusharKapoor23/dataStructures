package datastructures;
import java.util.Scanner;
class Visitor{
    String name;
    int noOfDays;
    int priceRange;
    int roomNumber;
    int totalBill;
}
class Rooms{
    int price;
    boolean vacant;
    int roomNumber;
}
public class HotelReservation {    
    public void init(Rooms room[][][]){
        int x = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 50; k++){
                    x++;
                    room[i][j][k] = new Rooms();
                    room[i][j][k].vacant = true; 
                    room[i][j][k].roomNumber = x;
                    if(j == 0)
                        room[i][j][k].price = 1000;
                    else if(j == 1)
                        room[i][j][k].price = 2000;
                    else
                        room[i][j][k].price = 3000;
                }    
    }
    public int countVacant(Rooms room[][][],int x){ 
        int number = 0;    
        for (int i = 0; i < 2; i++)
            for (int j = x; j <= x; j++)        
                for (int k = 0; k < 50; k++){        
                    if(room[i][j][k].vacant == true)        
                        number++;
                    }    
        return number;
    }
    public int getFirstVacant(Rooms room[][][], int z){
        for (int i = 0; i < 2; i++)
            for (int j = z; j <= z+1; j++)
                for (int k = 0; k < 50; k++)
                    if(room[i][j][k].vacant == true){
                        room[i][j][k].vacant = false;
                        return room[i][j][k].roomNumber;
                    }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HotelReservation x = new HotelReservation();
        String cont = "y";
        Rooms[][][] room = new Rooms [2][3][50];
        x.init(room);
        do{
            Visitor v = new Visitor();
            System.out.println("Hello! Enter your name: ");
            v.name = s.next();
            System.out.println(v.name+" what is your price range?");
            int z;
            StringBuilder facilities = new StringBuilder();
            v.priceRange = s.nextInt();
            if (v.priceRange == 1000){
                z = 0;
                facilities.append("\nTV");
            }
            else if(v.priceRange == 2000){
                z = 1;
                facilities.append("\nTV").append("\nFridge");
            }    
            else{ 
                z = 2;
                facilities.append("\nTV").append("\nFridge").append("\nKitchen");
            }
            System.out.println("We currently have "+x.countVacant(room, z)+ " room(s) vacant.");
            System.out.println("Would you like to book the room?");
            String ans = s.next();
            if(ans.equals("y")){
                v.roomNumber = x.getFirstVacant(room, z);
                if (v.roomNumber == -1)
                    System.out.println("Unable to book room. No free rooms are available");
                else{
                    System.out.println("Your Room number = "+v.roomNumber);
                    System.out.println("How many days would like to book the room for?");
                    v.noOfDays = s.nextInt();
                    System.out.println("Your total bill will be: " + v.noOfDays * v.priceRange + ". This includes the following facilities:"+facilities);
                }
            }
            System.out.println("Do you wish to book a new Room? (y for Yes)");
            cont = s.next();
        }while(cont.equals("y"));
    }
}