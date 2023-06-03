import java.io.*;
import java.util.Arrays;
public class Main {
    static int[] whiteBall = new int[2]; static int points = 0; static boolean key = false;
    public static void main(String[] args) throws IOException {
        int[] whiteBallposition = whiteball(args);
        String[][] boardArd = boardReader(args);
        String[] moveArr = move(args);
        playGame(boardArd,moveArr);
    }
    private static String[][] boardReader(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        int satir = 0, sütun=0;
        while ((line = reader.readLine()) != null){
            sütun = line.split(" ").length;
            satir ++;
        }
        reader.close();
        String[][] board = new String[satir][sütun];
        reader = new BufferedReader(new FileReader(args[0]));
        int i = 0;
        while ((line = reader.readLine()) != null){
            String[] element = line.split(" ");
            for (int j = 0; j < element.length ; j++) {
                board[i][j] = String.valueOf(element[j]);
            }i++;
        }reader.close();
        return board;
    }
    private static int[] whiteball(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        int satir = 0;
        while ((line = reader.readLine()) != null){
            String[] elements = line.split(" ");
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals("*")) {
                    whiteBall[0] = satir;
                    whiteBall[1] = i;
                }
            }satir++;
        }reader.close();
        return whiteBall;
    }
    private static String[] move(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[1]));
        String line;
        String[] arrMove = new String[1];
        while((line = reader.readLine()) != null){
            arrMove = line.split(" ").clone();
        }return arrMove;
    }
    private static void playGame(String[][] board,String[] move)throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String[][] finalBoard = board;
        writer.write("Game board:\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                writer.write(board[i][j]+" ");
            }writer.write("\n");
        }writer.write("\n");
        writer.write("Your movement is: \n");
        for (int i = 0; i < move.length; i++) {writer.write(move[i]+" ");}writer.write("\n\n");
        outerloop:
        for (String x : move){
            finalBoard = wall(whiteBall,x,finalBoard);
            if (key == true){break outerloop;}
        }writer.write("Your output is:\n");
        for (int i = 0; i < finalBoard.length; i++) {
            for (int j = 0; j < finalBoard[i].length; j++) {
                writer.write(finalBoard[i][j]+" ");
            }writer.write("\n");
        }if (key == true){writer.write("\nGame Over!");};writer.write("\nScore: "+points);
    writer.close();
    }
    private static String [][] wall(int[] position,String move, String[][] board){
        int y = position[0];int x = position[1];
        int[] aroundPoint = new int[2];
        String[][] updatedBoard = board;
        switch (move){
            case "R":
                if(board[y][((x+1)+board[y].length)%board[y].length].equals("W")){
                    x -= 1; x = (x + board[y].length) % board[y].length;aroundPoint[0]=y;aroundPoint[1]=x;
                    updatedBoard = checkAround(board,aroundPoint,"L");
            }
                else{
                    x += 1;x = (x) % board[y].length;aroundPoint[0]=y;aroundPoint[1]=x;
                    updatedBoard = checkAround(board,aroundPoint,"R");
                }break;
            case "L":
                if(board[y][((x-1)+board[y].length)%board[y].length].equals("W")){
                    x += 1;x = (x) % board[y].length;aroundPoint[0]=y;aroundPoint[1]=x;
                    updatedBoard = checkAround(board,aroundPoint,"R");
                }
                else{
                    x -= 1;x = (x + board[y].length) % board[y].length;aroundPoint[0]=y;aroundPoint[1]=x;
                    updatedBoard = checkAround(board,aroundPoint,"L");
                }break;
            case "U":
                if(board[((y-1)+board.length)%board.length][x].equals("W")){
                    y += 1;y = (y) % board.length;aroundPoint[0]=y;aroundPoint[1]=x;
                    updatedBoard = checkAround(board,aroundPoint,"D");
                }
                else{
                    y -= 1;y = (y + board.length) % board.length;aroundPoint[0]=y;aroundPoint[1]=x;
                    updatedBoard = checkAround(board,aroundPoint,"U");
                }break;
            case "D":
                if(board[((y+1)+board.length)%board.length][x].equals("W")){
                    y -= 1;y = (y + board.length) % board.length;aroundPoint[0]=y;aroundPoint[1]=x;
                    updatedBoard = checkAround(board,aroundPoint,"U");
                }
                else{
                    y += 1;y = (y) % board.length;aroundPoint[0]=y;aroundPoint[1]=x;
                    updatedBoard = checkAround(board,aroundPoint,"D");
                }break;

        }return updatedBoard;
    }
    private static String[][] checkAround(String[][] board,int[] position,String move){
        int x = position[1],y =position[0],xb= whiteBall[1],yb = whiteBall[0];
        switch (move){
            case "R":
                xb =((xb+1)+board[y].length)%board[y].length;whiteBall[1]=xb;
                if (board[y][x].equals("H")) {
                    board[y][((x - 1)+board[y].length)%board[y].length] = " ";
                    key = true;
                }
                else if (board[y][x].equals("R")||board[y][x].equals("Y")||board[y][x].equals("B")){
                    switch (board[y][x]){
                        case "R":
                            points +=10;break;
                        case "Y":
                            points +=5;break;
                        case "B":
                            points -=5;break;
                    }
                    board[y][x] = "X";
                    board[y][((x-1)+board[y].length)%board[y].length] = board[y][x];board[y][x] = "*";
                }
                else{
                    board[y][((x - 1)+board[y].length)%board[y].length] = board[y][x];
                    board[y][x] = "*";
                }
                break;
            case "L":
                xb =((xb-1)+board[y].length)%board[y].length;whiteBall[1]=xb;
                if (board[y][x].equals("H")) {
                    board[y][((x + 1)+board[y].length)%board[y].length] = " ";
                    key = true;
                }
                else if (board[y][x].equals("R")||board[y][x].equals("Y")||board[y][x].equals("B")){
                    switch (board[y][x]){
                        case "R":
                            points +=10;break;
                        case "Y":
                            points +=5;break;
                        case "B":
                            points -=5;break;
                    }
                    board[y][x] = "X";
                    board[y][((x+1)+board[y].length)%board[y].length] = board[y][x];board[y][x] = "*";
                }
                else{
                    board[y][((x + 1)+board[y].length)%board[y].length] = board[y][x];
                    board[y][x] = "*";
                }
                break;
            case "U":
                yb =((yb-1)+board.length)%board.length;whiteBall[0]=yb;
                if (board[y][x].equals("H")) {
                    board[((y+1)+board.length)%board.length][x] = " ";
                    key = true;
                }
                else if (board[y][x].equals("R")||board[y][x].equals("Y")||board[y][x].equals("B")){
                    switch (board[y][x]){
                        case "R":
                            points +=10;break;
                        case "Y":
                            points +=5;break;
                        case "B":
                            points -=5;break;
                    }
                    board[y][x] = "X";
                    board[((y+1)+board.length)%board.length][x] = board[y][x];board[y][x] = "*";
                }
                else{
                    board[((y+1)+board.length)%board.length][x] = board[y][x];
                    board[y][x] = "*";
                }
                break;
            case "D":
                yb =((yb+1)+board.length)%board.length;whiteBall[0]=yb;
                if (board[y][x].equals("H")) {
                    board[((y-1)+board.length)%board.length][x] = " ";
                    key = true;
                }
                else if (board[y][x].equals("R")||board[y][x].equals("Y")||board[y][x].equals("B")){
                    switch (board[y][x]){
                        case "R":
                            points +=10;break;
                        case "Y":
                            points +=5;break;
                        case "B":
                            points -=5;break;
                    }
                    board[y][x] = "X";
                    board[((y-1)+board.length)%board.length][x] = board[y][x];
                    board[y][x] = "*";
                }
                else{
                    board[((y-1)+board.length)%board.length][x] = board[y][x];
                    board[y][x] = "*";
                }break;
        }return board;}
}