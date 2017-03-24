package gatchipatchi.appmaker.modules;

import android.content.*;
import android.widget.*;
import gatchipatchi.appmaker.*;
import java.util.*;

public class ConstructorModule extends Module
{
	public ConstructorModule(Context context)
	{
		List<String> canContain = new ArrayList<String>();
		canContain.add("object");

		super.initialize(context, R.layout.constructor_layout, canContain, "constructor");
	}
	
}
