package by.gsu.course_project.beans.payment_methods;

import static by.gsu.course_project.beans.BeansConstants.*;

public class ForPayment {
    public static int forRedecorate(double area){
        return (int) area * REDECORATE_TARIFF;
    }
    public static int forLiftService(int personNumb){
        return personNumb * LIFT_SERVICE_TARIFF;
    }
    public static int forAdditionalElectricity(int personNumb){
        return personNumb * ADDITIONAL_ELECTRICITY_TARIFF;
    }
    public static int forWater(int waterCount){
        if (waterCount > WATER_LIMIT){
            return (WATER_LIMIT * WATER_TARIFF_BEFORE_LIMIT) +
                    ((waterCount - WATER_LIMIT) * WATER_TARIFF_AFTER_LIMIT);
        }else {
            return waterCount * WATER_TARIFF_BEFORE_LIMIT;
        }
    }
    public static int forGas(int gasCount){
        return gasCount * GAS_TARIFF;
    }
    public static int forElectricity(int electroCount){
        return electroCount * ELECTRICITY_TARIFF;
    }
}
