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

public class LinkFinder {
	
	private File file = new File("C:\\Users\\Gavin\\Documents\\4th Quarter\\Platform Dev\\neumont.edu");
	private FileInputStream stream;
	public ArrayList<String> links = new ArrayList<String>();
	public ArrayList<String> answers = new ArrayList<String>();
	private File answerFile = new File("C:\\Users\\Gavin\\Documents\\4th Quarter\\Platform Dev\\results");
	private FileInputStream answerStream;
	
	public static void main(String[] args){
		LinkFinder finder =  new LinkFinder();
		finder.makeInputStream();
		finder.processPage(finder.getWebFileStream());
		Iterator<String> links = finder.getLinks();
		finder.makeAnswerStream();
		finder.processAnswers(finder.getAnswerStream());
		Iterator<String> answers = finder.getAnswers();
		int i = 1;
		while(links.hasNext() && answers.hasNext()){
			System.out.println(i + " : " + answers.next() + " = "+ links.next());
			i++;
		//	System.out.println(links.next());
		}
	}
	
	public void processPage(InputStream in){
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		try{
			String value;
			//String pattern = new String("\\s*<\\s*[aA]\\s+[hH][rR][eE][fF]\\s*=\\s*\"(.*)\".*</a>");
			String pattern = new String(".*<\\s*[aA]\\s+[hH][rR][eE][fF]\\s*=\\s*\"([^\"]*)\".*>");
			Pattern p = Pattern.compile(pattern);
			while(null != (value = reader.readLine())){
				Matcher m = p.matcher(value.toLowerCase());
				if(m.matches()){
					String save = m.group(1);
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
	
	public void processAnswers(InputStream in){
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		try{
			String value;
			while(null != (value = reader.readLine())){
				answers.add(value);
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
	
	public Iterator <String> getAnswers(){
		return answers.iterator();
	}
	
	public void makeInputStream(){
		try{
			stream = new FileInputStream(file);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void makeAnswerStream(){
		try{
			answerStream = new FileInputStream(answerFile);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public FileInputStream getWebFileStream(){
		return stream;
	}
	
	public ArrayList<String> getLinksList(){
		return links;
	}
	
	public FileInputStream getAnswerStream(){
		return answerStream;
	}
}
