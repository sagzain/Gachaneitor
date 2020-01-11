//* --------------------------Seccion codigo-usuario ------------------------*/

import java.util.*;
import java_cup.runtime.*;

class Utility
{
    private static final String errorMsg[] = {"Unmatched end-of-comment punctuation",
                                "Error: Unmatched start-of-comment punctuation",
                                "Error: Unclosed string",
                                "Error: Illegal character ",
                                "Error: Illegal digit "};

    public static final int E_ENDCOMMENT = 0;
    public static final int E_STARTCOMMENT = 1;
    public static final int E_UNCLOSEDSTR = 2;
    public static final int E_UNMATCHED = 3;
    public static final int E_DIGIT = 4;

    public static void error(int code, String cadena, int line, int column)
    {
        System.out.println(errorMsg[code]+cadena+" en la linea: "+line+
                           "columna: "+column);
    }



    public static String keyWord(String cadena)
    {
        HashMap<String, String> keywords = new HashMap<String,String>();

        keywords.put("menu", "menu");
        keywords.put("nickname","nickname");
        keywords.put("platos", "platos");
        keywords.put("sacar", "sacar");
        keywords.put("introducir", "introducir");
        keywords.put("tipo", "tipo");
        keywords.put("comensales", "comensales");
        keywords.put("tCocinado","tCocinado");
        keywords.put("tPreparacion", "tPreparacion");
        keywords.put("tTotal", "tTotal");
        keywords.put("pasos", "pasos");
        keywords.put("programar", "programar");
        keywords.put("plato", "plato");
        keywords.put("paso", "paso");
        keywords.put("realizar", "realizar");
        keywords.put("min","tiempo");
        keywords.put("h", "tiempo");
        keywords.put("s", "tiempo");
        keywords.put("ingredientes", "ingredientes");
        keywords.put("uds", "medida");
        keywords.put("kg", "medida");
        keywords.put("gr", "medida");


        String keyword = new String();
        keyword = keywords.get(cadena);

        return keyword;
    }
}

%%

/* -----------------Seccion de opciones y declaraciones -----------------*/

/*--OPCIONES --*/

/* Nombre de la clase generada para el analizador lexico*/
%class analex

/* Indicar funcionamientoautonomo*/
%standalone

/* Posibilitar acceso a la columna y fila actual de analisis*/
%line
%column

/* Habilitar la compatibilidad con la interfaz CUP para el generador sintáctico */
//%cup

/* COMMENT es un estado para reconocer los comentarios (tipo c o java) */
%state COMMENT

/*--DECLARACIONES --*/
/* Declaraciones de macros NL(nueva linea) BLANCO(espacio en blanco) y TAB(tabulador) */
NL = \n|\r|\r\n
BLANCO = " "
TAB = \t
ID = [a-zA-Z][a-z0-9_]*
ENTERO = [1-9][:digit:]*
CADENA = \" [a-zA-Z][a-zA-Z_ ]* \"
KEYWORD = [a-z][a-zA-Z]*

%%
/* ------------------------Seccion de reglas y acciones ----------------------*/
<YYINITIAL>
{
  [A-Z]+          {System.out.println("Token <nombreTipo> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  {KEYWORD}       {String keyword=new String();
                   keyword=Utility.keyWord(yytext());
  	               if (keyword != null)
                      System.out.println("Token <"+ keyword +"> encontrado en linea: " + (yyline+1) + " columna: "+ (yycolumn+1));
                   else
                      System.out.println("Error. Token <"+ keyword +"> encontrado en linea: " + (yyline+1) + " columna: "+ (yycolumn+1));
                                  }
  "{" 					{System.out.println("Token <llaveIzqd> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  "}" 					{System.out.println("Token <llaveDrch> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  ";" 					{System.out.println("Token <puntocoma> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  "," 					{System.out.println("Token <coma> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  "(" 					{System.out.println("Token <parentesisIzqd> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  ")" 					{System.out.println("Token <parentesisDrch> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  {ID}  				{System.out.println("Token <identificador> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  {CADENA}  	  {System.out.println("Token <cadena> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  {ENTERO}      {System.out.println("Token <entero> encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

  {NL}          {/* No hacer nada ignora delimitadores */}

  {BLANCO}      {/* No hacer nada */}

  {TAB}         {/* No hacer nada */}

  .             {/* Token erroneo */}

}

<COMMENT>
{
  "//".*        { /* ignora los comentarios de una linea */ }

  "/*"        	{}

  "*/"					{/* Error */}
  .            	{ /* ignora los contenidos de los comentarios */}

  [\n]        	{ /* ignora los saltos de línea en los comentarios */}

  <<EOF>> 			{/* Error */ return YYEOF;}
}
