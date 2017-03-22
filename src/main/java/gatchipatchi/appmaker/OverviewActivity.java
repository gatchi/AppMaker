package gatchipatchi.appmaker;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AbsoluteLayout.*; 

public class OverviewActivity extends Activity 
{
	final static int TYPE_INDEX = 0;
	final static int ACCESS_LEVEL_INDEX = 1;
	int[] instructions= new int[4];
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
		anchor.setBackgroundColor(R.color.orange);

		Button bAdd = (Button)findViewById(R.id.bAdd);
		welcomeMessage = findViewById(R.id.welcome_message);
		
    }

	public void onDeskTap(View v)
	{
		clearHint();
		addTopLevelEntity(v);
	}

	void addTopLevelEntity(View v)
	{
		// Options:
		//   class, activity, resource
		// so ask which she wants to add
		askUser(JavaEntity.TOP_LEVEL_ENTITY, v);
	}
	
	void askUser(int about, View parent)
	{
		if (about == JavaEntity.TOP_LEVEL_ENTITY)
		{
			// maybe make a isShowing for Picker
			
		}
			
	}

	void clearHint()
	{
		if (welcomeMessage.isShown())
			welcomeMessage.setVisibility(View.GONE);
	}
	
	public void toggleMenu(int resource)
	{
		ViewGroup vg = (ViewGroup)findViewById(resource);
		if (vg.getVisibility() == ViewGroup.VISIBLE)
			vg.setVisibility(ViewGroup.GONE);
		else
			vg.setVisibility(ViewGroup.VISIBLE);
	}

	void openMenu(int resource)
	{
		ViewGroup vg = (ViewGroup)findViewById(resource);
		vg.setVisibility(ViewGroup.VISIBLE);
	}

	void closeMenu(int resource)
	{
		ViewGroup vg = (ViewGroup)findViewById(resource);
		vg.setVisibility(ViewGroup.GONE);
	}

	public void onButtonAddTap(View v)
	{
		openMenu(R.id.menuEntity);
	}

	public void onButtonMethodTapped(View v)
	{
		instructions[TYPE_INDEX] = JavaEntity.METHOD_TYPE;
		openMenu(R.id.menuAccessLevel);
		closeMenu(R.id.menuEntity);;
	}

	public void onAccessLevelButtonTapped(View view)
	{
		Button b = (Button)view;
		if (b.getId() == R.id.b_public)
			instructions[ACCESS_LEVEL_INDEX] = JavaEntity.PUBLIC;
		else if (b.getId() == R.id.b_private)
			instructions[ACCESS_LEVEL_INDEX] = JavaEntity.PRIVATE;
		else if (b.getId() == R.id.b_protected)
			instructions[ACCESS_LEVEL_INDEX] = JavaEntity.PROTECTED;

		if (instructions[TYPE_INDEX] == JavaEntity.METHOD_TYPE)
			openMenu(R.id.menuReturnType);
		closeMenu(R.id.menuAccessLevel);
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
