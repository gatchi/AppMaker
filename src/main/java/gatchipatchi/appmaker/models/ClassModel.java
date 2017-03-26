package gatchipatchi.appmaker.models;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.widget.*;
import java.util.*;

public class ClassModel extends Model
{
	String modelType = "class";
	Context context;
	
	public ClassModel(Context context)
	{
		super(context);
		
		this.setBackground(setBorderColor(Color.RED));
		this.setMinimumHeight(100);
		this.setMinimumWidth(100);
		
		TextView name = new TextView(context);
		name.setText(modelType);
		name.setTextColor(Color.RED);
		this.addView(name);
		
		canContain.add("class");
		canContain.add("method");
		canContain.add("constructor");
		
		this.context = context;
	}
	
	public void buildConstructor()
	{
		ConstructorModel mConstruct = new ConstructorModel(context);
		this.addModule(mConstruct);
	}
}
