package jsp.customTL;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ReplaceTagHandler extends TagSupport {    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String input;    
	private String output;
	
	@Override    
	public int doStartTag() throws JspException {    
		try {           
			//Get the writer object for output.           
			JspWriter out = pageContext.getOut();          
			//Perform replace operation on string.           
			out.println(input.replaceAll(input, output));      
		} catch (IOException e) {
			e.printStackTrace();       
		}        return SKIP_BODY;   
	}
	public String getInput() {    
		return input;   
	}   
	public void setInput(String input) {      
		this.input = input;    
	}   
	
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}

}