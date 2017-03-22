package gatchipatchi.appmaker;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AbsoluteLayout.*; 

public class OverviewActivity extends Activity 
{
	Picker picker;
	View anchor;
	View welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		ViewGroup mainLayout = (ViewGroup)findViewById(R.id.mainLayout);
		mainLayout.setOnTouchListener(deskTouchListener);
		
		anchor = findViewById(R.id.anchor);
		welcomeMessage = findViewById(R.id.welcome_message);
    }

	void clearHint()
	{
		if (welcomeMessage.isShown())
			welcomeMessage.setVisibility(View.GONE);
	}

	View.OnTouchListener deskTouchListener = new View.OnTouchListener() 
	{
		@Override
		public boolean onTouch(View v, MotionEvent e)
		{
			if (e.getAction() == MotionEvent.ACTION_DOWN)
			{
				clearHint();
				int xPos = Math.round(e.getX());
				int yPos = Math.round(e.getY());
				
				if (picker == null)
					picker = new Picker(OverviewActivity.this, anchor, xPos, yPos, JavaEntity.TOP_LEVEL_ENTITY);
				
				// maybe replace with Picker's own isShowing()
				// or maybe extend PopupWindow?
				if (picker.window.isShowing())
					picker.window.dismiss();
				else
				{
					// consider replacing next two lines with updatePos() method
					picker.x = xPos;
					picker.y = yPos;
					picker.publish();
				}
			}
			return true;
		}
	};
	
	void popMesg(String mesg)
	{
		Toast t = Toast.makeText(this, mesg, Toast.LENGTH_SHORT);
		t.show();
	}
}
