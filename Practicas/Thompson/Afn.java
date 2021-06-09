
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srr_s
 */
public class Afn {
List<Trancision> tablaT =new ArrayList<Trancision>();    
int numEstados=0;
int numTran=0;
int estadoI;
int estadoF;

Afn()
{
}


        
void  agregar_transicion(int estadoA, int estadoS, char simbolo)
{
Trancision t= new Trancision();

t.establecer_estadoA(estadoA);
t.establecer_estadoS(estadoS);
t.establecer_simbolo(simbolo);

tablaT.add(t);

}

int obtener_inicial()
{
return estadoI;
}
int obtener_final()
{
return estadoF;
}

void establecer_inicial(int estado)
{
estadoI=estado;
}
void establecer_final(int estado)
{
estadoF = estado;
}


int obtener_numEstados()
{
return numEstados;
}
int nuevoEstado()
{
numEstados+=1;
    return numEstados;
}

void imprimirAutomata()
{
System.out.println("El alfabeto que soporta el automate es de [a-z]");
System.out.println("Los estados del automata van del [1-"+numEstados+"]");
System.out.println("El estado inicial es: "+estadoI);
System.out.println("El estado final es: "+estadoF);
System.out.println("Tabla de trancisones:");

for(int i=0; i<tablaT.size(); i++)
System.out.println(tablaT.get(i).obtener_estadoA()+" , "+tablaT.get(i).obtener_simbolo()
        +" ->"+tablaT.get(i).obtener_estadoS());
}


    

}
