import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader= null;
        String rootPath = System.getProperty("user.dir");
        String filePath = rootPath.replace("\\","/")+"/data/data.in";
        // cách sử dụng try-catch
        try{
            FileReader fileReader  = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("Error when reading file" + e.getMessage());
        }finally { // sử dụng finally để close file
            if(bufferedReader!=null){
                try{
                    bufferedReader.close();
                }catch (IOException e){
                    System.out.println("Error when closing file" + e.getMessage());
                }
            }
        }
        // cách sử dụng try-with-resources
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line ;
            while ((line = reader.readLine())!= null){
                System.out.println(line);
            }
        }catch (IOException e1){
            System.out.println("Error when reading file" + e1.getMessage());
        }
    }
    public static void readFile(String fileName) throws IOException { // sử dụng throws để khia báo phươngt hức có thể ném ra ngoại lệ IOException
        FileReader file = new FileReader(fileName);
        BufferedReader fileInput = new BufferedReader(file);
    }
}