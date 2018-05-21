package by.gsu.course_project.beans.payment_methods;

import by.gsu.course_project.beans.Bill;
import by.gsu.course_project.beans.NotPaidClient;

public class Payment {
    public static Bill paymentMethod(NotPaidClient client){
        Bill bill = new Bill();
        bill.setRedecorate(ForPayment.forRedecorate(client.getArea()));
        bill.setLiftService(ForPayment.forLiftService(client.getPersonNumb()));
        bill.setAdditionalElectricity(ForPayment.forAdditionalElectricity(client.getPersonNumb()));
        bill.setWater(ForPayment.forWater(client.getWaterCount()));
        bill.setGas(ForPayment.forGas(client.getGasCount()));
        bill.setElectricity(ForPayment.forElectricity(client.getElectroCount()));
        return bill;
    }
}
