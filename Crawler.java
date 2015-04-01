
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;


public class Crawler  {
	
	Thread thr;
	String key;
	
	public static int a;
	     Crawler() {
	   
	   }
	public void match (){
		int count = getResult().size();
    	if(count ==0){
    	    System.out.println("\nNo result found!");
    	}else{
    	    System.out.println("\nFound " + count + " result!\n");
    	    for (String matched :getResult()){
    		System.out.println("Found : " + matched);
    	    }
    	}
		
	}
	public Runnable run(String str) {
        
        findDir(new File(str), "warfana.txt");
       
		return thr;
	
       
        
    }

 
  private String SearchFile;
  private List<String> result = new ArrayList<String>();
 
  public String getFileNameToSearch() {
	return SearchFile;
  }
 
  public void setFileNameToSearch(String fileNameToSearch) {
	this.SearchFile = fileNameToSearch;
  }
 
  public List<String> getResult() {
	return result;
  }
 
  public static void main(String[] args) {
 
	Crawler fileSearch = new Crawler();
	   
	   File[] FilePaths;
	   FilePaths = File.listRoots();
       int count=0;
       
       FilePaths = File.listRoots();
       for(File path:FilePaths)
       {
       	System.out.println("Searching in..");
          System.out.println(path);
       
        String str =   path.toString();
       File dir = new File(str);
       File[] files = dir.listFiles();
       FileFilter fileFilter = new FileFilter() {
          public boolean accept(File file) {
             return file.isDirectory();
          }
       };
       files = dir.listFiles(fileFilter);
       System.out.println(files.length);
       if (files.length == 0) {
          System.out.println("Either dir does not exist or is not a directory");
       }
       else {
          for (int i=0; i< files.length; i++) {
        	  count++;
           //  File filename = files[i];
           // System.out.println(filename.toString());
          }
       }}
       System.out.println(count);
       ArrayList<Thread> thread = new ArrayList<Thread>(count);
       FilePaths = File.listRoots();
       
       // for each pathname in pathname array
         
      	 //  Thread t = new Thread(fileSearch.run(str));
      	  // thread.add(t);
      	   //t.start();
      	   
      	 for(File path:FilePaths)
         {
         	System.out.println("Searching in..");
            System.out.println(path);
         
          String str =   path.toString();
         File dir = new File(str);
         File[] files = dir.listFiles();
         FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
               return file.isDirectory();
            }
         };
         files = dir.listFiles(fileFilter);
        // System.out.println(files.length);
         if (files.length == 0) {
            System.out.println("Either dir does not exist or is not a directory");
         }
         else {
            for (int i=0; i< files.length; i++) {
            	 File filename = files[i];
                 System.out.println(filename.toString());
                 Thread thr1 = new Thread(fileSearch.run(filename.toString()));
             	 thread.add(thr1);
             	 thr1.start();
             	   
            }
         }}
       
      	fileSearch.match();
  }
 

public void findDir(File dir, String SearchFile) {
 
	setFileNameToSearch(SearchFile);
 
	if (dir.isDirectory()) {
	    search(dir);
	} else {
	    System.out.println(dir.getAbsoluteFile() + " is not a directory!");
	}
 
  }
 
  private void search(File file) {
 
	if (file.isDirectory()) {
	  System.out.println("Searching directory ... " + file.getAbsoluteFile());
 
            //do you have permission to read this directory?	
	    if (file.canRead()) {
	    	try {
		for (File check : file.listFiles()) {
		    if (check.isDirectory()) {
			search(check);
		    } else {
			if (getFileNameToSearch().equals(check.getName().toLowerCase())) {			
			    result.add(check.getAbsoluteFile().toString());
		    }
 
		}
	    }
	    	}
	    	catch (NullPointerException npe) {
	    	    
	    	}
 
	 } else {
		System.out.println(file.getAbsoluteFile() + "Permission Denied");
	 }
      }
 
  }


 
}

