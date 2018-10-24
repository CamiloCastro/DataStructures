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
public class Punto3 {
    
    public Temperature average(MyDoubleLinkedList<Temperature> temperatures)
    {
        double count = 0.0;
        for (int i = 0; i < temperatures.size(); i++) {
            count += temperatures.get(i).getValueInScale('K');
        }
        double kAverageValue = count / temperatures.size();
        return new Temperature(kAverageValue, 'K');
    }
    
    public Temperature median(MyDoubleLinkedList<Temperature> temperatures)
    {
        temperatures.sort();
        if(temperatures.size() % 2 == 0)
        {
            double value1 = temperatures.get(temperatures.size() / 2).getValueInScale('K');
            double value2 = temperatures.get((temperatures.size() / 2) - 1).getValueInScale('K');
            double median = (value1 + value2) / 2;
            return new Temperature(median, 'K');
        }
        else
            return temperatures.get(temperatures.size() / 2);
        
    }
    
    
}
