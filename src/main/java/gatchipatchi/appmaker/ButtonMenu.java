package gatchipatchi.appmaker;

import android.graphics.*;
import android.view.*;
import java.util.*;
import android.widget.*;
import android.view.View.*;

public class ButtonMenu
{
	ArrayList<ButtonMenu> submenus = new ArrayList<ButtonMenu>();
	ViewGroup lMenu;
	int bg;
	View.OnClickListener buttonListener;
	
	ButtonMenu(){}
	
	ButtonMenu(ViewGroup layout)
	{
		lMenu = layout;
	}
	
	ButtonMenu(ViewGroup layout, int bg)
	{
		this(layout);
		this.bg = bg;
	}
	
	public void add(ButtonMenu submenu)
	{
		submenus.add(submenu);
	}
	
	public void setColor(int bg)
	{
		this.bg = bg;
	}
}
