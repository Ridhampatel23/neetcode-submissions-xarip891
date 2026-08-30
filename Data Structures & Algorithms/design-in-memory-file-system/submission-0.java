class FileSystem {

    class FileNode{
        Map<String, FileNode> files = new HashMap<>();
        String content = "";
        boolean isFile = false;

    }   

        FileNode root;
        public FileSystem() {
        root = new FileNode(); 
    }
    
    public List<String> ls(String path) {
        FileNode f = root;
        List<String> res = new ArrayList<>();

        if (!path.equals("/")){
            String[] directories = path.split("/");
            for (int i = 1; i < directories.length; i++){
                f = f.files.get(directories[i]);
            }
            if(f.isFile){
                res.add(directories[directories.length - 1]);
                return res;
            }
        }
        List<String> rootRes = new ArrayList<>(f.files.keySet());
        Collections.sort(rootRes);
        return rootRes;
    }
    
    public void mkdir(String path) {

        FileNode f = root; 
        String[] parts = path.split("/");
        for (int i = 1; i < parts.length; i++){
            if (!f.files.containsKey(parts[i])){
                f.files.put(parts[i], new FileNode());
            }
            f = f.files.get(parts[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        FileNode f = root;
        String[] parts = filePath.split("/");
        for (int i = 1; i < parts.length - 1; i++){
            f = f.files.get(parts[i]);
        }

        if(!f.files.containsKey(parts[parts.length - 1])){
                f.files.put(parts[parts.length - 1], new FileNode());
        }
        f = f.files.get(parts[parts.length - 1]);
        f.content = f.content + content;
        f.isFile = true;
    }
    
    public String readContentFromFile(String filePath) {
        FileNode f = root;
        String[] parts = filePath.split("/");
        for (int i = 1; i < parts.length - 1; i++) {
            f = f.files.get(parts[i]);
        }
        return f.files.get(parts[parts.length - 1]).content;
        
    }
}