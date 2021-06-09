import java.util.Scanner;
import java.util.ArrayList;	
import java.util.Stack;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srr_s
 */
public class Convertidor {
    Stack <Character> operaciones= new Stack <Character> ();
    Stack <Afn> operandos= new Stack<Afn>();
    Stack <Afn> pilaC= new Stack<Afn>();
    Afn afn1=new Afn();
    Afn afn2=new Afn();
    Plantilla p1=new Plantilla();
    boolean banderaC=false;
    char c;
    char op;
    
    Convertidor(){}

    
     
    public static boolean alfabeto(char c){ return c >= 'a' && c <= 'z' || c == 'E';}
    
    Afn convertir(String expReg)
    {
        for (int i = 0; i < expReg.length(); i++){
            c = expReg.charAt(i);
     
         if (alfabeto(c)){
                p1=new Plantilla();
                operandos.push(p1.p_basica(c));
                if (banderaC){ // concat this w/ previous
                    operaciones.push('.'); // '.' used to represent concat.
                }
                else
                    banderaC = true;
            }

         else if (c == '*'){
                    p1=new Plantilla();
                    operandos.push(p1.p_estrella(operandos.pop()));
                    banderaC = true;
                }
         else if (c == '|'){
                    operaciones.push(c);
                    banderaC = false;
                }    
            }
        
        
        
        while (operaciones.size() > 0){
  
            op = operaciones.pop();
            
            if (op == '.'){
                afn2 = operandos.pop();
                afn1 = operandos.pop();
                p1=new Plantilla();
                operandos.push(p1.p_concatenacion(afn1, afn2));
                
            }
            else if (op == '|'){
                afn2 = operandos.pop();

                if( !operaciones.empty() && operaciones.peek() == '.'){

                    pilaC.push(operandos.pop());
                    while (!operaciones.empty() && operaciones.peek() == '.'){
                        pilaC.push(operandos.pop());
                        operaciones.pop();
                    }
                    p1=new Plantilla();
                    afn1 = p1.p_concatenacion(pilaC.pop(),
                        pilaC.pop());
                    while (pilaC.size() > 0){
                       p1=new Plantilla();
                       afn2 =p1.p_concatenacion(afn1, pilaC.pop());
                    }
                }
                else{
                    afn1 = operandos.pop();
                }
                p1=new Plantilla();
                operandos.push(p1.p_or(afn1, afn2));
                }
                
            }
        
        operandos.peek().imprimirAutomata();
        return operandos.pop();
    }


}



