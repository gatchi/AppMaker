package gatchipatchi.appmaker.models;

import android.content.*;
import android.graphics.*;
import android.widget.*;

public class ConstructorModel extends Model
{
	String moduleType = "constructor";

	public ConstructorModel(Context context)
	{
		super(context);
		setBackground(setBorderColor(Color.BLACK));

		TextView name = new TextView(context);
		name.setText(moduleType);
		name.setTextColor(Color.BLACK);
		addView(name);
	}
}
