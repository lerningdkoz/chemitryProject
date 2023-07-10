package com.example.testdesk;

import java.util.*;

public class Calculator {
    List<String> formulas;

    String amorf;

    public Calculator(List<String> formulas, String amorf) {
        this.amorf = amorf;
        this.formulas = formulas;
    }

    private Map<String, Double> getTable() {
        Map<String, Double> molarMasses = new HashMap<>();
        molarMasses.put("H", 1.008);
        molarMasses.put("He", 4.003);
        molarMasses.put("Li", 6.941);
        molarMasses.put("Be", 9.012);
        molarMasses.put("B", 10.81);
        molarMasses.put("C", 12.01);
        molarMasses.put("N", 14.01);
        molarMasses.put("O", 16.00);
        molarMasses.put("F", 19.00);
        molarMasses.put("Ne", 20.18);
        molarMasses.put("Na", 22.99);
        molarMasses.put("Mg", 24.31);
        molarMasses.put("Al", 26.98);
        molarMasses.put("Si", 28.09);
        molarMasses.put("P", 30.97);
        molarMasses.put("S", 32.07);
        molarMasses.put("Cl", 35.45);
        molarMasses.put("K", 39.10);
        molarMasses.put("Ca", 40.08);
        molarMasses.put("Sc", 44.96);
        molarMasses.put("Ti", 47.87);
        molarMasses.put("V", 50.94);
        molarMasses.put("Cr", 52.00);
        molarMasses.put("Mn", 54.94);
        molarMasses.put("Fe", 55.85);
        molarMasses.put("Ni", 58.69);
        molarMasses.put("Co", 58.93);
        molarMasses.put("Cu", 63.55);
        molarMasses.put("Zn", 65.38);
        molarMasses.put("Ga", 69.72);
        molarMasses.put("Ge", 72.63);
        molarMasses.put("As", 74.92);
        molarMasses.put("Se", 78.96);
        molarMasses.put("Br", 79.90);
        molarMasses.put("Kr", 83.80);
        molarMasses.put("Rb", 85.47);
        molarMasses.put("Sr", 87.62);
        molarMasses.put("Y", 88.91);
        molarMasses.put("Zr", 91.22);
        molarMasses.put("Nb", 92.91);
        molarMasses.put("Mo", 95.94);
        molarMasses.put("Tc", 98.00);
        molarMasses.put("Ru", 101.07);
        molarMasses.put("Rh", 102.91);
        molarMasses.put("Pd", 106.42);
        molarMasses.put("Ag", 107.87);
        molarMasses.put("Cd", 112.41);
        molarMasses.put("In", 114.82);
        molarMasses.put("Sn", 118.71);
        molarMasses.put("Sb", 121.76);
        molarMasses.put("I", 126.90);
        molarMasses.put("Te", 127.60);
        molarMasses.put("Xe", 131.29);
        molarMasses.put("Cs", 132.91);
        molarMasses.put("Ba", 137.33);
        molarMasses.put("La", 138.91);
        molarMasses.put("Ce", 140.12);
        molarMasses.put("Pr", 140.91);
        molarMasses.put("Nd", 144.24);
        molarMasses.put("Pm", 145.00);
        molarMasses.put("Sm", 150.36);
        molarMasses.put("Eu", 151.96);
        molarMasses.put("Gd", 157.25);
        molarMasses.put("Tb", 158.93);
        molarMasses.put("Dy", 162.50);
        molarMasses.put("Ho", 164.93);
        molarMasses.put("Er", 167.26);
        molarMasses.put("Tm", 168.93);
        molarMasses.put("Yb", 173.05);
        molarMasses.put("Lu", 175.00);
        molarMasses.put("Hf", 178.49);
        molarMasses.put("Ta", 180.95);
        molarMasses.put("W", 183.84);
        molarMasses.put("Re", 186.21);
        molarMasses.put("Os", 190.23);
        molarMasses.put("Ir", 192.22);
        molarMasses.put("Pt", 195.08);
        molarMasses.put("Au", 196.97);
        molarMasses.put("Hg", 200.59);
        molarMasses.put("Tl", 204.38);
        molarMasses.put("Pb", 207.2);
        molarMasses.put("Bi", 208.98);
        molarMasses.put("Th", 232.04);
        molarMasses.put("Pa", 231.04);
        molarMasses.put("U", 238.03);
        molarMasses.put("Np", 237.05);
        molarMasses.put("Pu", 244.06);
        molarMasses.put("Am", 243.06);
        molarMasses.put("Cm", 247.07);
        molarMasses.put("Bk", 247.07);
        molarMasses.put("Cf", 251.08);
        molarMasses.put("Es", 252.08);
        molarMasses.put("Fm", 257.10);
        molarMasses.put("Md", 25810.0);
        molarMasses.put("No", 259.10);
        molarMasses.put("Lr", 262.11);
        return molarMasses;
    }

