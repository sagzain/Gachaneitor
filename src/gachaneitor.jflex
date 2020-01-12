import java_cup.runtime.*;
import java.util.HashMap;

/*----------------------------------------------------------------------------*/

class Utility
{
    private static HashMap<String, String> keywords = new
    HashMap<String,String>(){
      {
        put("menu", "menu"); put("nickname","nickname");
        put("platos", "platos"); put("sacar", "sacar");
        put("introducir", "introducir"); put("tipo", "tipo");
        put("comensales", "comensales"); put("tCocinado","tCocinado");
        put("tPreparacion", "tPreparacion"); put("tTotal", "tTotal");
        put("pasos", "pasos"); put("programar", "programar");
        put("plato", "plato"); put("paso", "paso"); put("realizar", "realizar");
        put("ingredientes", "ingredientes");
      }
    };

    public static String keyWord(String cadena)
    {
        String keyword = new String();
        keyword = keywords.get(cadena);

        return keyword;
    }
}

/*--------------------Seccion de opciones y declaraciones---------------------*/

/*--OPCIONES --*/

%%

%public

/* Nombre de la clase generada para el analizador lexico*/
%class analex

/* Indicar funcionamientoautonomo*/
%standalone

/*Encoding*/
%8bit

/* Posibilitar acceso a la columna y fila actual de analisis*/
%line
%column

/* Habilitar la compatibilidad con la interfaz CUP para el generador sintáctico */
%cup

/* COMMENT es un estado para reconocer los comentarios (tipo c o java) */
%state COMMENT

/*--DECLARACIONES --*/

NL = \n | \r | \r\n
BLANCO = " "
TAB = \t
ID = [a-zA-Z][a-z0-9_]*
ENTERO = [1-9][:digit:]*
CADENA = \" [a-zA-Z][a-zA-Z_ ]* \"
KEYWORD = [a-z][a-zA-Z]*
MEDIDA = "kg" | "gr" | "uds"
TIEMPO = "min" | "s" | "h"
TIPO = [A-Z]+
%%


/* ------------------------Seccion de reglas y acciones ----------------------*/

<YYINITIAL> {
  {MEDIDA}      {return Symbol(sym.medida);}
  {TIEMPO}      {return Symbol(sym.tiempo);}
  {TIPO}        {return Symbol(sym.tipo);}
  {KEYWORD}     {String keyword=new String();
                 keyword=Utility.keyWord(yytext());
  	             if (keyword != null)
                  return Symbol(sym.keyword.get(yytext()));
                 else
                  System.out.println("Error. Token <"+ keyword +"> encontrado en linea: " + (yyline+1) + " columna: "+ (yycolumn+1));
                }
  {ID}  				{System.out.println("Token <identificador> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}
  {CADENA}  	  {System.out.println("Token <cadena> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}
  {ENTERO}      {System.out.println("Token <entero> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  {NL}          {}
  {BLANCO}      {}
  {TAB}         {}

  /* Simbolos de separación */
  "{" 					{System.out.println("Token <llaveIzqd> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}
  "}" 					{System.out.println("Token <llaveDrch> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}
  ";" 					{System.out.println("Token <puntocoma> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}
  "," 					{System.out.println("Token <coma> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}
  "(" 					{System.out.println("Token <parentesisIzqd> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}
  ")" 					{System.out.println("Token <parentesisDrch> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  .             {}

}

<COMMENT> {
  "//".*        {}

  "/*"        	{}

  "*/"					{}
  .            	{}

  [\n]        	{}
}

<<EOF>> 			{System.out.println("Analisis finalizado"); System.exit(0);}
