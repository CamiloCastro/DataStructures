/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

/**
 *
 * @author jccas
 */
class Person {
    
    String id;
    int triage;
    
    public Person(String id)
    {
        this.id  = id;
        triage = 0;        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTriage() {
        return triage;
    }

    public void setTriage(int triage) {
        this.triage = triage;
    }
    
    

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", triage=" + triage + '}';
    }
    
    
    
}
