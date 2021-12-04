package edu.dalhousie.business.DalMembership.model;

public class Services {
    private String name;
    private int charges;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }


    public Services(String name, int baseCharges) {
        this.name = name;
        this.charges = baseCharges;
    }

}
