package gatchipatchi.appmaker.models;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.widget.*;
import java.util.*;
import gatchipatchi.appmaker.*;

public class ClassModel extends Model
{
	String modelType = "class";
	Context context;
	
	int nameId;
	
	public ClassModel(Context context)
	{
		super(context);
		
		this.setBackground(setBorderColor(Color.RED));
		this.setMinimumHeight(100);
		this.setMinimumWidth(100);
		setWidth(RelativeLayout.LayoutParams.WRAP_CONTENT);
		
		TextView name = new TextView(context);
		name.setText(modelType);
		name.setTextColor(Color.RED);
		nameId = generateViewId();
		name.setId(nameId);
		this.addView(name);
		
		canContain.add("class");
		canContain.add("method");
		canContain.add("constructor");
		
		this.context = context;
	}
	
	public void buildConstructor()
	{
		ConstructorModel mConstruct = new ConstructorModel(context);
		RelativeLayout.LayoutParams constructParams = (RelativeLayout.LayoutParams) generateDefaultLayoutParams();
		constructParams.addRule(RelativeLayout.BELOW, nameId);
		mConstruct.setLayoutParams(constructParams);
		addView(mConstruct);
	}
}
