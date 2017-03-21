package gatchipatchi.appmaker;
import android.content.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.widget.AbsoluteLayout.*;

public class Picker
{
	PopupWindow popup = new PopupWindow();
	LinearLayout vg;
	ViewGroup parent;
	Context c;
	
	Picker(Context c, int kind, View parent)
	{
		vg = new LinearLayout(c);
		vg.setBackgroundColor(R.color.red);
		this.parent = (ViewGroup)parent;
		this.c = c;
		
		LinearLayout.LayoutParams p;
		p = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		vg.setLayoutParams(p);
		vg.setOrientation(LinearLayout.HORIZONTAL);
		
		if (kind == JavaEntity.TOP_LEVEL_ENTITY)
		{
			Button bClass = makeButton(c, "class");
			bClass.setOnClickListener(onButtonClassClick);
			Button bActivity = makeButton(c, "activity");
			bActivity.setOnClickListener(onButtonActivityClick);
			Button bResource = makeButton(c, "resource");
			bResource.setOnClickListener(onButtonResourceClick);
			
			vg.addView(bClass);
			vg.addView(bActivity);
			vg.addView(bResource);
		}
		else
		{
			TextView tv = new TextView(c);
			tv.setText("oops");
			vg.addView(tv);
		}
		
		popup.setContentView(vg);
		popup.setTouchable(true);
		popup.setHeight(LayoutParams.WRAP_CONTENT);
		popup.setWidth(LayoutParams.WRAP_CONTENT);
		popup.setOutsideTouchable(true);
		popup.showAtLocation(parent, Gravity.CENTER, 0, 0);
	}
	
	Button makeButton(Context context, String name)
	{
		Button b = new Button(context);
		b.setText(name);
		return b;
	}
	
	View.OnClickListener onButtonClassClick = new View.OnClickListener()
	{
		@Override
		public void onClick(View p1)
		{
			JavaEntity.createClass();
			Toast.makeText(c,"boop",Toast.LENGTH_SHORT).show();
			popup.dismiss();
		}
	};
	
	View.OnClickListener onButtonActivityClick = new View.OnClickListener()
	{
		@Override
		public void onClick(View p1)
		{
			JavaEntity.createActivity();
			popup.dismiss();
		}
	};
	
	View.OnClickListener onButtonResourceClick = new View.OnClickListener()
	{
		@Override
		public void onClick(View p1)
		{
			JavaEntity.createResource();
			popup.dismiss();
		}
	};
	
	View.OnClickListener bTapListener = new View.OnClickListener()
	{
		@Override
		public void onClick(View p1)
		{
			Button b = (Button)p1;
			
		}
	};
}
