package com.example.testdesk;

public class DataChem {

    private String elem;

    private Double massXRD;

    private Double massAmorf;

    public DataChem(String elem, Double massXRD, Double massAmorf) {
        this.elem = elem;
        this.massXRD = massXRD;
        this.massAmorf = massAmorf;
    }

    public Double getMassAmorf() {
        return massAmorf;
    }

    public void setMassAmorf(Double massAmorf) {
        this.massAmorf = massAmorf;
    }

    public Double getMassXRD() {
        return massXRD;
    }

    public void setMassXRD(Double massXRD) {
        this.massXRD = massXRD;
    }

    public String getElem() {
        return elem;
    }

    public void setElem(String elem) {
        this.elem = elem;
    }
}
