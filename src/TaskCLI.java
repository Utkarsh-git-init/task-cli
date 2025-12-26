import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TaskCLI {
    public static void main(String[] args) throws IOException {
        if(args.length==0){
            System.out.println("No command found");
            return ;
        }
        Path path= Path.of("task.json");
        if(!Files.exists(path)){
            Files.createFile(path);
            Files.writeString(path, """
                    [
                    ]
                    """);
        }
        switch(args[0]){
            case "add":
                Add.add(args[1],path);
                break;
            case "update":
                Update.update(args[1],args[2],path);
                break;
            case "list":
                if(args.length==1)
                    Listing.list(path);
                else
                    Listing.list_by_status(path,args[1]);
                break;
            case "delete":
                Delete.delete(args[1],path);
                break;
            case "mark-in-progress":
                Mark.mark(args[1],path,"in_progress");
                break;
            case "mark-done":
                Mark.mark(args[1],path,"done");
                break;
            default:
                System.out.println("Invalid Command");
        }
    }
}
