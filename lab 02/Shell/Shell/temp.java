import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Less extends GenericCommand {

    @Override
    public void handleCommand(String[] args) {
        if (args.length<=1 || args[1] == null) {
            System.out.println("file name missing");
        } else {
            File file = new File(args[1]);
            if(file.isFile()){
                readFileContent(file);
                commandCompleted();
            }else{
                System.out.println("file not found");
            }
        }
    }


    public void readFileContent(File file) {
        String fileName = file.getName();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));   
            String sb = null;
            
            sb = br.readLine();
    
            while (sb != null) {
                System.out.println(sb);
                sb = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.err.println(e);
        }        
    }




}