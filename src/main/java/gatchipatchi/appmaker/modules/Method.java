package gatchipatchi.appmaker.modules;
import android.app.*;
import android.util.*;
import android.view.*;
import gatchipatchi.appmaker.*;
import org.xmlpull.v1.*;
import android.widget.*;
import java.util.*;

public class Method
{
	ViewGroup gui;
	List<String> canContain;
	String moduleType = "method";
	
	Method(Application context)
	{
		XmlPullParser parser = context.getResources().getXml(R.layout.method);
		AttributeSet attributes = Xml.asAttributeSet(parser);
		gui = new RelativeLayout(context, attributes);
		
		canContain = new ArrayList<String>();
		canContain.add("class");
	}
	
	String getModuleType()
	{
		return moduleType;
	}
}
