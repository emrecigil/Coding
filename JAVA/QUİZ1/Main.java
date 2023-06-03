import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            String line;
            String armstrong = "Armstrong numbers up to:";
            String emirp = "Emirp numbers up to:";
            String abundant = "Abundant numbers up to:";
            String asceding = "Ascending order sorting:";
            String descending = "Descending order sorting:";
            while((line = reader.readLine()) != null) {
                if (line.equals(armstrong)){

                    line = reader.readLine();
                    int sayi = Integer.parseInt(line);
                    writer.write("Armstrong numbers up to "+sayi+":");
                    writer.write("\n");
                    for (int i = 0; i < sayi; i++) {
                        int result = 0;
                        int uzunluk = Integer.toString(i).length();
                        for (int j = 0; j <uzunluk ; j++) {
                            String aString = Integer.toString(i);
                            String charIndex = aString.substring(j,j+1);
                            double base = Double.valueOf(charIndex);
                            double power = uzunluk;
                            result = result + (int)Math.pow(base,power);
                        if (result == i && result != 0){
                            writer.write(result + " ");
                            }
                        }
                    }writer.write("\n\n");
                }
                if (line.equals(emirp)) {
                    line = reader.readLine();
                    int sayi = Integer.parseInt(line);
                    writer.write("Emirp numbers up to "+sayi+":");
                    writer.write("\n");
                    for (int i = 10; i <= sayi; i++)
                    {
                        int flag = 0;
                        for(int j=2;j<=i/2;j++){
                            if(i%j==0){
                                flag = 1;
                                break;
                            }
                            }
                        if (flag == 0) {

                            int number = i;
                            int reverse = 0;
                            while(number != 0)
                            {
                                int remainder = number % 10;
                                reverse = reverse * 10 + remainder;
                                number = number/10;}
                                int flag2 = 0;
                            for(int j=2;j<=reverse/2;j++){
                                if(reverse%j==0){
                                    flag2 = 1;
                                    break;
                                }}
                                if (flag2 == 0) {
                                    writer.write(i+ " ");
                                }

                        }

                    }writer.write("\n\n");

                }
                if (line.equals(abundant)){
                    line = reader.readLine();
                    int sayi = Integer.parseInt(line);
                    List<Integer> numbers = new ArrayList<Integer>();
                    writer.write("Abundant numbers up to "+sayi +":");
                    writer.write("\n");
                    for (int i = 0; i <= sayi; i++) {
                        int sum = 0;
                        for (int j = 1; j < i; j++) {
                            if(i % j == 0) {numbers.add(j);}
                        }
                        for(int num : numbers){sum = num + sum; };
                        if (sum > i) {writer.write(i+" ");}
                        numbers.clear();
                    }writer.write("\n\n");
                }
                if (line.equals(asceding)) {
                    writer.write("Ascending order sorting:\n");
                    List<Integer> numbers_array = new ArrayList<Integer>();;
                    while ((line = reader.readLine()) !=null){
                        if (Integer.parseInt(line) == -1) {
                            break;
                        }
                        numbers_array.add(Integer.parseInt(line));
                        Collections.sort(numbers_array);
                        for(int num : numbers_array){
                            writer.write(num + " ");
                        }writer.write("\n");

                    }numbers_array.clear(); writer.write("\n");
                }
                if (line.equals(descending)) {
                    writer.write("Descending order sorting:\n");
                    List<Integer> numbers_array = new ArrayList<Integer>();;
                    while ((line = reader.readLine()) !=null){
                        if (Integer.parseInt(line) == -1) {
                            break;
                        }
                        numbers_array.add(Integer.parseInt(line));
                        Collections.sort(numbers_array);
                        Collections.reverse(numbers_array);
                        for(int num : numbers_array){
                            writer.write(num + " ");
                        }writer.write("\n");

                    }numbers_array.clear(); writer.write("\n");
                }
                if (line.equals("Exit")) {
                    writer.write("Finished...");

                }
            }reader.close();
            writer.close();
        }
        catch (IOException e ){
            e.printStackTrace();
        }
    }

}
/**File file = new File("C:\\Users\\Emre\\Desktop\\input.txt");
 FileInputStream fis = new FileInputStream(file);
 byte[] data = new byte[(int) file.length()];
 fis.read(data);
 String str = new String(data, "UTF-8");
 System.out.println(str);
 fis.close();
 String[] lines= str.split("\n");
 for (int i = 0; i < lines.length; i++) {       } **/