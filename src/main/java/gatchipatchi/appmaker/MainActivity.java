package gatchipatchi.appmaker;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*; 

public class MainActivity extends Activity 
{
	final static int TYPE_INDEX = 0;
	final static int ACCESS_LEVEL_INDEX = 1;
	int[] instructions= new int[4];
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		ViewGroup vgAdd = (ViewGroup)findViewById(R.id.menuEntity);
		ButtonMenu mAdd = new ButtonMenu(vgAdd);
		mAdd.setColor(Color.RED);
		
		Button bAdd = (Button)findViewById(R.id.bAdd);
    }
	
	public void toggleMenu(int resource)
	{
		ViewGroup vg = (ViewGroup)findViewById(resource);
		if(vg.getVisibility()==ViewGroup.VISIBLE)
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
		if(b.getId() == R.id.b_public)
			instructions[ACCESS_LEVEL_INDEX] = JavaEntity.PUBLIC;
		else if(b.getId()==R.id.b_private)
			instructions[ACCESS_LEVEL_INDEX] = JavaEntity.PRIVATE;
		else if(b.getId()==R.id.b_protected)
			instructions[ACCESS_LEVEL_INDEX] = JavaEntity.PROTECTED;
		
		if(instructions[TYPE_INDEX] == JavaEntity.METHOD_TYPE)
			openMenu(R.id.menuReturnType);
		closeMenu(R.id.menuAccessLevel);
	}
	
	void popMesg(String mesg)
	{
		Toast t = Toast.makeText(this, mesg, Toast.LENGTH_SHORT);
		t.show();
	}
}
