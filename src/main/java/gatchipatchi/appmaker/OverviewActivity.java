package gatchipatchi.appmaker;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import gatchipatchi.appmaker.models.*;
import org.apache.http.client.utils.*; 

public class OverviewActivity extends Activity 
{
	Picker picker;
	View anchor;
	ViewGroup desktop;
	View welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_layout);
		
		desktop = (ViewGroup)findViewById(R.id.desktop);
		desktop.setOnTouchListener(deskTouchListener);
		
		anchor = findViewById(R.id.anchor);
		welcomeMessage = findViewById(R.id.welcome_message);
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
	
	
	View.OnTouchListener deskTouchListener = new View.OnTouchListener() 
	{
		@Override
		public boolean onTouch(View v, MotionEvent e)
		{
			if (e.getAction() == MotionEvent.ACTION_DOWN)
			{
				clearHint();
				
				if (picker == null)
				{
					picker = new Picker(OverviewActivity.this, anchor, desktop);
					picker.addNewButton("class", Picker.BUTTON_CLASS);
					picker.addNewButton("activity", 0);  // not implemented
					picker.addNewButton("resource", 0);  // not implemented
				}
				
				if (picker.isShowing())
					picker.dismiss();
				else
				{
					// consider replacing next three lines with updatePos() method
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
