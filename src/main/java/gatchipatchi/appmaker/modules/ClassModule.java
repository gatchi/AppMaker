package gatchipatchi.appmaker.modules;
import android.content.*;
import android.widget.*;
import gatchipatchi.appmaker.*;
import java.util.*;
import android.widget.AbsoluteLayout.*;

public class ClassModule extends Module
{
	ConstructorModule constructor;
	Context context;
	
	public ClassModule(Context context)
	{
		this.context = context;
		List<String> canContain = new ArrayList<String>();
		canContain.add("class");
		canContain.add("method");
		canContain.add("constructor");
		
		super.initialize(context, R.layout.class_layout, canContain, "class");
		
		constructor = new ConstructorModule(context);
		addConstructor(constructor);
	}
	
	void addConstructor(ConstructorModule cm)
	{
		RelativeLayout.LayoutParams constructorParams;
		int width = cm.gui.getWidth();
		int height = cm.gui.getHeight();
		constructorParams = new RelativeLayout.LayoutParams(width, height);
		constructorParams.addRule(RelativeLayout.BELOW, cm.gui.getId());
		gui.addView(cm.gui, constructorParams);
	}
}
