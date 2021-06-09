/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srr_s
 */
public class Plantilla {
Afn afnS;
int nuevoI;
int nuevoF;

Plantilla(){
afnS= new Afn();
}

Afn p_basica(char sim)
{
    nuevoI=afnS.nuevoEstado();
    nuevoF=afnS.nuevoEstado();

    afnS.establecer_inicial(nuevoI);
    afnS.establecer_final(nuevoF);
    
    afnS.agregar_transicion(nuevoI, nuevoF, sim);
    
return afnS;
}

Afn p_estrella(Afn afn1)
{
afnS=afn1;
    
    nuevoI=afnS.nuevoEstado();
    nuevoF=afnS.nuevoEstado();

   afnS.agregar_transicion(afnS.obtener_final(), afnS.obtener_inicial(), 'E');
   afnS.agregar_transicion(nuevoI, afnS.obtener_inicial(), 'E');
   afnS.agregar_transicion(afnS.obtener_final(), nuevoF, 'E');
   afnS.agregar_transicion(nuevoI, nuevoF, 'E');
   
   afnS.establecer_inicial(nuevoI);
   afnS.establecer_final(nuevoF);
   
return afnS;
} 

Afn p_or(Afn afn1, Afn afn2)
{    

afnS=afn1;
int diferencia =afn1.obtener_numEstados();

for(int i=0; i<afn2.tablaT.size(); i++)
{
afnS.agregar_transicion(afn2.tablaT.get(i).obtener_estadoA()+diferencia, 
                        afn2.tablaT.get(i).obtener_estadoS()+diferencia,
                        afn2.tablaT.get(i).obtener_simbolo());

}

for(int i=0; i<=afn2.tablaT.size(); i++)afnS.nuevoEstado();

    nuevoI=afnS.nuevoEstado();
    nuevoF=afnS.nuevoEstado();

   afnS.agregar_transicion(nuevoI, 
                           afn1.obtener_inicial(), 
                           'E');
   afnS.agregar_transicion(nuevoI,
                           afn2.obtener_inicial()+diferencia,
                           'E');
   afnS.agregar_transicion(afn1.obtener_final(),
                           nuevoF,
                           'E');
   afnS.agregar_transicion(afn2.obtener_final()+diferencia,
                           nuevoF, 
                           'E');
   
   afnS.establecer_inicial(nuevoI);
   afnS.establecer_final(nuevoF);

    return afnS;
}

 Afn p_concatenacion(Afn afn1, Afn afn2) 
 {
     afnS=afn1;
     for(int i=0; i<afn2.tablaT.size(); i++)
     afnS.agregar_transicion(afn2.tablaT.get(i).obtener_estadoA(),
                             afn2.tablaT.get(i).obtener_estadoS(),
                             afn2.tablaT.get(i).obtener_simbolo());
      
     
     return afnS;
 }

}
