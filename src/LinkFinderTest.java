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
//		while(links.hasNext() && answers.hasNext()){
//			System.out.println(links.next() + " = " + answers.next());
//			assertEquals(links.next(), answers.next());
//		}
	}

}
