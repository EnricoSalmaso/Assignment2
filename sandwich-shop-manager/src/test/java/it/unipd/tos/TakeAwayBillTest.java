////////////////////////////////////////////////////////////////////
// Enrico Salmaso 1166175
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import static org.junit.Assert.assertEquals;

import java.util.*;

/**
 * Unit test for simple Manager.
 */
public class TakeAwayBillTest
{
    Manager manager = new Manager();

    @org.junit.Test
    public void TestRisultatoCorretto() throws TakeAwayBillException {
        ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>() {};
        menuItem.add(new MenuItem(MenuItem.itemType.Panini,"Primavera",4.5));
        menuItem.add(new MenuItem(MenuItem.itemType.Panini,"Arancini",5));
        menuItem.add(new MenuItem(MenuItem.itemType.Fritti,"Cola",3));
        menuItem.add(new MenuItem(MenuItem.itemType.Bevande,"Fanta",3));
        menuItem.add(new MenuItem(MenuItem.itemType.Bevande,"Pepsi",2.5));
        assertEquals(18, manager.getOrderPrice(menuItem),0);
    }

    @org.junit.Test
    public void Test5Panini() throws TakeAwayBillException {
        ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>() {};
        menuItem.add(new MenuItem(MenuItem.itemType.Panini,"Primavera",4.5));
        menuItem.add(new MenuItem(MenuItem.itemType.Panini,"Arancini",5.5));
        menuItem.add(new MenuItem(MenuItem.itemType.Panini,"BigMac",3));
        menuItem.add(new MenuItem(MenuItem.itemType.Panini,"CheeseBurger",3));
        menuItem.add(new MenuItem(MenuItem.itemType.Panini,"Burger",2));
        assertEquals(17, manager.getOrderPrice(menuItem),0);
    }

    @org.junit.Test
    public void TestSup50() throws TakeAwayBillException {
        ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>() {};
        for(int i=0; i<10; i++) {
            menuItem.add(new MenuItem(MenuItem.itemType.Panini,"Primavera",4));
            menuItem.add(new MenuItem(MenuItem.itemType.Fritti,"Patatine",3.5));
            menuItem.add(new MenuItem(MenuItem.itemType.Panini,"BigMac",2.5));
        }
        assertEquals(90, manager.getOrderPrice(menuItem),0);
    }

    @org.junit.Test(expected = TakeAwayBillException.class)
    public void TestSup30() throws TakeAwayBillException {
        ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>() {};
        for(int i=0; i<12; i++) {
            menuItem.add(new MenuItem(MenuItem.itemType.Bevande,"Cola",4));
            menuItem.add(new MenuItem(MenuItem.itemType.Panini,"Arancini",3.5));
            menuItem.add(new MenuItem(MenuItem.itemType.Fritti,"Patatine",2.5));
        }
        manager.getOrderPrice(menuItem);
    }

    @org.junit.Test
    public void TestMin10() throws TakeAwayBillException {
        ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>() {};
        menuItem.add(new MenuItem(MenuItem.itemType.Panini,"Primavera",4));
        menuItem.add(new MenuItem(MenuItem.itemType.Panini,"Arancini",3.5));
        assertEquals(8,manager.getOrderPrice(menuItem),0);
    }

    @org.junit.Test
    public void TestListaVuota() throws TakeAwayBillException {
        ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>() {};
        assertEquals(0,manager.getOrderPrice(menuItem),0);
    }
}
