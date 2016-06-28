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
	
	private File file = new File("C:\\Users\\Gavin\\Documents\\4th Quarter\\Platform Dev\\neumont.edu");
	private FileInputStream stream;
	public ArrayList<String> links = new ArrayList<String>();
	
	public static void main(String[] args){
		LinkFinder finder =  new LinkFinder();
		finder.makeInputStream();
		finder.processPage(finder.getStream());
		Iterator<String> it = finder.getLinks();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public void processPage(InputStream in){
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		try{
			String value;
			String pattern = new String("\\s*<(a|A)\\s+(h|H)(r|R)(e|E)(f|F)\\s*=\\s*\"(.*)\".*\\s*.*>.*</a>\\s*");
			Pattern p = Pattern.compile(pattern);
			while(null != (value = reader.readLine())){
				Matcher m = p.matcher(value.toLowerCase());
				if(m.matches()){
					String save = m.group(6);
					links.add(save);
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(NullPointerException a){
			System.out.println("Kill Yourself.");
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
	
	public ArrayList<String> getLinksList(){
		return links;
	}
}
