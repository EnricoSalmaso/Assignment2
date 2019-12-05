////////////////////////////////////////////////////////////////////
// Enrico Salmaso 1166175
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

import java.util.List;

public class Manager implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double totalPrice=0.0;
        if(itemsOrdered.isEmpty()) {
            return totalPrice;
        }
        totalPrice+=itemsOrdered.get(0).getPrice();
        double min=itemsOrdered.get(0).getPrice();
        for(int i=1; i<itemsOrdered.size(); i++) {
            if(min>itemsOrdered.get(i).getPrice()) {
                min=itemsOrdered.get(i).getPrice();
            }
            totalPrice+=itemsOrdered.get(i).getPrice();
        }


        if(totalPrice<10) {
            totalPrice += 0.50;
        }

        boolean verify1=true;
        for(int i=0; i<itemsOrdered.size(); i++) {
            if(itemsOrdered.get(i).getType()== MenuItem.itemType.Bevande) {
                verify1 = false;
            }
        }
        if(totalPrice>50 && verify1) {
            return (totalPrice*0.9);
        }

        if(itemsOrdered.size()>30) {
            throw new TakeAwayBillException();
        }

        boolean verify=true;
        for(int i=0; i<itemsOrdered.size(); i++) {
            if(itemsOrdered.get(i).getType()!=MenuItem.itemType.Panini) {
                verify = false;
            }
        }
        if(itemsOrdered.size()>=5 && verify) {
            return totalPrice - min / 2;
        }

        return  totalPrice;
    }
}
