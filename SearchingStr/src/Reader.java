import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private String filePath = "";
    private ArrayList arrayList = new ArrayList();
    private String list="";
    private int i=0;


    public ArrayList read(){


        try {
             list = list+Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            list = list.replaceAll("[.]|[,]|[\\[]|[\\]]","");
            System.out.println(list);

            for (String retval: list.split(" ")) {

                arrayList.add(i,retval);

              //  System.out.println(arrayList.get(i));
                i++;
            }

            return arrayList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
