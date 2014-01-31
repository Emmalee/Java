import static org.junit.Assert.*;

import java.util.Queue;

import org.junit.Test;


public class HtmlValidatorTest {

	@Test
	public void test1() {
		HtmlValidator validator = new HtmlValidator(HtmlTag.tokenize("<b> bold text <i> bold and italic </i> just bold </b>)"));
		validator.validate();
		
	}
	 @Test
     public void test2() { 
		 System.out.println("____________________");
		 HtmlValidator validator = new HtmlValidator(HtmlTag.tokenize("<html><b> bold text <i> italic text </i> oops, forgot to close the rest"));
		 validator.validate();  
     }
	 
	 @Test
	 public void test3(){
		 System.out.println("____________________");
		 HtmlValidator validator = new HtmlValidator(HtmlTag.tokenize("<b> bold text <i> bold and italic </b> oops, closed bold first </i>"));
		 validator.validate();
	 }

	 @Test
	 public void test4(){
		 System.out.println("____________________");
		 HtmlValidator validator = new HtmlValidator(HtmlTag.tokenize("<b> some text <i> </b> </i> </b> </html>"));
		 validator.validate();
	 }
	
	@Test
	public void test5(){
			System.out.println("____________________");
			HtmlValidator validator = new HtmlValidator(HtmlTag.tokenize("</html>"));
			validator.validate();
	}
			 
	@Test
	public void test6(){
			System.out.println("____________________");
			HtmlValidator validator = new HtmlValidator(HtmlTag.tokenize("This file intentionally has no tags in it."));
				 validator.validate();
	}
				 
	@Test
	 public void test7(){
			System.out.println("____________________");
			HtmlValidator validator = new HtmlValidator(HtmlTag.tokenize("<!doctype html public '-//W3C//DTD HTML 4.01 Transitional//EN'>"
				+"<!-- Valid example from spec -->"
				+"<html>"
				+"<head>"
				+"<title>Turtles are cool</title>"
				+"<meta http-equiv= 'Content-Type' content='text/html'>"
				+"<link href='style.css' type='text/css' />"
				+"</head>"
				+"<body>"
				+"<p>Turtles swim in the <a href='http://ocean.com/'>ocean</a>.</p>"
				+"<p>Some turtles are over 100 years old.  Here is a picture of a turtle:"
				+"<img src='images/turtle.jpg' width='100' height='100'>"
				+"</p>"
				+"</body>"
				+"</html>"));
			validator.validate();
	}
	
	@Test
	public void test8(){
			System.out.println("____________________");
            HtmlValidator validator = new HtmlValidator(HtmlTag.tokenize("<!doctype html public '-//W3C//DTD HTML 4.01 Transitional//EN'>"
                + "<!-- Invalid example from spec -->"
                + "<html>"
                + "<head>"
                + "<title>Turtles are cool "
                + "<meta http-equiv='Content-Type' content='text/html'>"
                + "<link href='style.css' type='text/css' rel='stylesheet' />"
                + "</head>"
                + "</head>"
                + ""
                + "<body>"
                + "<p>Turtles swim in the <a href='http://ocean.com>ocean</a>.</p>"
                + "</br>"
                + "<p>Some turtles are over 100 years old.  Here is a picture of a turtle:"
                + "<img src='images/turtle.jpg' width='100' height='100'> </p>"
                + "</html>"));
			validator.validate();
	}
	
	
}