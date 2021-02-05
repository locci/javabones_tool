package br.ime.usp.parser.pairs;

import br.ime.usp.parser.expression.Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pairs {

    public String pairs(String pai) {

        if(pai.contains("&") || pai.contains("|")) {

            return this.stack(pai);

        } else {

            return "Pares \n T - F \n @@@@@@@@@";

        }

    }

    public String stack(String str) {

        int cont = 0;
        String aux = str;
        Expression ex = new Expression();

        aux = aux.replace("&", "%");
        aux = aux.replace("|", "%");
        aux = aux.replace("%%", "%");

        String[] cond = aux.split("%");

        for(int j=0; j < cond.length; j++) {

           cond[j] = operandos(cond[j]);

        }


        if (cond.length == 1) {

            str = "A \n 0 - 1";
            return str;

        }

         char ch = 'A';
         String auxStr = str.replace(" ","");

         for (int w= 0; w < cond.length; w++) {

             auxStr = auxStr.replace(cond[w], Character.toString(ch));
             ch++;

         }

        auxStr = auxStr + ex.pairs(auxStr);
        return auxStr;

    }

    private String operandos(String operando) {


        operando = operando.replace(" ","");
        String pattern = "\\b([A-Za-z]\\w*)\\b";

        Pattern r = Pattern.compile(pattern);
        Matcher m;
        int cont = 0;

        while (cont < operando.length()) {

           if(operando.startsWith("(")) {

               operando = operando.substring(cont+1);

           } else {

               if(operando.startsWith("!")) {

                   operando = operando.substring(cont+1);

               }

           }
            cont++;
        }

        //int index = operando.lastIndexOf("\\(\\b([A-Za-z]\\\\w*)\\\\b\\)");
        cont--;
        if (operando.endsWith(")")) {

            while (cont > 0 && operando.charAt(cont) != '(' &&  operando.charAt(cont-1) != ')') {

                cont--;

            }

            if (cont == 0 || operando.charAt(cont-1) == ')') {

                cont = operando.length() ;
                operando = operando.substring(0, cont-1);

            }


        }

        return operando;

    }

}
