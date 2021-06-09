/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srr_s
 */
class Trancision {
int estadoA; 
int estadoS;
char simbolo;

Trancision()
{

}

int obtener_estadoA()
{
return estadoA;
}
int obtener_estadoS()
{
return estadoS;
}
char obtener_simbolo()
{
return simbolo;
}

void establecer_estadoA(int estado)
{
estadoA=estado;
}
void establecer_estadoS(int estado)
{
estadoS = estado;
}
void establecer_simbolo(char sim)
{
simbolo=sim;
}

}

