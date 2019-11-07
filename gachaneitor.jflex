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
ID = (a-zA-z_)(a-zA-Z0-9_)*
ENTERO = [1-9][:digit:]*
CADENA = (a-zA-Z)(a-zA-Z_)*

%%
/* ------------------------Seccion de reglas y acciones ----------------------*/

"MENU" | "menu"             {System.out.println("Encontrado menu");}
"NICKNAME" | "nickname"     {System.out.println("Encontrado nickname");}
{ID}                        {System.out.println("Encontrado id");}
"{"                         {System.out.println("Encontrado {");}
"}"                         {System.out.println("Encontrado }");}
";"                         {System.out.println("Encontrado ;");}
"PLATOS" | "platos"         {System.out.println("Encontrado platos");}
{ENTERO}                    {System.out.println("Encontrado entero");}
"SACAR" | "sacar"           {System.out.println("Encontrado sacar");}
"INGREDIENTES" | "ingredientes" {System.out.println("Encontrado lista ingredientes");}
"INTRODUCIR" | "introducir" {System.out.println("Encontrado introducir");}
"TIPO" |"tipo"              {System.out.println("Encontrado tipo");}
"COMENSALES" | "comensales" {System.out.println("Encontrado comensales");}
"TIEMPO"| "tiempo"          {System.out.println("Encontrado tiempo");}
"PASOS" |"pasos"            {System.out.println("Encontrado pasos");}
"PROGRAMAR" | "programar"   {System.out.println("Encontrado programar");}
","                         {System.out.println("Encontrado ,");}
{CADENA}                    {System.out.println("Encontrado cadena");}
"("                         {System.out.println("Encontrado (");}
")"                         {System.out.println("Encontrado )");}
"PLATO" | "plato"           {System.out.println("Encontrado plato");}
"PASO" | "paso"             {System.out.println("Encontrado paso");}
"REALIZAR" | "realizar"     {System.out.println("Encontrado realizar");}
{NL}                        {/* No hacer nada */}
{BLANCO}                    {/* No hacer nada */}
{TAB}                       {/* No hacer nada */}

.                           {System.out.println("Token erroneo");}
