package gatchipatchi.appmaker;
import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import gatchipatchi.appmaker.models.*;

public class Picker extends LinearLayout
{
	PopupWindow window = new PopupWindow();
	View anchor;
	ViewGroup.LayoutParams params;
	ViewGroup desktop; // remove the need for this object
	int xPos = 0;
	int yPos = 0;
	
	// these need to position the middle of the view,
	// not the top left
	int xOffset = -150;
	int yOffset = -80;
	
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
	}
	
	public void addNewButton(String text, int id, View.OnClickListener l)
	{
		Button b = new Button(context);
		b.setText(text);
		b.setId(id);
		b.setOnClickListener(l);
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
		window.showAsDropDown(anchor, xPos + xOffset, yPos + yOffset);
	}
	
	@Override
	public void setX(float xPos)
	{
		this.xPos = Math.round(xPos);
		this.xOffset = 0 - this.getWidth() / 2;
	}
	
	@Override
	public void setY(float yPos)
	{
		this.yPos = Math.round(yPos);
		this.yOffset = 0 - this.getHeight();
	}
}
