package gatchipatchi.appmaker;
import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import gatchipatchi.appmaker.modules.*;

public class Picker extends LinearLayout
{
	static final int BUTTON_CLASS = 1;
	
	PopupWindow window = new PopupWindow();
	View anchor;
	int xOffset = 0;
	int yOffset = 0;
	ViewGroup.LayoutParams params;
	ViewGroup desktop;
	
	Context context;
	
	Picker(Context context, View anchor, ViewGroup parent)
	{
		super(context);
		this.anchor = anchor;
		this.context = context;
		this.desktop = parent;
		setOrientation(LinearLayout.HORIZONTAL);
		window.setContentView(this);
		window.setTouchable(true);
		window.setHeight(LayoutParams.WRAP_CONTENT);
		window.setWidth(LayoutParams.WRAP_CONTENT);
		window.setOutsideTouchable(true);
		publish();
	}
	
	public void addNewButton(String text, int id)
	{
		Button b = new Button(context);
		b.setText(text);
		b.setId(id);
		b.setOnClickListener(onButtonClick);
		addView(b);
	}
	
	void dismiss()
	{
		window.dismiss();
	}
	
	boolean isShowing()
	{
		return window.isShowing();
	}
	
	void publish()
	{
		// not sure about these names
		window.showAsDropDown(anchor, xOffset, yOffset);
	}
	
	@Override
	public void setX(float xPos)
	{
		xOffset = Math.round(xPos);
	}
	
	@Override
	public void setY(float yPos)
	{
		yOffset = Math.round(yPos);
	}
	
	
	View.OnClickListener onButtonClick = new View.OnClickListener()
	{
		@Override
		public void onClick(View button)
		{
			if (button.getId() == BUTTON_CLASS)
			{
				ClassModule jclass = new ClassModule(context);
				ConstructorModule jconstruct = new ConstructorModule(context);
				jclass.addModule(jconstruct);
				desktop.addView(jclass);
				dismiss();
			}
			else
			{
				OverviewActivity.popMesg(context, "not implemented");
			}
		}
	};
}
