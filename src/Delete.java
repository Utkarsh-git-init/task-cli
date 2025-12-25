import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Delete {
    public static void delete(String String_id, Path path) throws IOException {
        List<String> json=new ArrayList<>(Files.readAllLines(path));
        int id=Integer.parseInt(String_id);
        for(int i=1;i<json.size()-1;i++){
            String temp_task=json.get(i);
            //sample "id":"1", ...
            int start=7;
            int last=start;
            while(temp_task.charAt(last)!='"')
                last++;
            int temp_id=Integer.parseInt(temp_task.substring(start,last));
            if(id==temp_id){
                json.remove(i);
                if(i==json.size()-1){//if i=last task then remove ,(comma) from prev task
                    StringBuilder lastTask=new StringBuilder(json.get(json.size()-2));
                    lastTask.deleteCharAt(lastTask.length()-1);
                    json.set(json.size()-2,lastTask.toString());
                }
                break;
            }
        }
        System.out.println("Task deleted successfully (ID:"+id+")");
        Files.write(path,json);
    }
}
