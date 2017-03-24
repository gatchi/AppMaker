package gatchipatchi.appmaker.modules;

import android.content.*;
import android.graphics.*;
import android.widget.*;

public class ConstructorModule extends Module
{
	String moduleType = "constructor";

	public ConstructorModule(Context context)
	{
		super(context);

		this.setBackground(setBorderColor(Color.BLACK));
		this.setWidth(LayoutParams.FILL_PARENT);

		TextView name = new TextView(context);
		name.setText(moduleType);
		name.setTextColor(Color.BLACK);
		this.addView(name);
	}
}
