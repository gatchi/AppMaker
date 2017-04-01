package gatchipatchi.appmaker;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.LinearLayout.*;
import gatchipatchi.appmaker.models.*;
import java.util.*; 

public class OverviewActivity extends Activity 
{
	static final int CLASS_BUTTON = 1;
	
	class Box extends LinearLayout
	{
		Picker picker;
		
		Box(Context context, int borderColor)
		{
			super(context);
			GradientDrawable border = (GradientDrawable)getResources().getDrawable(R.drawable.border);
			setBackgroundDrawable(border);
			border.setStroke(2, borderColor);
			setOrientation(VERTICAL);
		}
		
		Picker getPicker()
		{
			return picker;
		}
		
		void setPicker(Picker picker)
		{
			this.picker = picker;
		}
	}
	
	Picker desktopPicker;
	View anchor;
	ViewGroup mainGroup;
	View desktop;
	View welcomeMessage;
	ArrayList<Integer> displayedNames = new ArrayList<Integer>();
	boolean namesAreVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_layout);
		
		anchor = findViewById(R.id.anchor);
		mainGroup = (ViewGroup)findViewById(R.id.main_group);
		desktop = findViewById(R.id.desktop);
		welcomeMessage = findViewById(R.id.welcome_message);
		
		desktopPicker = new Picker(this, anchor, mainGroup);
		desktopPicker.addButton("class", CLASS_BUTTON, pickerButtonListener);
		desktopPicker.addButton("activity", 0, pickerButtonListener);  // not implemented
		desktopPicker.addButton("resource", 0, pickerButtonListener);  // not implemented
		desktop.setOnTouchListener(touchListener);
    }

	void clearHint()
	{
		if (welcomeMessage.isShown())
			welcomeMessage.setVisibility(View.GONE);
	}

	Button makeButton(Context context, String text, int id)
	{
		Button b = new Button(context);
		b.setText(text);
		b.setId(id);
		return b;
	}
	
	public void toggleNames(View view)
	{
		View v;
		if (namesAreVisible)
		{
			for(int i=0; i<displayedNames.size(); i++)
			{
				v = findViewById(displayedNames.get(i));
				v.setVisibility(View.GONE);
			}
			namesAreVisible = false;
		}
		else
		{
			for(int i=0; i<displayedNames.size(); i++)
			{
				v = findViewById(displayedNames.get(i));
				v.setVisibility(View.VISIBLE);
			}
			namesAreVisible = true;
		}
	}
	
	View.OnClickListener pickerButtonListener = new View.OnClickListener()
	{
		@Override
		public void onClick(View button)
		{
			if (button.getId() == CLASS_BUTTON)
			{
				Box classBox = new Box(OverviewActivity.this, Color.RED);
				classBox.setMinimumHeight(100);
				classBox.setMinimumWidth(200);
				
				Picker boxPicker = new Picker(OverviewActivity.this, anchor, classBox);
				boxPicker.addButton("class", CLASS_BUTTON, pickerButtonListener);
				classBox.setPicker(boxPicker);
				classBox.setOnTouchListener(touchListener);
				
				Picker.PickerButton pb = (Picker.PickerButton)button;
				ViewGroup target = pb.getTarget();
				target.addView(classBox);
				desktopPicker.dismiss();
			}
			else
			{
				OverviewActivity.popMesg(OverviewActivity.this, "not implemented");
			}
		}
	};
	
	View.OnTouchListener touchListener = new View.OnTouchListener() 
	{
		@Override
		public boolean onTouch(View v, MotionEvent e)
		{
			if (e.getAction() == MotionEvent.ACTION_UP)
			{
				clearHint();
				
				Picker p;
				if (v.getId() == R.id.desktop)
					p = desktopPicker;
				else
				{
					Box box = (Box)v;
					p = box.getPicker();
				}
				if (p.isShowing())
					p.dismiss();
				else
				{
					p.setX(e.getX());
					p.setY(e.getY());
					p.publish();
				}
			}
			return true;
		}
	};
	
	public static void popMesg(Context context, String mesg)
	{
		Toast t = Toast.makeText(context, mesg, Toast.LENGTH_SHORT);
		t.show();
	}
}
