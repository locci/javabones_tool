package br.ime.usp.parser.compi;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;

public class CompUnit {

    public CompilationUnit buildCompilerUnit (String nameFileJava) throws java.io.FileNotFoundException{

        FileInputStream in = new FileInputStream(nameFileJava);

        return JavaParser.parse(in);

    }

}
