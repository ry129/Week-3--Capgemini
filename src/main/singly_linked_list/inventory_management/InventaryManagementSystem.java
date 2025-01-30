package main.singly_linked_list.inventory_management;

public class InventaryManagementSystem {
        public static void main(String[] args) {
                InventoryNodeMethod m = new InventoryNodeMethod();
                m.add("chocolate",56,50,90,0);
                m.add("jeans",23,5,9078,0);
                m.add("shirt",535,5,700,0);
                m.add("dryFruit",107,10,258,0);
                m.add("sweet",98,100,2500,0);
                m.display();
                m.sort();

               m.display();
            System.out.println("Total price is: " + m.total(m.root));

        }
    }




