package br.ime.usp.parser.filemanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private final String nameFileRequeriment;

    {
        nameFileRequeriment = "logIfWhileFor";
    }

    private final String nameMetricFile;

    {
        nameMetricFile = "metricFile";
    }

    private final ArrayList<String> outPutList;

    {
        outPutList = new ArrayList<>();
    }

    public ArrayList<String> buildListOfFile (String path) {

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();


        if (listOfFiles!=null){

            for (File file : listOfFiles) {

                if (file.isFile()) {

                    if(file.getAbsolutePath().endsWith(".java")) {

                        outPutList.add(file.getAbsolutePath());

                    }

                } else {

                    buildListOfFile(file.getAbsolutePath());
                }

            }

        }

        return outPutList;

    }

    public void buidLogFile(String line){

        File fl = new File(nameFileRequeriment);

        try {

            FileWriter fw = new FileWriter(fl, true) ;
            fw.write(line + "\n");
            fw.close();

        } catch (IOException e) {

            System.out.println("Erro na escrita do arquivo logIfWhileFor");
            e.printStackTrace();

        }

    }

    public void buildMetricFile(String line){

        File fl = new File(nameMetricFile);

        try {

            FileWriter fw = new FileWriter(fl, true) ;
            fw.write(line + "\n");
            fw.close();

        } catch (IOException e) {

            System.out.println("Erro na escrita do arquivo metricFile");
            e.printStackTrace();

        }

    }

    public void destroFile() {

        File flLog = new File(nameFileRequeriment);
        File flMetric = new File(nameMetricFile);

        boolean delete = flLog.delete();

        if(delete) {

            System.out.println("Arquivo logIfWhileFor deletado.");

        }

        delete = flMetric.delete();

        if(delete) {

            System.out.println("Arquivo metricFile deletado.");

        }

    }

}
