//* --------------------------Seccion codigo-usuario ------------------------*/

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

    private static final String keyWords[] = {"menu","nickname","platos",
                                              "sacar","introducir","tipo",
                                              "comensales", "tCocinado",
                                              "tPreparacion","tTotal","pasos",
                                              "programa","plato","paso",
                                              "realizar"};

    public static boolean is_keyWord(String cadena)
    {
        boolean keyword = false;
        for(int i = 0; i < keyWords.length && !keyword; i++)
            if(keyWords[i].equals(cadena))
                keyword = true;
        return keyword;
    }

    public static String keyWord(String cadena)
    {
        String keyword = new String();
        for(int i = 0; i < keyWords.length && keyword.isEmpty(); i++)
        {
            if(keyWords[i].equals(cadena))
                if(cadena.equals("tCocinado") || cadena.equals("tPreparacion")
                    || cadena.equals("tTotal"))
                    keyword = "tiempo";
                else
                    keyword =keyWords[i];
        }
        return keyword;
    }
}

%%

/* -----------------Seccion de opciones y declaraciones -----------------*/

/*--OPCIONES --*/

/* Nombre de la clase generada para el analizadorlexico*/

%class gachaneitor

/* Indicar funcionamientoautonomo*/

%standalone

/* Posibilitar acceso a la columna y fila actual de analisis*/

%line
%column

/* COMMENT es un estado para reconocer los comentarios (tipo c o java) */

%state COMMENT

/*--DECLARACIONES --*/
/* Declaraciones de macros NL(nueva linea) BLANCO(espacio en blanco) y TAB(tabulador) */

NL = \n|\r|\r\n
BLANCO = " "
TAB = \t
ID = [a-zA-z_][a-zA-Z0-9_]*
ENTERO = [1-9][:digit:]*
CADENA = "\""[a-zA-Z][a-zA-Z_]*"\""

%%
/* ------------------------Seccion de reglas y acciones ----------------------*/

<YYINITIAL> [a-z][a-z]*        {if (Utility.is_keyWord(yytext()))
                                {
                                    String keyword=new String();
                                    keyword=Utility.keyWord(yytext());
				                            if (keyword.equals(yytext()))
	                                      System.out.println("Token <"+ keyword +"> encontrado en linea: " + (yyline+1) + " columna: "+ (yycolumn+1));
					                          else
                                       System.out.println("Token <"+ keyword +">, lexema <"+yytext()+">, encontrado en linea: " + (yyline+1) + " columna: "+ (yycolumn+1));
                                }}

<YYINITIAL> "{" 					     {System.out.println("Token { encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

<YYINITIAL> "}" 					     {System.out.println("Token } encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

<YYINITIAL> ";" 					     {System.out.println("Token ; encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

<YYINITIAL> "," 					     {System.out.println("Token , encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

<YYINITIAL> "(" 					     {System.out.println("Token ( encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

<YYINITIAL> ")" 					     {System.out.println("Token ) encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

<YYINITIAL> {ID}  				     {System.out.println("Token identificador encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

<YYINITIAL> {CADENA}  			   {System.out.println("Token cadena encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

<YYINITIAL> {ENTERO}           {System.out.println("Token entero encontrado en linea: " + (yyline+1) + " columna: " + (yycolumn+1));}

<YYINITIAL> {NL}               {/* No hacer nada ignora delimitadores */}

<YYINITIAL> {BLANCO}           {/* No hacer nada */}

<YYINITIAL> {TAB}              {/* No hacer nada */}

<YYINITIAL> .                  {/* Token erroneo */ Utility.error(Utility.E_UNMATCHED,yytext(),(yyline+1),(yycolumn+1));}

<YYINITIAL> "//".*        		 { /* ignora los comentarios de una linea */ }
<YYINITIAL> "/*"        			 {yybegin(COMMENT); System.out.println("Token inicio parrafo comentario en línea: "+(yyline+1)+" columna: "+(yycolumn+1));}

<COMMENT> "*/"        				 {yybegin(YYINITIAL);}

<YYINITIAL> "*/"					     {/* Error */ Utility.error(Utility.E_ENDCOMMENT,"",(yyline+1),(yycolumn+1));}

<COMMENT> .            				 { /* ignora los contenidos de los comentarios */}

<COMMENT> [\n]        				 { /* ignora los saltos de l�nea en los comentarios */}

<COMMENT> <<EOF>> 				     {/* Error */  /* System.exit(0);*/ return YYEOF;}
