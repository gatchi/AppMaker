package gatchipatchi.appmaker;
import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import java.lang.annotation.*;

public class Picker extends LinearLayout
{
	class PickerButton extends Button
	{
		PickerButton()
		{
			super(context);
			this.setBackground(context.getResources().getDrawable(R.drawable.border));
			this.setTextColor(Color.parseColor("#555555"));
		}
		
		public ViewGroup getTarget()
		{
			return target;
		}
	}
	
	PopupWindow window = new PopupWindow();
	View anchor;
	ViewGroup target;
	ViewGroup.LayoutParams params;
	int xPos = 0;
	int yPos = 0;
	int xOffset;
	int yOffset;
	
	Context context;
	
	Picker(Context context, View anchor, ViewGroup target)
	{
		super(context);
		this.anchor = anchor;
		this.target = target;
		this.context = context;
		setOrientation(LinearLayout.HORIZONTAL);
		window.setContentView(this);
		window.setTouchable(true);
		window.setHeight(LayoutParams.WRAP_CONTENT);
		window.setWidth(LayoutParams.WRAP_CONTENT);
		window.setOutsideTouchable(true);
	}
	
	public void addButton(String text, int buttonId, View.OnClickListener l)
	{
		Button b = new PickerButton();
		b.setText(text);
		b.setId(buttonId);
		b.setOnClickListener(l);
		//b.setBackground(context.getResources().getDrawable(R.drawable.border));
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
		this.xOffset = 0 - this.getWidth() / 2;
		this.yOffset = 0 - this.getHeight();
		window.showAsDropDown(anchor, xPos + xOffset, yPos + yOffset);
	}
	
	@Override
	public void setX(float xTouchPos)
	{
		this.xPos = Math.round(xTouchPos);
	}
	
	@Override
	public void setY(float yTouchPos)
	{
		this.yPos = Math.round(yTouchPos);
	}
}
