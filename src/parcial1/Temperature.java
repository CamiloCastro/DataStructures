/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author juan.castro
 */
public class Temperature implements Comparable<Temperature> {
    
    private double value;
    
    public Temperature(String val)
    {
        if(val.endsWith("K"))
            value = Double.parseDouble(val.replaceAll("K", ""));
        else if(val.endsWith("C"))
            value = Double.parseDouble(val.replaceAll("C", "")) + 273.15;
        else if(val.endsWith("F"))
        {
            double cValue = (Double.parseDouble(val.replaceAll("F", "")) - 32.0)/1.8;
            value = cValue + 273.15;
        }
    }
    
    public double getValue(String scale)
    {
        switch(scale)
        {
            case "K": return value;                
            
            case "C": return value - 273.15;
            
            case "F": return ((value - 273.15) * 1.8) + 32.0;        
        }
        return 0.0;
    }
    
    public Temperature add(Temperature t)
    {
        double kValue = this.getValue("K") + t.getValue("K");
        return new Temperature(kValue + "K");
    }

    @Override
    public int compareTo(Temperature o) {
        if(this.getValue("K") > o.getValue("K"))
            return 1;
        else if(this.getValue("K") < o.getValue("K"))
            return -1;
        else
            return 0;
    }
    
}
