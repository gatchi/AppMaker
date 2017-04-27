package gatchipatchi.appmaker;
import android.content.*;
import android.view.*;
import android.widget.*;

public class ComponentView extends LinearLayout
{
	TextView tv;
	
	public ComponentView(Context c, String text)
	{
		super(c);
		
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		lp.setMargins(1,1,1,1);
		setLayoutParams(lp);
		setBackgroundResource(R.color.orange);
		
		tv = new TextView(c);
		tv.setText(text);
		addView(tv);
	}
}
