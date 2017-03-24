package gatchipatchi.appmaker.modules;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.widget.*;
import java.util.*;

public class ClassModule extends Module
{
	List<String> canContain = new ArrayList<String>();
	String moduleType = "class";
	
	public ClassModule(Context context)
	{
		super(context);
		
		this.setBackground(super.setBorderColor(Color.RED));
		this.setMinimumHeight(100);
		this.setMinimumWidth(100);
		
		TextView name = new TextView(context);
		name.setText(moduleType);
		name.setTextColor(Color.RED);
		this.addView(name);
		
		canContain.add("class");
		canContain.add("method");
		canContain.add("constructor");
	}
}
