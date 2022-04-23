package unsorted;

import java.util.HashMap;
import java.util.Map;

public class Trial {

	static String x;
	static int type;
	static Map<String,String> map=new HashMap<String,String>();
	static int position=0;
	static int rest_position_e1=0;
	static int rest_position_e2=0;
	static String rest_e1;
	static String rest_e2;
	static int type_e1;
	static int type_e2;
	public static void main(String[] args) 
	{
		String e1= "(f (f X Y) X)";
		String e2="(f (f V U) (g U Y))";
		//String e1="(parents X (father X) (mother bill))";
		//String e2="(parents bill (father bill) Y)";
		unify(e1,e2);
		for(Map.Entry<String, String> m : map.entrySet())
		{
			System.out.println("Replace " + m.getKey()+ " with " + m.getValue());
		}
		
	}
	public static String sub(String substitution,String rest)
	{
		int flag=0;
		if(substitution=="")
			return rest;
		String subs[]=substitution.split(",");
		String temp = "",final_string="";
		for(int i=0;i<rest.length();i++)
		{
			if(rest.charAt(i)==' ')
			{
				for(int j=0;j<subs.length;j++)
				{
						String ex[]=subs[j].split("/");
						if(temp.equals(ex[1]))
						{
							final_string+=ex[0] + ' ';
							flag=1;
						}
					
				}
					if(flag==0)
						final_string+=temp + ' ';
					flag=0;
					temp="";
			}
			else if(rest.charAt(i)==')')
			{
				for(int j=0;j<subs.length;j++)
				{
						String ex[]=subs[j].split("/");
						if(temp.equals(ex[1]))
						{
							final_string+=ex[0] + ')';
							flag=1;
						}
				}
				if(flag==0)
					final_string+=temp + ')';
				flag=0;
				temp="";
			}
			else if(rest.charAt(i)=='(')
				final_string+='(';
			else
				temp+=rest.charAt(i);
		}
		return final_string;
	}
	public static String unify(String e1,String e2)
	{
		String temp;
		if(!e1.contains("(") || !e2.contains("("))
		{
			if((e1.length()>1 || (e1.length()==1 && (e1.charAt(0)>='a' && e1.charAt(0)<='z'))) && (e2.length()>1 || (e2.length()==1 && (e2.charAt(0)>='a' && e2.charAt(0)<='z'))))
			{
				if(e1.equalsIgnoreCase(e2))
					return "";
				else
					return "-1";
			}
			else if(e1.length()==1 && (e1.charAt(0)>='A' && e1.charAt(0)<='Z'))
			{
				map.put(e1, e2);
				return e2 + "/" +e1;
			}
			else if(e2.length()==1 && (e2.charAt(0)>='A' && e2.charAt(0)<='Z'))
			{
				map.put(e2, e1);
				return e1 + "/" +e2;
			}
			else if(e1=="" || e2=="")
				return "-1";
		}
		else
		{
			position=1;
			String head1=find_first(e1);
			rest_position_e1=position+1;
			position=1;
			String head2=find_first(e2);
			String subs1;
			rest_position_e2=position+1;
			int p1=rest_position_e1,p2=rest_position_e2;
			temp=unify(head1,head2);
			rest_position_e1=p1;
			rest_position_e2=p2;
			subs1=temp;
			if(temp=="-1")
				return "-1";
			else
			{
				if(rest_position_e1<e1.length())
					rest_e1=sub(temp,e1.substring(rest_position_e1, e1.length()));
				else
					rest_e1="";
				if(rest_position_e2<e2.length())
					rest_e2=sub(temp,e2.substring(rest_position_e2, e2.length()));
				else
					rest_e2="";
				if(rest_e1=="" && rest_e2=="")
					return subs1;
				else if(rest_e1=="" || rest_e2=="")
					return "-1";
				temp=unify("(" + rest_e1,"(" + rest_e2);
				if(temp=="-1")
					return "-1";
				else
				{
					if(subs1=="" && temp=="")
						return "";
					else if(subs1=="")
						return temp;
					else if(temp=="")
						return subs1;
					else
						return subs1 + "," + temp;
				}
			}
			
		}
		return "";
	}
	private static String find_first(String str) 
	{
		int count=0;
		String temp="";
		while(str.charAt(position)!=' ' && str.charAt(position)!=')')
		{
			if(str.charAt(position)=='(')
			{
				do
				{
					if(str.charAt(position)==')')
						count--;
					else if(str.charAt(position)=='(')
						count++;
					temp+=str.charAt(position);
					position++;		
				}while(count!=0);
				type=1;
			}
			else if(str.charAt(position)>='a' && str.charAt(position)<='z')
			{
				temp+=str.charAt(position);
				type=2;
				position++;
			}
			else if(str.charAt(position)>='A' && str.charAt(position)<='Z')
			{
				temp+=str.charAt(position);
				type=3;
				position++;
			}
			
		}
		return temp;
	}
}
