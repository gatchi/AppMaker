package gatchipatchi.appmaker;
import android.app.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.widget.AbsoluteLayout.*;
import gatchipatchi.appmaker.modules.*;

public class Picker
{
	PopupWindow window = new PopupWindow();
	int kind;
	LinearLayout buttonLayout;
	View anchor;
	ViewGroup.LayoutParams params;
	Activity c;
	ViewGroup desktop;
	int x, y;
	
	Picker(Activity c, View anchor, int x, int y)
	{
		this.anchor = anchor;
		this.c = c;
		this.x = x;
		this.y = y;
		this.desktop = (ViewGroup)c.findViewById(R.id.desktop);
	}
	
	Picker(Activity c, View anchor, int x, int y, int kind)
	{
		this(c, anchor, x, y);
		this.kind = kind;
		setType(kind);
		
		buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
		
		window.setContentView(buttonLayout);
		window.setTouchable(true);
		window.setHeight(LayoutParams.WRAP_CONTENT);
		window.setWidth(LayoutParams.WRAP_CONTENT);
		window.setOutsideTouchable(true);
		publish();
	}
	
	void publish()
	{
		window.showAsDropDown(anchor, x, y);
	}
	
	void setType(int kind)
	{
		buttonLayout = new LinearLayout(c);
		
		if (kind == JavaEntity.TOP_LEVEL_ENTITY)
		{
			Button bClass = makeButton(c, "class");
			bClass.setOnClickListener(onButtonClassClick);
			Button bActivity = makeButton(c, "activity");
			bActivity.setOnClickListener(onButtonActivityClick);
			Button bResource = makeButton(c, "resource");
			bResource.setOnClickListener(onButtonResourceClick);

			buttonLayout.addView(bClass);
			buttonLayout.addView(bActivity);
			buttonLayout.addView(bResource);
		}
		else if (kind == JavaEntity.XML_ENTITY)
		{
			Button bView= makeButton(c, "view");
			bView.setOnClickListener(onButtonViewClick);
			Button bWidget= makeButton(c, "widget");
			bWidget.setOnClickListener(onButtonWidgetClick);

			buttonLayout.addView(bView);
			buttonLayout.addView(bWidget);
		}
		else
		{
			TextView tv = new TextView(c);
			tv.setText("oops");
			buttonLayout.addView(tv);
		}
	}
	
	Button makeButton(Activity context, String name)
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
			ClassModule jclass = new ClassModule(c);
			ConstructorModule jconstruct = new ConstructorModule(c);
			jclass.addModule(jconstruct);
			desktop.addView(jclass);
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
	
	View.OnClickListener onButtonViewClick = new View.OnClickListener()
	{
		@Override
		public void onClick(View p1)
		{
			//implement
			window.dismiss();
		}
	};
	
	View.OnClickListener onButtonWidgetClick = new View.OnClickListener()
	{
		@Override
		public void onClick(View p1)
		{
			//implement
			//JavaEntity.create??
			window.dismiss();
		}
	};
}
