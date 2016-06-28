import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class LinkFinder {//a href=".*"
	
	private File file = new File("C:\\Users\\Gavin\\Documents\\4th Quarter\\Platform Dev\\results");
	private FileInputStream stream;
	
	public void processPage(InputStream in){
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	}
	
	public Iterator <String> getLinks(){
		return null;
		
	}
	
	public void makeInputStream(){
		try{
			stream = new FileInputStream(file);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public FileInputStream getStream(){
		return stream;
	}
}
