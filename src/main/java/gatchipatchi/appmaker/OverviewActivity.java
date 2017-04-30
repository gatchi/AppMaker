package gatchipatchi.appmaker;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*; 

public class OverviewActivity extends Activity 
{
	LinearLayout desktop;
	FragmentManager fragManager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_layout);
		desktop = (LinearLayout)findViewById(R.id.desktop);
		fragManager = getFragmentManager();
    }

	public void addComponent(View v)
	{
		ComponentChooserFragment chooser = new ComponentChooserFragment();
		chooser.show(fragManager, "a");
	}
	
	public void clearDesktop(View v)
	{
		desktop.removeAllViews();
	}

	Button makeButton(Context context, String text, int id)
	{
		Button b = new Button(context);
		b.setText(text);
		b.setId(id);
		return b;
	}
	
	OnClickListener componentClickListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			// start a new OverviewActivity
			Intent in = new Intent(OverviewActivity.this, OverviewActivity.class);
			// this needs to pass a reference to which component is being clicked
			// could do a serialiuzeable class, but may be more prudent to pass a persiastent data reference (like generated code)
			startActivity(in);
		}
	};
	
	class ComponentChooserFragment extends DialogFragment
	{
		final static int CLASS = 0;

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState)
		{
			AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
			b.setTitle("component");
			b.setItems(R.array.component_type_list, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int selected)
				{
					switch(selected)
					{
						case CLASS:
							ComponentView v = new ComponentView(OverviewActivity.this, "class");
							desktop.addView(v);
							v.setOnClickListener(componentClickListener);
							break;
						default:
							popMesg(OverviewActivity.this, "oops");
					}
				}
			});

			return b.create();
		}
	}
	
	public static void popMesg(Context context, String mesg)
	{
		Toast t = Toast.makeText(context, mesg, Toast.LENGTH_SHORT);
		t.show();
	}
}
