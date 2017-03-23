package gatchipatchi.appmaker;

import java.util.*;
import android.view.*;

public class Module
{
	ViewGroup gui;  // or maybe just a layout (xml)
	List<String> canContain;
	
	public Module(ViewGroup gui, List<String> canContain)
	{
		this.gui = gui;
		this.canContain = canContain;
	}
}
