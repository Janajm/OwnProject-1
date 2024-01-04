import spark.*;

public class NotepadServer {

    public static void main(String[] args) {
        staticFiles.location("/public");
        port(4567);

        get("/", (req, res) -> {
            return "<html><head><title>Simple Notepad</title></head><body>" +
                    "<h1>Simple Notepad</h1>" +
                    "<textarea id='content' rows='20' cols='80'></textarea><br>" +
                    "<button onclick='saveContent()'>Save</button>" +
                    "<script>" +
                    "function saveContent() {" +
                    "    var content = document.getElementById('content').value;" +
                    "    fetch('/save', {" +
                    "        method: 'POST'," +
                    "        body: content" +
                    "    }).then(response => {" +
                    "        if(response.ok) {" +
                    "            alert('Content saved successfully');" +
                    "        } else {" +
                    "            alert('Error saving content');" +
                    "        }" +
                    "    }).catch(error => {" +
                    "        alert('Error: ' + error);" +
                    "    });" +
                    "}" +
                    "</script></body></html>";
        });

        post("/save", (req, res) -> {
            String content = req.body();
            // Logic to handle saving content to a file or database
            // For simplicity, let's just print the content to console
            System.out.println("Content received:\n" + content);
            return "Content saved!";
        });
    }
}
