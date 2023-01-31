import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;


class Handler implements URLHandler{
    ArrayList<String> previousStrings = new ArrayList<String>();
    int size = 0;
    String previousMessage = "";
  
    public String handleRequest(URI url, String messages) {
  
        if (url.getPath().contains("/add-message")) {
            String []strings = url.getQuery().split("=");
            if (strings[0].equals("s")) {
                messages = previousMessage + strings[1] + "\n";
                this.previousMessage = messages;
                /* 
                previousStrings.add(strings[1]);
                size++;
                for (int i = 0; i < size; i++) {
                    previousMessage = previousMessage + previousStrings.get(i) + "\n";
                */
                
                }
            return messages; 
        }
            
        return "404 Not Found!";
       
    }
   
}


class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
