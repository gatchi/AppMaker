package gatchipatchi.appmaker.modules;
import android.app.*;
import android.util.*;
import android.view.*;
import gatchipatchi.appmaker.*;
import android.widget.*;
import java.util.*;

public class ClassModule
{
	public ViewGroup gui;
	List<String> canContain;
	String moduleType = "class";

	public ClassModule(Activity context)
	{
		LayoutInflater inflater = LayoutInflater.from(context);
		gui = (ViewGroup) inflater.inflate(R.layout.class_layout, null);

		canContain = new ArrayList<String>();
		canContain.add("class");
		canContain.add("method");
	}

	String getModuleType()
	{
		return moduleType;
	}
}
