

interface URLHandler {
    String handleRequest(URI url);
}

class Handler implements URLHandler{
    public String handleRequest(URI url) {
        if (url.getPath().contains("/add-message")) {
            String[] strings = new String[2];
            strings = url.getQuery().split("=");
            String stringToReturn = strings[1];
            return String.valueOf(stringToReturn);
            
           
            }
        }
            
    }


class StringServer {
    public static void main(String[] args) {
        Handler request = new Handler();
        URI url = new URI("http://localhost:4000/add-message?s=Hello");
        request.handleRequest(url);
    }

}

