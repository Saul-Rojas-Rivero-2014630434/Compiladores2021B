/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srr_s
 */
public class Thompson {

	public static void main(String[] args) {
//Afn afn1= new Afn();
//Afn afn2= new Afn();
Afn afnS= new Afn();
//Plantilla p1= new Plantilla();

String expReg="ac*";
 
Convertidor c1= new Convertidor();

afnS=c1.convertir(expReg);

//afnS.imprimirAutomata();

        }    
}
