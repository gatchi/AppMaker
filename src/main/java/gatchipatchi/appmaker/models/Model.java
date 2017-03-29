package gatchipatchi.appmaker.models;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class Model extends LinearLayout
{
	GradientDrawable border = new GradientDrawable();
	int borderWidth = 2;
	int defaultColor = Color.GRAY;
	
	List<String> canContain = new ArrayList<String>();
	
	public Model(Context context)
	{
		super(context);
		this.setPadding(8,2,4,4);
		this.setBackground(setBorderColor(defaultColor));
		setId(generateViewId());
	}
	
	void addModel(int anchorId, Model child)
	{
		addView(child);
//		RelativeLayout.LayoutParams childParams;
//		childParams = (RelativeLayout.LayoutParams)child.getLayoutParams();
//		childParams.addRule(RelativeLayout.BELOW, anchorId);
//		child.setLayoutParams(childParams);
	}
	
//	void addModel(int anchorId, Model child, int width)
//	{
//		addView(child);
//		LayoutParams childParams;
//		childParams = new LayoutParams(width, LayoutParams.WRAP_CONTENT);
//		childParams.addRule(RelativeLayout.BELOW, anchorId);
//		child.setLayoutParams(childParams);
//	}
	
	public GradientDrawable setBorderColor(int color)
	{
		border.setStroke(borderWidth, color);
		return border;
	}
}
