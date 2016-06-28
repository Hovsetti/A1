import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkFinder {//<a href=".*">
	
	private File file = new File("C:\\Users\\Gavin\\Documents\\4th Quarter\\Platform Dev\\results");
	private FileInputStream stream;
	public ArrayList<String> links;
	
	public void processPage(InputStream in){
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		try{
			String value = reader.readLine();
			String pattern = new String("<a\\shref=\"(.*)\">");
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(value);
			if(m.matches()){
				String save = m.group(1);
				links.add(save);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public Iterator <String> getLinks(){
		return links.iterator();
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
