import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Add {
    static void add(String description, Path path) throws IOException {
        List<String> json=new ArrayList<>(Files.readAllLines(path));
        //calculate id
        int id;
        if(json.size()==2){
            id=1;
        }else{
            String lastTask=json.get(json.size()-2);
            //sample {"id":"1", ...
            int start=7;
            int last=start;
            while(lastTask.charAt(last)!='"'){
                last++;
            }
            id=Integer.parseInt(lastTask.substring(start,last));
            // adding ,(comma) at the end of last line
            lastTask+=",";
            json.remove(json.size()-2);
            json.add(json.size()-1,lastTask);
        }
        id++;
        String task="{\"id\":\""+id+"\", \"description\":\""+description+"\", \"status\":\"todo\""+", \"createdAt\":\""+ Instant.now()+"\", \"updatedAt\":\"null\"}";
        json.add(json.size()-1,task);
        Files.write(path,json);
        System.out.println("Task added successfully (ID:"+id+")");
    }
}