    private Map<List<String>, Map<String, Double>> getElements() {
        Map<List<String>, Map<String, Double>> result = new HashMap<>();
        Map<String, Double> elementsIdentity = new HashMap<>();
        int tempInt = 0;
        for (var el : formulas) {
            var firstNumberSt = "";
            List<String> el1 = List.of(el.split(" "));
            StringBuilder sb = new StringBuilder(el1.get(0).replace(',', '.'));
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isLetter(sb.charAt(0))) {
                    firstNumberSt = "1";
                    break;
                }
                if (Character.isDigit(sb.charAt(i)) || sb.charAt(i) == '.')
                    firstNumberSt += Character.toString(sb.charAt(i));
                else
                    break;
            }
            if (!firstNumberSt.equals("1"))
                sb.delete(0, firstNumberSt.length());
            double firstNumber = Double.parseDouble(firstNumberSt);
            StringBuilder chem = new StringBuilder();
            StringBuilder count = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                System.out.println(i + " " + sb.charAt(i) + " " + chem.toString());
                if (Character.isLetter(sb.charAt(i)) && Character.isUpperCase(sb.charAt(i)) && i == 0)
                    chem = new StringBuilder(Character.toString(sb.charAt(i)));
                else if (Character.isLetter(sb.charAt(i)) && Character.isLowerCase(sb.charAt(i))) {
                    chem.append(sb.charAt(i));
                    if (i == sb.length() - 1) {
                        if (elementsIdentity.containsKey(chem.toString()))
                            elementsIdentity.put(chem.toString(),
                                    elementsIdentity.get(chem.toString()) + firstNumber);
                        else
                            elementsIdentity.put(chem.toString(),
                                    Double.parseDouble(String.valueOf(firstNumber)));
                    }
                } else if ((Character.isDigit(sb.charAt(i)) || sb.charAt(i) == '.') && i != sb.length() - 1)
                    count.append(sb.charAt(i));
                else if (sb.charAt(i) == '*') {
                    elementsIdentity.put(chem.toString(), Double.parseDouble(count.toString()) * firstNumber);
                    chem = new StringBuilder();
                    count = new StringBuilder();
                    firstNumberSt = "";
                    for (int j = i + 1; j < sb.length(); j++) {
                        if (Character.isDigit(sb.charAt(j))) {
                            firstNumberSt += Character.toString(sb.charAt(j));
                            tempInt += 1;
                        }
                        else {
                            break;
                        }
                    }
                    firstNumber = Double.parseDouble(firstNumberSt);
                    i += tempInt;
                    continue;
                } else if (Character.isLetter(sb.charAt(i)) && Character.isUpperCase(sb.charAt(i)) && i != 0) {
                    if (count.isEmpty())
                        count.append(String.valueOf(firstNumber));
                    else
                        count = new StringBuilder(String.valueOf(Double.parseDouble(count.toString()) * firstNumber));
                    if (!chem.isEmpty()) {
                        if (elementsIdentity.containsKey(chem.toString()))
                            elementsIdentity.put(chem.toString(),
                                    elementsIdentity.get(chem.toString()) + Double.parseDouble(count.toString()));
                        else
                            elementsIdentity.put(chem.toString(), Double.valueOf(count.toString()));
                    }
                    chem = new StringBuilder(String.valueOf(sb.charAt(i)));
                    count = new StringBuilder();
                    if (i == sb.length() - 1) {
                        if (elementsIdentity.containsKey(chem.toString()))
                            elementsIdentity.put(chem.toString(),
                                    elementsIdentity.get(chem.toString()) + firstNumber);
                        else
                            elementsIdentity.put(chem.toString(),
                                    firstNumber);
                    }
                } else if (Character.isDigit(sb.charAt(i)) && i == sb.length() - 1) {
                    if (elementsIdentity.containsKey(chem.toString()))
                        elementsIdentity.put(chem.toString(),
                                elementsIdentity.get(chem.toString()) + Double.parseDouble(count.toString()) * firstNumber);
                    else
                        elementsIdentity.put(chem.toString(),
                                Double.parseDouble(count.toString() + String.valueOf(sb.charAt(i))) * firstNumber);
                }
                if (sb.length() == 1) {
                    elementsIdentity.put(sb.toString(), firstNumber);
                }

            }
            result.put(el1, new HashMap<>(elementsIdentity));
            elementsIdentity.clear();
        }
        for (var el : result.entrySet()) {
            System.out.println(el.getKey() + ": " + el.getValue());
        }
        return result;
    }

    public Map<String, List<Double>> getResultProgram() {
        var tableMendeleev = getTable();
        var elements = getElements();
        var elementsXRD = new HashMap<String, Map<String, Double>>();
        for (var el : elements.entrySet()) {
            var tempMap = new HashMap<String, Double>();
            double sumMass = 0.0;
            for (var val : el.getValue().entrySet()) {
                sumMass += val.getValue() * tableMendeleev.get(val.getKey());
            }
            for (var val : el.getValue().entrySet()) {
                tempMap.put(val.getKey(),
                        val.getValue() * Double.parseDouble(el.getKey().get(1).replace(',', '.')) * tableMendeleev.get(val.getKey()) / sumMass);
            }
            elementsXRD.put(el.getKey().get(0), new HashMap<>(tempMap));
        }
        var elementsAmorf = new HashMap<String, Map<String, Double>>();
        for (var el : elementsXRD.entrySet()) {
            var tempMap = new HashMap<String, Double>();
            for (var val : el.getValue().entrySet()) {
                tempMap.put(val.getKey(), val.getValue() * (100 - Double.parseDouble(amorf)) / 100);
            }
            elementsAmorf.put(el.getKey(), new HashMap<>(tempMap));
        }
        var resultXRD = testMethod(elementsXRD, "XRD");
        var resultAmorf = testMethod(elementsAmorf, "Amorf");
        var result = new HashMap<String, List<Double>>();
        for (var elX : resultXRD.entrySet()) {
            for (var elA : resultAmorf.entrySet()) {
                if (elA.getKey().equals(elX.getKey()))
                    result.put(elA.getKey(), List.of(elX.getValue(), elA.getValue()));
            }
        }
        return result;
    }

    private Map<String, Double> testMethod(HashMap<String, Map<String, Double>> elements, String desc) {
        Map<String, Double> result = new HashMap<>();
        for (var el : elements.entrySet()) {
            for (var val : el.getValue().entrySet()) {
                if (result.containsKey(val.getKey()))
                    result.put(val.getKey(), result.get(val.getKey()) + val.getValue());
                else
                    result.put(val.getKey(), val.getValue());
            }
        }
        return result;
    }

    private void printResult(Map<String, Double> map) {
        double sum = 0.0;
        for (var el : map.entrySet()) {
            System.out.println(el.getKey() + " " + el.getValue().toString());
            sum += el.getValue();
        }
        System.out.println("Sum: " + Math.round(sum));
    }

}
