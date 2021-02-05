package br.ime.usp.parser.filemanager;

import org.renjin.script.RenjinScriptEngineFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class PlotFile {
    public void buildPlotsHistogram(String path, String type) {
        RenjinScriptEngineFactory factory = new RenjinScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();
        String command = "";
        try {
            engine.eval("setwd(\"/media/alexandre/MyFiles/projetoGit/javaparser3/\")");
            engine.eval("MyData <- read.csv(file='" + path + "')");
            engine.eval("df <- data.frame (MyData)");
            engine.eval("colnames(df) <- c(\"Num\")");
            engine.eval("pdf(NULL)");
            if (type.equals("if")) {
                engine.eval("png(\"sampleIfHis.png\", 490, 350)");
            } else {
                if (type.equals("while")) {
                    engine.eval("png(\"sampleWhileHis.png\", 490, 350)");
                } else {
                    engine.eval("png(\"sampleForHis.png\", 490, 350)");
                }
            }
            engine.eval("h <- hist(df$Num, plot=FALSE)");
            engine.eval("plot(h)");
            engine.eval("dev.off()");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public void buildBoxPlot(String path, String type) {
        RenjinScriptEngineFactory factory = new RenjinScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine();
        String command = "";
        try {
            engine.eval("setwd(\"/media/alexandre/MyFiles/projetoGit/javaparser3/\")");
            engine.eval("MyData <- read.csv(file='" + path + "')");
            engine.eval("df <- data.frame (MyData)");
            engine.eval("colnames(df) <- c(\"Num\")");
            engine.eval("pdf(NULL)");
            if (type.equals("if")) {
                engine.eval("png(\"sampleIfBox.png\", 490, 350)");
                command = "boxplot(df$Num, plot=TRUE, main ='Number of If statements for File', xlab = 'If Number', ylab= 'Files', col = 'orange',horizontal = TRUE,notch = TRUE)";
            } else {
                if (type.equals("while")) {
                    engine.eval("png(\"sampleWhileBox.png\", 490, 350)");
                    command = "boxplot(df$Num, plot=TRUE, main ='Number of While statements for File', xlab = 'While Number', ylab= 'Files', col = 'orange',horizontal = TRUE,notch = TRUE)";
                } else {
                    engine.eval("png(\"sampleForBox.png\", 490, 350)");
                    command = "boxplot(df$Num, plot=TRUE, main ='Number of For statements for File', xlab = 'For Number', ylab= 'Files', col = 'orange',horizontal = TRUE,notch = TRUE)";
                }
            }
            engine.eval(command);
            engine.eval("dev.off()");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
