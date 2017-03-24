package gatchipatchi.appmaker.modules;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.view.*;
import android.widget.*;

public class Module extends RelativeLayout
{
	GradientDrawable border = new GradientDrawable();
	int borderWidth = 2;
	int defaultColor = Color.GRAY;
	
	public Module(Context context)
	{
		super(context);
		this.setPadding(8,2,4,4);
		this.setLayoutParams(Module.generateLayoutParams());
		this.setBackground(setBorderColor(defaultColor));
	}
	
	public static ViewGroup.LayoutParams generateLayoutParams()
	{
		int w = ViewGroup.LayoutParams.WRAP_CONTENT;
		int h = ViewGroup.LayoutParams.WRAP_CONTENT;
		return new ViewGroup.LayoutParams(w, h);
	}
	
	public GradientDrawable setBorderColor(int color)
	{
		border.setStroke(borderWidth, color);
		return border;
	}
}
