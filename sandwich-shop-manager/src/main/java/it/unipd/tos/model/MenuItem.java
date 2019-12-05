////////////////////////////////////////////////////////////////////
// Enrico Salmaso 1166175
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
    public enum itemType {Panini,Fritti,Bevande};

    private itemType type;
    private String name;
    private double price;

    public MenuItem() {

    }

    public MenuItem(itemType type, String name, double price) {
        this.type=type;
        this.name=name;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public itemType getType() {
        return type;
    }


}
