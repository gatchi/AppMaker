package gatchipatchi.appmaker;

import android.content.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class Module
{
	public RelativeLayout gui;
	List<String> canContain;
	String moduleType;
	
	public void initialize(Context context, int layoutId, List<String> canContain, String moduleType)
	{
		LayoutInflater inflater = LayoutInflater.from(context);
		this.gui = (RelativeLayout) inflater.inflate(R.layout.class_layout, null);
		this.canContain = canContain;
		this.moduleType = moduleType;
	}
	
	public void addModule(Module module)
	{
		gui.addView(module.gui);
	}
}
