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
	
//	public void addConstructor(ConstructorModel mConstruct)
//	{
//		if (constructorList.isEmpty())
//			addModel(nameId, mConstruct);
//		constructorList.push(mConstruct);
//	}
//	
//	public void addClass(ClassModel mClass)
//	{
//		if (nestedClassList.isEmpty())
//			addModel(constructorList.get(0).getId(), mClass);
//		else
//			addModel(getLastClass().getId(), mClass);
//		nestedClassList.push(mClass);
//	}
//	
//	public void buildDefaultConstructor()
//	{
//		ConstructorModel mConstruct = new ConstructorModel(context);
//		addModel(nameId, mConstruct);
//		constructorList.push(mConstruct);
//	}
	
	ClassModel getLastClass()
	{
		return nestedClassList.peek();
	}
	
	ConstructorModel getLastConstructor()
	{
		return constructorList.peek();
	}
}
