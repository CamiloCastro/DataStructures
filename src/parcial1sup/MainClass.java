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
public class MainClass {
    
    public static void main(String[] args)
    {
        double grade = 0.0;
        //Punto 1
        Punto1 p1 = new Punto1();
        boolean p1Good = true;
        p1Good = p1Good && (p1.getNTimes("alohaa", 'a') == 3);
        p1Good = p1Good && (p1.getNTimes("kekekekekaae", 'k') == 5);
        p1Good = p1Good && (p1.getNTimes("sin ningun letr", 'a') == 0);
        p1Good = p1Good && (p1.getNTimes("este parcial esta muy facil", 'f') == 1);
        p1Good = p1Good && (p1.getNTimes("acostumbrar", 'r') == 2);
        
        if(p1Good)
            grade += 1.0;
        
        Company c1 = new Company();
        c1.setName("Empresa1");
        c1.setNit("900876543");
        c1.setPays(1235.6);
        
        Company c2 = new Company();
        c2.setName("Empresa2");
        c2.setNit("9874312");
        c2.setPays(-500.0);
        
        Company c3 = new Company();
        c3.setName("OtraEmpresa");
        c3.setNit("0981278");
        c3.setPays(2000.15);
        
        Company c4 = new Company();
        c4.setName("NuevaEmpresa");
        c4.setNit("123678945");
        c4.setPays(55.1);
        
        Company c14 = c1.addCompany(c4);
        Company c23 = c2.addCompany(c3);
        
        int compare14_4 = c14.compareTo(c4);
        int compare1_4 = c1.compareTo(c4);
        int compare2_3 = c2.compareTo(c3);
        
        boolean p2Good = true;
        
        p2Good = p2Good && (c14.getName().equals("Empresa1NuevaEmpresa") || c14.getName().equals("NuevaEmpresaEmpresa1"));
        p2Good = p2Good && (c14.getNit().equals("900876543123678945") || c14.getNit().equals("123678945900876543"));
        p2Good = p2Good && (Math.abs(c14.getPays()-(1235.6 + 55.1)) < 0.0001);
        p2Good = p2Good && (c23.getName().equals("Empresa2OtraEmpresa") || c23.getName().equals("OtraEmpresaEmpresa2"));
        p2Good = p2Good && (c23.getNit().equals("98743120981278") || c23.getNit().equals("09812789874312"));
        p2Good = p2Good && (Math.abs(c23.getPays()-(-500.0 + 2000.15)) < 0.0001);
        p2Good = p2Good && compare14_4 > 0;
        p2Good = p2Good && compare1_4 > 0;
        p2Good = p2Good && compare2_3 < 0;
        
        
        if(p2Good)
            grade += 1.0;
        
        MyCustomLinkedStack<String> customLinkedStack1 = new MyCustomLinkedStack<>();
        customLinkedStack1.push("A", false);
        customLinkedStack1.push("B", false);
        customLinkedStack1.push("C", false);
        customLinkedStack1.push("D", true);
        customLinkedStack1.push("E", false);
        customLinkedStack1.push("F", true);
        customLinkedStack1.push("G", true);
        
        String result1 = "";
        
        while(customLinkedStack1.size() > 0)
        {
            result1 += customLinkedStack1.pop();
        }
        
        MyCustomLinkedStack<String> customLinkedStack2 = new MyCustomLinkedStack<>();
        customLinkedStack2.push("X", true);
        customLinkedStack2.push("Y", true);
        customLinkedStack2.push("Z", true);
        customLinkedStack2.push("W", true);
        customLinkedStack2.push("R", false);
        customLinkedStack2.push("S", false);
        customLinkedStack2.push("T", false);
        
        String result2 = "";
        
        while(customLinkedStack2.size() > 0)
        {
            result2 += customLinkedStack2.pop();
        }
        
        boolean p3Good = true;
        
        p3Good = p3Good && result1.equals("ECBADFG");
        p3Good = p3Good && result2.equals("TSRXYZW");
        
        
        if(p3Good)
            grade += 1.5;
        
        MyExpressionTree expressionTree1 = new MyExpressionTree();        
        expressionTree1.buildExpressionTree("7 3 + 5 * 23 8 3 2 * - + -");
        
        MyExpressionTree expressionTree2 = new MyExpressionTree();        
        expressionTree2.buildExpressionTree("2 23 7 - * 5 + 3 3 8 - * +");
        
        boolean p4Good = true;
        
        p4Good = p4Good && expressionTree1.posOrder().trim().equals("7 3 + 5 * 23 8 3 2 * - + -");
        p4Good = p4Good && expressionTree2.posOrder().trim().equals("2 23 7 - * 5 + 3 3 8 - * +");
        
        if(p4Good)
            grade += 1.5;
        
        
        
        
        System.out.println("Grade: " + grade + " / 5.0");
        
        
    }
    
}
