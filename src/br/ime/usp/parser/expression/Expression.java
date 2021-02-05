package br.ime.usp.parser.expression;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.TreeValueExpression;
import de.odysseus.el.util.SimpleContext;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.ArrayList;


public class Expression {

    public String parserConditions(String expre) {

        ExpressionFactoryImpl factory = new ExpressionFactoryImpl();
        SimpleContext context = new SimpleContext(); // more on this here...
        TreeValueExpression e = factory.createValueExpression(context, "#{" + expre + "}", Object.class);
        PrintWriter out;
        File arq = new File("expression");
        String aux = "";

        try (FileWriter fw = new FileWriter(arq)) {
            out = new PrintWriter(fw);
            e.dump(out);
            out.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        expre = expre + "\n";

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("expression"));

            while (br.ready()) {

                expre = expre + br.readLine() + "\n";

            }

            br.close();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return expre;

    }

    public String pairs(String str) {

        char ch = 'A';

        while (str.contains(String.valueOf(ch))) {

            ch++;

        }

        int num = ch - 'A';
        int line = (int) Math.pow(2,num);

        str = "\n" + this.tabela(str, num, line) + "\n";

        return str;

    }

    public String tabela(String str, int num, int line) {

        int fator = 1;
        String sb1 = "";
        String sb2 = "";
        String aux = "";
        ArrayList<Integer> calc = new ArrayList<>();
        int cont = num;
        char ch = 'A';
        char contCh;

        while (cont > 0) {

            for(int i = 0; i < line; i++) {

                if(!calc.contains(i)) {

                    sb1 = String.format("%"+ num+ "s", Integer.toBinaryString(i)).replace(' ', '0');
                    sb2 = String.format("%"+ num+ "s", Integer.toBinaryString(i + fator)).replace(' ', '0');
                    calc.add(i+fator);

                    if(this.avaliarExpressoes(sb1, sb2, str, num)) {

                        contCh = (char) ((char) ch + cont -1 );
                        aux = aux + "\n" + String.valueOf(contCh) + "\n" + sb1 + " - " + sb2;

                    }

                }

            }

            cont--;
            fator= fator * 2;
            calc.clear();

        }

        return aux;

    }

    public boolean avaliarExpressoes(String exp1, String exp2, String str, int num) {

        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("JavaScript");
        String auxVal1 = str;
        String auxVal2 = str;

        auxVal1 = this.carregaValor(exp1, str);
        auxVal2 = this.carregaValor(exp2, str);

        try {
            if(se.eval(auxVal1) != se.eval(auxVal2)) {

                return true;

            }

        } catch (ScriptException e) {
            e.printStackTrace();
        }


        return false;

    }

    public String carregaValor (String expr, String str) {

        char ch = 'A';

        for(int i = 0; i < expr.length(); i++) {

            if(expr.charAt(i) == '0') {

                str = str.replace(String.valueOf(ch), " false ");

            } else {

                str = str.replace(String.valueOf(ch), " true ");

            }

            ch++;

        }

        return  str;

    }


}
