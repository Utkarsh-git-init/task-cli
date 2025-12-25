import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Update {
    public static void update(String String_id, String newDescription, Path path) throws IOException {
        List<String> json=new ArrayList<>(Files.readAllLines(path));
        int id=Integer.parseInt(String_id);
        int itr=1;
        for(;itr<json.size()-1;itr++){
            String temp_task=json.get(itr);
            //sample "id":"1", ...
            int start=7;
            int last=start;
            while(temp_task.charAt(last)!='"')
                last++;
            int temp_id=Integer.parseInt(temp_task.substring(start,last));
            if(id==temp_id){
                break;
            }
        }
        String task=json.get(itr);
        //*sample:{"id":"3", "description":"Updated Third task", "status":"todo", "createdAt":"2025-12-23T12:31:18.757726758Z", "updatedAt":"2025-12-24T19:40:04.634664272Z"}
        StringBuilder updatedTask=new StringBuilder("{\"id\":\""+id+"\", \"description\":\""+newDescription+"\"");
        for(int i=0,countOfComma=0;i<task.length();i++){
            if(task.charAt(i)==',')
                countOfComma++;
            if(countOfComma==2||countOfComma==3){
                updatedTask.append(task.charAt(i));
            }
        }
        updatedTask.append(", \"updatedAt\":\""+ Instant.now()+"\"}");
        if(task.charAt(task.length()-1)==',')
            updatedTask.append(',');
        json.set(itr,updatedTask.toString());
        Files.write(path,json);
    }
}
