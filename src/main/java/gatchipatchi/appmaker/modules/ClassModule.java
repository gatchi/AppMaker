package gatchipatchi.appmaker.modules;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.widget.*;
import java.util.*;

public class ClassModule extends RelativeLayout
{
	List<String> canContain = new ArrayList<String>();
	String moduleType = "class";
	
	public ClassModule(Context context)
	{
		super(context);
		RelativeLayout.LayoutParams params;
		int w = RelativeLayout.LayoutParams.WRAP_CONTENT;
		int h = RelativeLayout.LayoutParams.WRAP_CONTENT;
		params = new RelativeLayout.LayoutParams(w, h);
		this.setLayoutParams(params);
		
		GradientDrawable border = new GradientDrawable();
		border.setStroke(2, Color.RED);
		this.setBackground(border);
		this.setPadding(8,2,4,4);
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
