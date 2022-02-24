import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
public class GenerateBoard {
    public static void main(String[] args) throws IOException {
        genBoard(5);
    }
    public static void genBoard(int size) throws IOException {
        Writer fileWriter = new FileWriter("board.txt");
        int boardSize = size;
        Random rng = new Random();
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        for(int i = 0; i < boardSize; i++){
            ArrayList<String> row = new ArrayList<>();
            if(rng.nextInt() % 7 == 0){
                row.add(""+rng.nextInt(-9,10));
            }
            else{
                row.add("" + 0);
            }
            for(int j = 1; j < boardSize; j++){
                if(rng.nextInt() % 7 == 0) {
                    row.add("\t" + rng.nextInt(-9, 10));
                }
                else{
                    row.add("\t"+ 0);
                }
            }
            board.add(row);
        }

        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j <boardSize; j++){
                fileWriter.write(board.get(i).get(j));
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}
