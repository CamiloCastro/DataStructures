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
public class Company implements Comparable<Company> {
    
    private String name;
    
    private String nit;
    
    private double pays;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public double getPays() {
        return pays;
    }

    public void setPays(double pays) {
        this.pays = pays;
    }

    public Company addCompany(Company c)
    {
        Company result = new Company();
        result.setName(this.name + c.getName());
        result.setNit(this.nit + c.getNit());
        result.setPays(this.pays + c.getPays());
        return result;
    }

    @Override
    public int compareTo(Company o) {
        return Double.compare(pays, o.getPays());
    }
    
}
