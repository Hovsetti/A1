import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class LinkFinderTest {

	@Test
	public void test() {
		String webValue;
		String answerValue;
		LinkFinder finder =  new LinkFinder();
		finder.makeInputStream();
		finder.processPage(finder.getWebFileStream());
		Iterator<String> links = finder.getLinks();
		finder.makeAnswerStream();
		finder.processAnswers(finder.getAnswerStream());
		Iterator<String> answers = finder.getAnswers();
		while(links.hasNext()){
			webValue = links.next().toString();
			answerValue = answers.next().toString();
			assertEquals(webValue, answerValue);
			System.out.println(webValue + " = " + answerValue);
		}
	}

}
