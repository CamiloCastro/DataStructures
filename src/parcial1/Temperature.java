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
    
    public Temperature(Double val, char scale)
    {
        if(scale == 'K')
            value = val;
        else if(scale == 'C')
            value = val + 273.15;
        else if(scale == 'F')
        {
            double cValue = (val - 32.0)/1.8;
            value = cValue + 273.15;
        }
    }
    
    public double getValueInScale(char scale)
    {
        switch(scale)
        {
            case 'K': return value;                
            
            case 'C': return value - 273.15;
            
            case 'F': return ((value - 273.15) * 1.8) + 32.0;        
        }
        return 0.0;
    }   

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }  
    
   

    @Override
    public int compareTo(Temperature o) {
        if(this.getValueInScale('K') > o.getValueInScale('K'))
            return 1;
        else if(this.getValueInScale('K') < o.getValueInScale('K'))
            return -1;
        else
            return 0;
    }
    
}
