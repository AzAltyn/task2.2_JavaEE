package task2.Class;

public class Main {
    public static void main(String[] args){

        for (Item it: DBManager.getItemList()){
            System.out.println(it.getName());
        }

        Item item = DBManager.getItem(1l);
        System.out.println(item.getName());

        Item i = new Item();
        i.setName("Aza");
        i.setPrice(55555);
        i.setAmount(6666);

        DBManager.addItem(i);

        System.out.println("--------------------");
        for (Item it: DBManager.getItemList()){
            System.out.println(it.getName());
        }
    }
}
