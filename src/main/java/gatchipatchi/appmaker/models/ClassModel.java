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
	
	Stack<ClassModel> nestedClassList = new Stack<ClassModel>();
	Stack<ConstructorModel> constructorList = new Stack<ConstructorModel>();
	
	public ClassModel(Context context)
	{
		canContain.add("class");
		canContain.add("method");
		canContain.add("constructor");
		
		this.context = context;
	}
	
	ClassModel getLastClass()
	{
		return nestedClassList.peek();
	}
	
	ConstructorModel getLastConstructor()
	{
		return constructorList.peek();
	}
}
