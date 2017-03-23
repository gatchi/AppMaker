package gatchipatchi.appmaker;

import java.util.*;

public class Module
{
	Object gui;  // or maybe just a layout (xml)
	List<Object> canContain;
	
	Module(Object gui, List<Object> canContain)
	{
		this.gui = gui;
		this.canContain = canContain;
	}
}
