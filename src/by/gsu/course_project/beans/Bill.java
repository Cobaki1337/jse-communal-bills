package by.gsu.course_project.beans;

public class Bill {
    private int redecorate;
    private int liftService;
    private int additionalElectricity;
    private int water;
    private int gas;
    private int electricity;
    private int totalSum;

    public int getTotalSum() {
        return  redecorate + liftService + additionalElectricity + water + gas + electricity;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public int getRedecorate() {
        return redecorate;
    }

    public void setRedecorate(int redecorate) {
        this.redecorate = redecorate;
    }

    public int getLiftService() {
        return liftService;
    }

    public void setLiftService(int liftService) {
        this.liftService = liftService;
    }

    public int getAdditionalElectricity() {
        return additionalElectricity;
    }

    public void setAdditionalElectricity(int additionalElectricity) {
        this.additionalElectricity = additionalElectricity;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }
}
