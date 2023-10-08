import java.util.ArrayList;
import java.util.Scanner;

class Mythread extends Thread{
    int count = 0;

    void message(){
        list_updated();
    }
    void list_updated(){
        System.out.println("List has been updated... Thread : "+count);

    }    @Override
    public void run() {


        System.out.println("Thread has been started wait for 2 seconds.... Thread : "+count);

        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        }
    }
}
class Bird{
    String bird_name;
    int bird_price;
    String color;

    static ArrayList<String> name_list = new ArrayList<>();
    static ArrayList<Integer> price_list = new ArrayList<>();
    static ArrayList<String> color_list = new ArrayList<>();

    void buy_bird(){
        System.out.println();
        System.out.println("\n═════════════════════════════════════════════════════   \n");
        System.out.println(" Sr.no \t\t Bird name \t\t Bird price \t\t Bird color");
        System.out.println();
        for (int i = 0; i < name_list.size(); i++) {
            System.out.println(" " + i + " \t\t\t " + name_list.get(i) + " \t\t\t " + price_list.get(i) + " \t\t\t " + color_list.get(i));
        }
        System.out.println("\n═════════════════════════════════════════════════════   \n");

        Scanner sc1 =  new Scanner(System.in);
        System.out.println("Enter the bird name : ");
        bird_name = sc1.next();
        System.out.println("Enter the bird price : ");
        bird_price = sc1.nextInt();
        System.out.println("Enter the bird color : ");
        color = sc1.next();

        if(name_list.contains(bird_name) && price_list.contains(bird_price) && color_list.contains(color)){
            int index = name_list.indexOf(bird_name);
            name_list.remove(index);
            price_list.remove(index);
            color_list.remove(index);
            System.out.println("Bird removed from the list.");
        }else {
            System.out.println("Invalid information");
        }
    }
    void sell_bird() {
        System.out.println("\n═════════════════════════════════════════════════════   \n");
        System.out.println("Bird Requirement : ");
        System.out.println("Bird name : Bird price : Bird color\n");
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the bird name : ");
        bird_name = sc1.next();
        System.out.println("Enter the bird price : ");
        bird_price = sc1.nextInt();
        System.out.println("Enter the bird color : ");
        color = sc1.next();

        System.out.println("\n═════════════════════════════════════════════════════   \n");

        name_list.add(bird_name);
        price_list.add(bird_price);
        color_list.add(color);


    }






}



class Search{
    String bird_name;
    String bird_food;
    String bird_color;
    int bird_weight;

    Search(){

    }
    Search(String bird_name, String bird_food, String bird_color, int bird_weight){
        this.bird_color = bird_color;
        this.bird_food = bird_food;
        this.bird_name = bird_name;
        this.bird_weight = bird_weight;
    }

    public int getBird_weight() {
        return bird_weight;
    }

    public String getBird_food() {
        return bird_food;
    }

    public String getBird_color() {
        return bird_color;
    }

    public String getBird_name() {
        return bird_name;
    }

}
class Species extends Search{

    ArrayList<Search> search_list = new ArrayList<>();


    void add_bird(Search obj1){
        search_list.add(obj1);

    }
    void setSearch_list(String name, String food, String color, int weight) {

        for (Search search : search_list) {
            if (search.getBird_name().equals(name)
                    && search.getBird_food().equals(food)
                    && search.getBird_color().equals(color)
            ) {
                System.out.println("________________________\n");
                System.out.println("Bird found:");
                System.out.println("Name: " + search.getBird_name());
                System.out.println("Food: " + search.getBird_food());
                System.out.println("Color: " + search.getBird_color());
                System.out.println("Weight: " + search.getBird_weight());
                System.out.println("\n________________________\n");

            }

        }

    }
    void display(){
        System.out.println("\n═════════════════════════════════════════════════════   \n");
        System.out.println("Bird-Name \t\t\t Bird-Food \t\t\t Bird-Color \t\t\t Bird-Weight");
        for (int i = 0; i < search_list.size(); i++) {
            System.out.println(search_list.get(i).getBird_name()+" \t\t\t "+search_list.get(i).getBird_food()+" \t\t\t "
                    +search_list.get(i).getBird_color()+" \t\t\t "+search_list.get(i).getBird_weight());
        }
        System.out.println("\n═════════════════════════════════════════════════════   \n");

    }


}


class TaskListApp {


    static Species sp1 = new Species(); // Create a single instance of Species


    static void bird_menu(){
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════╗   ");
        System.out.println("║   1]. Buy_Bird     2]. Sell Bird    3].   Add Bird     4]. Search bird    ║"     );
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Enter your choice : ");
    }
    public static void main(String[] args) {

        Mythread mythread2 = new Mythread();

        bird_menu();
        mythread2.start();
        call();

    }
    public static void call() {
        int choice = 0;
        Scanner sc1 = new Scanner(System.in);
        Bird bird1 = new Bird();

        while (true) {
            choice = sc1.nextInt();

            switch (choice) {
                case 1:
                    bird1.buy_bird();
                    Mythread mythread = new Mythread();
                    mythread.list_updated();
                    System.out.println("99]. Main_menu");
                    int buyer_choice = sc1.nextInt();

                    if (buyer_choice == 99) {
                        bird_menu();
                        call();

                    }
                    break;

                case 2:
                    bird1.sell_bird();
                    Mythread mythread2 = new Mythread();
                    mythread2.message();
                    System.out.println("99]. Main_menu");
                    int buyer_choice2 = sc1.nextInt();

                    if (buyer_choice2 == 99) {
                        bird_menu();
                        call();
                    }
                    break;

                case 3:

                    System.out.println("Enter the bird name : ");
                    String bird_name = sc1.next();
                    System.out.println("Enter the bird's food  : ");
                    String food = sc1.next();
                    System.out.println("Enter the color of bird : ");
                    String color = sc1.next();
                    System.out.println("Enter the weight of bird : ");
                    int weight = sc1.nextInt();
                    Search search1 = new Search(bird_name, food, color, weight);
                    sp1.add_bird(search1);

                    System.out.println("99]. Main_menu");
                    int buyer_choice3 = sc1.nextInt();

                    if (buyer_choice3 == 99) {
                        bird_menu();
                        call();
                    }
                    break;

                case 4:
                    sp1.display();
                    System.out.println("Enter the bird name : ");
                    String bird_name1 = sc1.next();
                    System.out.println("Enter the bird's food  : ");
                    String food1 = sc1.next();
                    System.out.println("Enter the color of bird : ");
                    String color1 = sc1.next();
                    System.out.println("Enter the weight of bird : ");
                    int weight1 = sc1.nextInt();

                    sp1.setSearch_list(bird_name1,food1,color1,weight1);
                    System.out.println("99]. Main_menu");
                    int buyer_choice4 = sc1.nextInt();

                    if (buyer_choice4 == 99) {
                        bird_menu();
                        call();
                    }
                    break;


                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

}
/*
I see what you're trying to accomplish. You want to display the current contents of
 the lists when buying a bird. The issue is that when you call the buy_bird() method,
  it's not displaying the data because the Bird class is creating a new instance of the lists each
   time it's called.

To resolve this issue, you need to work with the same set of lists across all instances of the Bird class.
You can achieve this by using a shared instance of the Bird class.

With this change, the lists name_list, price_list, and color_list are shared across all instances of the Bird class.
Therefore, when you call buy_bird() or sell_bird(), they will work with the same lists, and the data will be displayed
correctly when buying a bird.





 */