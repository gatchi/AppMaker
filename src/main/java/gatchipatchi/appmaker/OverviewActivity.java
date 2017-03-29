package gatchipatchi.appmaker;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import gatchipatchi.appmaker.models.*;
import org.apache.http.client.utils.*;
import android.widget.LinearLayout.*; 

public class OverviewActivity extends Activity 
{
	static final int CLASS_BUTTON = 1;
	
	Picker picker;
	View anchor;
	ViewGroup desktop;
	View welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_layout);
		
		anchor = findViewById(R.id.anchor);
		desktop = (ViewGroup)findViewById(R.id.desktop);
		welcomeMessage = findViewById(R.id.welcome_message);
		
		picker = new Picker(this, anchor);
		picker.addNewButton("class", CLASS_BUTTON, onButtonClickListener);
		picker.addNewButton("activity", 0, onButtonClickListener);  // not implemented
		picker.addNewButton("resource", 0, onButtonClickListener);  // not implemented
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
	
	View.OnClickListener onButtonClickListener = new View.OnClickListener()
	{
		@Override
		public void onClick(View button)
		{
			if (button.getId() == CLASS_BUTTON)
			{
				ClassModel mClass = new ClassModel(OverviewActivity.this);
				ConstructorModel mConstruct = new ConstructorModel(OverviewActivity.this);
				LayoutParams pClass = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				pClass.setLayoutDirection(LinearLayout.VERTICAL);
				LayoutParams pConstruct = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
				mClass.addConstructor(mConstruct);
				mConstruct.setLayoutParams(pConstruct);
				mClass.setLayoutParams(pClass);
				mClass.setOrientation(LinearLayout.VERTICAL);
				desktop.addView(mClass);
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
