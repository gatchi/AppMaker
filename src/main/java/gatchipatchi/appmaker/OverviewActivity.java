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
		Box(Context context, int borderColor)
		{
			super(context);
			GradientDrawable border = (GradientDrawable)getResources().getDrawable(R.drawable.border);
			setBackgroundDrawable(border);
			border.setStroke(2, borderColor);
			setOrientation(VERTICAL);
		}
	}
	
	Picker picker;
	View anchor;
	ViewGroup desktop;
	View welcomeMessage;
	ArrayList<Integer> displayedNames = new ArrayList<Integer>();
	boolean namesAreVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_layout);
		
		anchor = findViewById(R.id.anchor);
		desktop = (ViewGroup)findViewById(R.id.desktop);
		welcomeMessage = findViewById(R.id.welcome_message);
		
		picker = new Picker(this, anchor);
		picker.addNewButton("class", CLASS_BUTTON, pickerListener);
		picker.addNewButton("activity", 0, pickerListener);  // not implemented
		picker.addNewButton("resource", 0, pickerListener);  // not implemented
		desktop.setOnTouchListener(deskTouchListener);
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
	
	View.OnClickListener pickerListener = new View.OnClickListener()
	{
		@Override
		public void onClick(View button)
		{
			if (button.getId() == CLASS_BUTTON)
			{
				Box classBox = new Box(OverviewActivity.this, Color.RED);
				classBox.setMinimumHeight(100);
				classBox.setMinimumWidth(200);
				ClassModel mClass = new ClassModel(OverviewActivity.this);
				LayoutParams pClass = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				desktop.addView(classBox);
				picker.dismiss();
			}
			else
			{
				OverviewActivity.popMesg(OverviewActivity.this, "not implemented");
			}
		}
	};
	
	View.OnTouchListener deskTouchListener = new View.OnTouchListener() 
	{
		@Override
		public boolean onTouch(View v, MotionEvent e)
		{
			if (e.getAction() == MotionEvent.ACTION_UP)
			{
				clearHint();
				
				if (picker.isShowing())
					picker.dismiss();
				else
				{
					picker.setX(e.getX());
					picker.setY(e.getY());
					picker.publish();
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
