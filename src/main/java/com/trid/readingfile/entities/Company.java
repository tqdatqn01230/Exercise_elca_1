package com.trid.readingfile.entities;

public class Company {
    private int id;
    private String name;
    private String foundation;
    private int capital;
    private String country;
    private boolean isHeaderQuarter;

    public Company(int id, String name,String foundation, int capital, String country,boolean isHeaderQuarter){
        this.id = id;
        this.foundation = foundation;
        this.name = name;
        this.capital = capital;
        this.country = country;
        this.isHeaderQuarter = isHeaderQuarter;
    }
    public int getId() {
        return id;
    }

    public int getCapital() {
        return capital;
    }

    public String getCountry() {
        return country;
    }

    public String getFoundation() {
        return foundation;
    }

    public String getName() {
        return name;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public void setHeaderQuarter(boolean headerQuarter) {
        isHeaderQuarter = headerQuarter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}