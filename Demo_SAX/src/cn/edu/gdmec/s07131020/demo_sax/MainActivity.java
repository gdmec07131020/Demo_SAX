package cn.edu.gdmec.s07131020.demo_sax;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser parser=factory.newSAXParser();
			
			XMLReader reader=parser.getXMLReader();
			MyHandler handler=new MyHandler();
			reader.setContentHandler(handler);
			
			parser.parse(getAssets().open("users.xml"),handler);
		List<User> users=handler.getUsers();
		for(User user:users){
			Log.i("info",user.toString());
		}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}

	

}
