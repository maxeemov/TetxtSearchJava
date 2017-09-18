import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Search {

    private Reader reader = new Reader();
    private ArrayList arrayList;


    Frame frame = new Frame();

    int colum=0;

    public int loop(String string) {

        reader.setFilePath("text.txt");
        arrayList = reader.read();


        for (Object aray: arrayList){

            if(string.equals(aray)) {

                colum++;

            }

        }

return colum;





    }


}
