package gatchipatchi.appmaker;
import android.content.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.widget.AbsoluteLayout.*;
import java.security.cert.*;

public class Picker
{
	PopupWindow window = new PopupWindow();
	int kind;
	LinearLayout vg;
	ViewGroup parent;
	ViewGroup.LayoutParams params;
	Context c;
	int x, y;
	
	Picker(Context c, View parent, int x, int y)
	{
		vg = new LinearLayout(c);
		vg.setBackgroundColor(R.color.red);
		this.parent = (ViewGroup)parent;
		this.c = c;
		this.x = x;
		this.y = y;
		
	}
	Picker(Context c, View parent, int x, int y, int kind)
	{
		this(c, parent, x, y);
		this.kind = kind;
		// The following four lines may be deletable
		int layoutWidth = LayoutParams.WRAP_CONTENT;
		int layoutHeight = LayoutParams.WRAP_CONTENT;
		params = new LinearLayout.LayoutParams(layoutWidth, layoutHeight);
		vg.setLayoutParams(params);
		vg.setOrientation(LinearLayout.HORIZONTAL);
		
		setType(kind);
		
		window.setContentView(vg);
		window.setTouchable(true);
		window.setHeight(LayoutParams.WRAP_CONTENT);
		window.setWidth(LayoutParams.WRAP_CONTENT);
		window.setOutsideTouchable(true);
		publish();
	}
	
	void publish()
	{
		//window.showAtLocation(parent, Gravity.CENTER, 0, 0);
		window.showAsDropDown(parent, x, -100);
	}
	
	void setType(int kind)
	{
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
			window.dismiss();
		}
	};
	
	View.OnClickListener onButtonActivityClick = new View.OnClickListener()
	{
		@Override
		public void onClick(View p1)
		{
			JavaEntity.createActivity();
			window.dismiss();
		}
	};
	
	View.OnClickListener onButtonResourceClick = new View.OnClickListener()
	{
		@Override
		public void onClick(View p1)
		{
			JavaEntity.createResource();
			window.dismiss();
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
