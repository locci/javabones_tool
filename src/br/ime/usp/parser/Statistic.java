package br.ime.usp.parser;

public class Statistic {

    public static void main(String[] args) throws Exception {
        // create a script engine manager:
        //RenjinScriptEngineFactory factory = new RenjinScriptEngineFactory();
        // create a Renjin engine:
       // ScriptEngine engine = factory.getScriptEngine();

        // ... put your Java code here ...
        /*engine.eval("df <- data.frame(x=1:10, y=(1:10)+rnorm(n=10))");
        engine.eval("print(df)");
        engine.eval("print(lm(y ~ x, df))");*/



        /*engine.eval("df <- data.frame(x=1:10, y=(1:10)+rnorm(n=10))");
        engine.eval("print(df)");
        engine.eval("print(lm(y ~ x, df))");
        String output = outputWriter.toString();
        System.out.println(output + " My print.");
        // Reset output to console
        engine.getContext().setWriter(new PrintWriter(System.out));*/

        //String output = outputWriter.toString();
      /*  engine.eval("a <- 1 + 2");
        engine.eval("print(a)");
        String output = outputWriter.toString();
        System.out.println(output);

        engine.getContext().setWriter(new PrintWriter(System.out));*/
        //SEXP res = (SEXP)engine.eval("a <- 2; b <- 3; a*b");
        //System.out.println("The result of a*b is: " + res);


        //SEXP res = (SEXP)engine.eval("df$forNum");
        //System.out.println(res);

    }

    public void buildBasicStatistics(String path) {

        //RenjinScriptEngineFactory factory = new RenjinScriptEngineFactory();
       // ScriptEngine engine = factory.getScriptEngine();

       /* try {
          //  engine.eval("setwd(\"/media/alexandre/MyFiles/projetoGit/javaparser3/\")");
            //engine.eval("MyData <- read.csv(file='" + path + "')");
            //engine.eval("df <- data.frame (MyData)");
            //engine.eval("colnames(df) <- c(\"Num\")");

        } catch (ScriptException e) {
            e.printStackTrace();
        }*/

    }


}
