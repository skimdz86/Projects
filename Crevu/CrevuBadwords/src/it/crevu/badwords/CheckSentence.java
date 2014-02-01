package it.crevu.badwords;
import it.crevu.log.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




public class CheckSentence {
	
	private String []list_parameter;
	
	public CheckSentence()
	{
		String []bad_list={
			"ass_",
			"beaner",
			"bitch_",
			"brotherfucker",
			"bumblefuck",
			"butt_",
			"carpetmuncher",
			"chode",
			"cock_",
			"coon",
			"cum_",
			"cuntlicker",
			"fagtard",
			"fucka",
			"fucker",
			"dick_",
			"dike",
			"douche_",
			"dyke",
			"fag",
			"flamer",
			"fuck",
			"fudgepacker",
			"goddamn",
			"goddamnit",
			"god+",
			"gay_",
			"handjob",
			"hard on",
			"hardon",
			"homo",
			"jerk off",
			"jerkoff",
			"jesus+",
			"christ+",
			"jungle bunny",
			"junglebunny",
			"kike",
			"kyke",
			"lesbian_",
			"lesbo",
			"lezzie",
			"mcfagget",
			"muffdiver",
			"motherfucker",
			"motherfucka",
			"negro",
			"negri",
			"nazis",
			"fascismo",
			"fascista",
			"fascisti",
			"nigaboo",
			"nigga",
			"nigger",
			"niggers",
			"niglet",
			"penis_",
			"polesmoker",
			"queer_",
			"twatwaffle",
			"unclefucker",
			"bagascia",
			"baldracca",
			"checca",
			"puttana-",
			"frocio",
			"mignotta",
			"dio+",
			"porco-",
			"cane_",
			"madonna+",
			"recchione",
			"ricchione",
			"negro",
			"neger",
			"troia",
			"zoccola",
			"bastardo_",
			"lesbica_",
			"lesbo_",
			"gesù+",
			"cristo+",
			"hitler",
			"mussolini",
			"stalin",
			"vatican+",
			"maiale-",
			"pig-",
			"pork-",
			"cane-",
			"blowjob-",
			"blow job-",
			"pompin-",
			"bocchin-",
			"succhi-",
			"cazzo-",
			"cazza-",
			"bullshit-",
			"merda-",
			"shit-",
			"porca-",
			"fascim",
			"fascist"
		};
		
		list_parameter=bad_list;
		
	}
	
	
	public boolean check_string(String sentence)
	{
		String test_parameter="";	
		int index_concat=-1;
		String test_concat="";
		try
		{
			String lower_sentence=sentence.toLowerCase();
			lower_sentence=lower_sentence.replace(" ", "");
			lower_sentence=lower_sentence.replace("-", "");
			lower_sentence=lower_sentence.replace("_", "");
			lower_sentence=lower_sentence.replace("*", "");
			int count_bads=0;
			int count_names=0;
			int count_not_too_bads=0;
			for (int i=0;i<list_parameter.length;i++)
			{

				test_parameter=list_parameter[i].replace("_", "");
				test_parameter=test_parameter.replace("+", "");
				test_parameter=test_parameter.replace("-", "");
				if (lower_sentence.contains(test_parameter))
				{
					if (list_parameter[i].endsWith("_"))
					{
						if (count_names>0)
							return false;
						if (count_bads==0)
							count_bads++;
						else
							return false;
					}
					else if (list_parameter[i].endsWith("+"))
					{
						count_names++;
						if ((count_bads>0)||(count_not_too_bads>0))
							return false;
						
					}
					else if (list_parameter[i].endsWith("-"))
					{
						count_not_too_bads++;
						if (count_names>0)
							return false;
					}
					else
					{
						index_concat=lower_sentence.indexOf(test_parameter);
						test_concat=lower_sentence.substring(index_concat+test_parameter.length());
						if (test_concat.startsWith(" "))
							return false;
						else
							count_names++;
					}
				}
			}
			return true;
		}
		catch(Exception e)
		{
			Logger.exception(this.getClass(), "check_string", e, "Error in badwords checking");
			return false;
		}
	}
	


}
