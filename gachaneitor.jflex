%%

/* Nombre de la clase generada para el analizador lexico*/
%class gachaneitor

/* Indicar funcionamiento autonomo*/
%standalone

/* Posibilitar acceso a la columna y fila actual de analisis*/
%line
%column

/* Declaraciones de macros NL(nueva linea) BLANCO(espacio en blanco) y TAB(tabulador) */
NL = \n|\r|\r\n
BLANCO = " "
TAB = \t
IDENTIFICADOR = [a-zA-z_][a-zA-Z0-9_]*
ENTERO = [1-9][:digit:]*
CADENA = [a-zA-Z][a-zA-Z_ ]*
COMILLAS = "\""

%%
/* ------------------------Seccion de reglas y acciones ----------------------*/

"MENU" | "menu"             {System.out.println("Token menu");}
"NICKNAME" | "nickname"     {System.out.println("Token nickname");}
"PLATOS" | "platos"         {System.out.println("Token platos");}
{ENTERO}                    {System.out.println("Token entero");}
"SACAR" | "sacar"           {System.out.println("Token sacar");}
"INGREDIENTES" | "ingredientes" {System.out.println("Token ingredientes");}
"INTRODUCIR" | "introducir" {System.out.println("Token introducir");}
"TIPO" |"tipo"              {System.out.println("Token tipo");}
"COMENSALES" | "comensales" {System.out.println("Token comensales");}
"TIEMPO"| "tiempo"          {System.out.println("Token tiempo");}
"PASOS" |"pasos"            {System.out.println("Token pasos");}
"PROGRAMAR" | "programar"   {System.out.println("Token programar");}
"PLATO" | "plato"           {System.out.println("Token plato");}
"PASO" | "paso"             {System.out.println("Token paso");}
"REALIZAR" | "realizar"     {System.out.println("Token realizar");}

"{"                         {System.out.println("Token {");}
"}"                         {System.out.println("Token }");}
";"                         {System.out.println("Token ;");}
":"			                    {System.out.println("Token :");}
","                         {System.out.println("Token ,");}
"("                         {System.out.println("Token (");}
")"                         {System.out.println("Token )");}
{NL}                        {/* No hacer nada */}
{BLANCO}                    {/* No hacer nada */}
{TAB}                       {/* No hacer nada */}
{IDENTIFICADOR}             {System.out.println("Token id");}
{COMILLAS}{CADENA}{COMILLAS} {System.out.println("Token cadena");}
/*"\""                      {System.out.println("Encontrado comillas");}*/
.                           {System.out.println("Token erroneo");}
