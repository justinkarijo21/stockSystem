import java.util.ArrayList;
public class Product {

     private String Name;
     private double Price;
     private int Stock;

     public double getPrice(){
         return Price;
     }

     public int getStock(){
         return Stock;
     }

    public void setPrice(double price) {
         this.Price = price;
    }

    public String getName(){ return Name; }

     public Product(String name, double price, int stock) {

         this.Name = name;
         this.Price = price;
         this.Stock = stock;
     }

     @Override
     public String toString() {
         return
                 "Product: " + Name + ", Price: $" + Price + ", Stock: " + Stock;
     }

     public void addStock(int amount) {

         if (amount <= 0) {
             System.out.println("Amount can't be negative.");
         } else {
             this.Stock += amount;
         }
     }

    }



