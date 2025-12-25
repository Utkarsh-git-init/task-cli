import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Mark {
    public static void mark(String String_id, Path path,String status) throws IOException {
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
        StringBuilder updatedTask=new StringBuilder();
        for(int i=0,countOfComma=0;i<task.length();i++){
            if(task.charAt(i)==',')
                countOfComma++;
            if(countOfComma==2){
                break;
            }
            updatedTask.append(task.charAt(i));
        }
        if(status.equals("done")){
            updatedTask.append(", \"status\":\"done\"");
            System.out.println("Task marked as done (ID:"+id+")");
        }
        else if(status.equals("in_progress")) {
            updatedTask.append(", \"status\":\"in-progress\"");
            System.out.println("Task marked as in-progress (ID:"+id+")");
        }
        for(int i=0,countOfComma=0;i<task.length();i++){
            if(task.charAt(i)==',')
                countOfComma++;
            if(countOfComma>=3){
                updatedTask.append(task.charAt(i));
            }
        }
        json.set(itr,updatedTask.toString());
        Files.write(path,json);
    }
}
