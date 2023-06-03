import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("output.txt",true);
        BufferedWriter writer1 = new BufferedWriter(writer);
        try {
            if (args.length > 1) {
                writer1.write("There should be only 1 paremeter\n");
            } else {
                readFile(args[0],writer1);
            }
        }catch (Exception e){
            writer1.write("There should be an input file in the specified path\n");
        }
        writer1.close();
    }

    public static void readFile(String file, BufferedWriter writer1) throws IOException {
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            //while ((line = reader.readLine()) != null) {
                try {

                    if (line == null) {
                        throw new RuntimeException("The input file should not be empty\n");
                    }
                    else{
                        try {
                            if (line.matches("[a-zA-Z ]+")) {
                                writer1.write("The program is running correctly\n");
                            }
                            else {
                                throw new RuntimeException("The input file should not contains unexpected characters\n");
                            }
                        }
                        catch (Exception e) {
                            writer1.write(e.getMessage());
                        }
                    }
                } catch (Exception a) {
                    writer1.write(a.getMessage());
                }
            //}
        }
        catch(IOException e){
            writer1.write("There should be an input file in the specified path\n");
        }
    }
}