/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1sup;

/**
 *
 * @author jccas
 */
public class Punto1 {
    
    public int getNTimes(String s, char c)
    {
        if(s.length() == 1)
        {
            if(s.charAt(0) == c)
                return 1;
            return 0;
        }
        
        String first = s.substring(0,1);
        String last = s.substring(1);
        
        return getNTimes(first, c) + getNTimes(last, c);
    }
            
            
    
}
