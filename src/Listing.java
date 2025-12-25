import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Listing {
    public static void list(Path path) throws IOException {
        List<String> json=new ArrayList<>(Files.readAllLines(path));
        if(json.size()==2){
            System.out.println("Task list is empty");
        }else{
            for(int i=1;i<=json.size()-2;i++){
                String task=json.get(i);
                //*sample:{"id":"3", "description":"Updated Third task", "status":"todo", "createdAt":"2025-12-23T12:31:18.757726758Z", "updatedAt":"2025-12-24T19:40:04.634664272Z"}
                int start=7;
                int last=start;
                while(task.charAt(last)!='"'){
                    last++;
                }
                int id=Integer.parseInt(task.substring(start,last));
                // finding description
                int noOfColon=0;
                StringBuilder description=new StringBuilder();
                for(int j=0;j<task.length();j++){
                    if(task.charAt(j)==':'){
                        noOfColon++;
                    }
                    if(noOfColon==2){
                        if(task.charAt(j)==',')
                            break;
                        description.append(task.charAt(j));
                    }
                }
                description.delete(0,2);
                description.deleteCharAt(description.length()-1);
                System.out.println("id="+id+" task="+description);
            }
        }
    }
    public static void list_by_status(Path path,String status) throws IOException {
        List<String> json=new ArrayList<>(Files.readAllLines(path));
        if(json.size()==2){
            System.out.println("Task list is empty");
        }else{
            for(int i=1;i<=json.size()-2;i++){
                String task=json.get(i);
                //*sample:{"id":"3", "description":"Updated Third task", "status":"todo", "createdAt":"2025-12-23T12:31:18.757726758Z", "updatedAt":"2025-12-24T19:40:04.634664272Z"}
                int start=7;
                int last=start;
                while(task.charAt(last)!='"'){
                    last++;
                }
                int id=Integer.parseInt(task.substring(start,last));
                // finding description
                int noOfColon=0;
                StringBuilder description=new StringBuilder();
                for(int j=0;j<task.length();j++){
                    if(task.charAt(j)==':')
                        noOfColon++;
                    if(noOfColon==2){
                        if(task.charAt(j)==',')
                            break;
                        description.append(task.charAt(j));
                    }
                }
                description.delete(0,2);
                description.deleteCharAt(description.length()-1);
                noOfColon=0;
                for(int j=0;j<task.length();j++){
                    if(task.charAt(j)==':')
                        noOfColon++;
                    if(noOfColon==3){
                        if(task.charAt(j+2)=='t'&&status.charAt(0)=='t')
                            System.out.println("id="+id+" task="+description);
                        else if(task.charAt(j+2)=='d'&&status.charAt(0)=='d')
                            System.out.println("id="+id+" task="+description);
                        else if(task.charAt(j+2)=='i'&&status.charAt(0)=='i')
                            System.out.println("id="+id+" task="+description);
                        break;
                    }
                }
            }
        }
    }
}
