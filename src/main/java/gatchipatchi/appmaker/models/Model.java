package gatchipatchi.appmaker.models;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class Model extends RelativeLayout
{
	RelativeLayout.LayoutParams layoutParams;
	GradientDrawable border = new GradientDrawable();
	int borderWidth = 2;
	int defaultColor = Color.GRAY;
	
	List<String> canContain = new ArrayList<String>();
	
	public Model(Context context)
	{
		super(context);
		this.setPadding(8,2,4,4);
		layoutParams = Model.generateLayoutParams();
		this.setBackground(setBorderColor(defaultColor));
		setId(generateViewId());
	}
	
	public static RelativeLayout.LayoutParams generateLayoutParams()
	{
		int w = RelativeLayout.LayoutParams.WRAP_CONTENT;
		int h = RelativeLayout.LayoutParams.WRAP_CONTENT;
		return new RelativeLayout.LayoutParams(w, h);
	}
	
	public void addModel(int anchorId, Model child)
	{
		addView(child);
		RelativeLayout.LayoutParams childParams;
		childParams = (RelativeLayout.LayoutParams)child.getLayoutParams();
		childParams.addRule(RelativeLayout.BELOW, anchorId);
		child.setLayoutParams(childParams);
	}
	
	public GradientDrawable setBorderColor(int color)
	{
		border.setStroke(borderWidth, color);
		return border;
	}
	
	public void setWidth(int width)
	{
		layoutParams.width = width;
	}
}
