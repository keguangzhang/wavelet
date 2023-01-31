import java.io.IOException;
import java.net.URI;



class Handler implements URLHandler{
    String previousMessage = "";
  
    public String handleRequest(URI url) {
        
        if (url.getPath().contains("/add-message")) {
            String []strings = url.getQuery().split("=");
            if (strings[0].equals("s")) {
                String message = strings[1] + "\n";
                
                String newMessage = previousMessage.concat(message);
                System.out.println(newMessage);
                return newMessage;
            }
            
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