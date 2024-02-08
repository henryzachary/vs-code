public class Animal {
    public int age;
    public String gender;
    
    public void isMammal() {
        // mammal = userMammal;
        System.out.println("This is a public method mate() from class Animal");
    }
    
    public void mate() {
        // mate = userMate;
        System.out.println("This is a public method mate() from class Animal");
    }
    public static void main(String[] args){
        Animal myAnimal = new Animal();
        Fish myFish = new Fish();
        Zebra myZebra = new Zebra();
        
        myAnimal.isMammal();
        myAnimal.mate();
        myZebra.run();

    }
}

class Fish extends Animal{
    
    private int sizeInFeet;
    
    private void canEat(int eat){
        System.out.println("This is a private method canEat() from class Zebra");
    }
    
}

class Zebra extends Animal {
    public boolean isWild;
    
      public void run() { 
        System.out.println("This is a private method run() from class Animal");
      }}