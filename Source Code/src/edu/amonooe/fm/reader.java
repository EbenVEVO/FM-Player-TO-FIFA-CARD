package edu.amonooe.fm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class reader {
		Map<String, Double> FMattributes = new HashMap<>(); 
        Map<String, Double> FIFAattributes = new HashMap<>();
        Map<String, Integer> FIFAstats = new HashMap<>();
        Map<String, Integer> Overalls = new HashMap<>();
    public void readAttributes (File file) throws FMException{
        if (file.canRead())System.out.println("working");
        if (file.isFile())System.out.println("working");
        BufferedReader br;
        
        try{
        	 br = new BufferedReader(new FileReader(file));
             String line;
             
             String attribute = "";
             double attributeval = 0.0;
             while((line = br.readLine())!=null){
                 line = line.replaceAll("[^a-zA-Z0-9]", "").trim();
                 line = line.replaceAll("^\\s+", "");
                 if (line != "" && line.trim().length() > 0){
                     attribute = line.replaceAll("\\d", "");
                     if(attribute.contains("Weight"))attribute =attribute.replace("lbs", "");                
                     attributeval = Integer.parseInt(line.replaceAll("[^0-9]", ""));
                     if(attribute.matches("[a-zA-Z]+"))FMattributes.put(attribute,attributeval);
                 }
             }
             FIFAattributes = conversions(FMattributes);
             Overalls = overallConversions(FIFAattributes);
             FIFAstats = statconversions(FIFAattributes);
             
             String name = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\")+1);
             name = name.replaceAll(".txt", "");
             
             ResultsWindow showResults = new ResultsWindow(FIFAattributes, FIFAstats, Overalls,name);
             showResults.run(FIFAattributes, FIFAstats, Overalls,name);
        }
        catch (Exception e){
            throw new FMException("CANNOT READ THIS FILE!", e);
        }
       
    }
    
    public Map<String, Integer> statconversions(Map<String, Double> attributes){
    	
    	int pace, shooting, passing, dribbling, defending, physical;
    	Map<String, Integer> FIFAstats = new HashMap<>();
    	
    	pace = (int) (attributes.get("Sprint Speed")*0.55 + attributes.get("Acceleration")*0.45) ;
    	shooting = (int) (attributes.get("Finishing")*0.45 + attributes.get("Long Shots")*0.2+ attributes.get("Shot Power")*0.2 + attributes.get("Attacking Positioning")*0.05 + attributes.get("Penalties")*0.05 + attributes.get("Volleys")*0.05);
    	passing = (int) (attributes.get("Short Passing")*0.35 + attributes.get("Vision")*0.2+ attributes.get("Crossing")*0.2 + attributes.get("Long Passing")*0.15 + attributes.get("Curve")*0.05 + attributes.get("Free Kick Accuracy")*0.05);
    	dribbling = (int)(attributes.get("Dribbling")*0.5 + attributes.get("Ball Control")*0.35+ attributes.get("Agility")*0.1 + attributes.get("Balance")*0.05);
    	defending = (int)(attributes.get("Marking")*0.3 + attributes.get("Stand Tackle")*0.3+ attributes.get("Interceptions")*0.2 + attributes.get("Heading Accuracy")*0.1 + attributes.get("Slide Tackle")*0.1);
    	physical = (int)(attributes.get("Strength")*0.5 + attributes.get("Stamina")*0.25+ attributes.get("Aggression")*0.2 + attributes.get("Jumping")*0.05);
    
    	FIFAstats.put("Pace", pace);
    	FIFAstats.put("Shooting", shooting);
    	FIFAstats.put("Passing", passing);
    	FIFAstats.put("Dribbling", dribbling);
    	FIFAstats.put("Defending", defending);
    	FIFAstats.put("Physical", physical);
    	
    	return FIFAstats;
    
    }
    
    public Map<String, Integer> overallConversions(Map<String, Double> attributes){
    	
        Map<String, Integer> Overalls = new HashMap<>();
        int st, wing, cm, wm, cam, cdm , wb, rb, cb; 
        
        st = (int)(0.2*attributes.get("Finishing")+0.12*attributes.get("Attacking Positioning")+0.1*attributes.get("Heading Accuracy")+
        		0.1*attributes.get("Shot Power")+0.1*attributes.get("Reactions")+0.08*attributes.get("Dribbling")+0.08*attributes.get("Ball Control")
        		+0.05*attributes.get("Volleys")+0.05*attributes.get("Long Shots")+0.05*attributes.get("Acceleration")+0.04*attributes.get("Sprint Speed")
        		+0.03*attributes.get("Strength"));
        if (st>99)st =99;
        wing =(int) (0.16*attributes.get("Crossing")+0.16*attributes.get("Dribbling")+0.13*attributes.get("Ball Control")+0.1*attributes.get("Short Passing")
        +0.09*attributes.get("Attacking Positioning")+0.06*attributes.get("Acceleration")+0.06*attributes.get("Sprint Speed")+
        0.06*attributes.get("Reactions")+0.05*attributes.get("Agility")+0.05*attributes.get("Vision")+0.04*attributes.get("Finishing")+0.04*attributes.get("Long Shots"));
    	if (wing>99)wing=99;
    	cam = (int)(0.16*attributes.get("Short Passing")+0.16*attributes.get("Vision")+0.13*attributes.get("Ball Control")+0.12*attributes.get("Attacking Positioning")
    	+0.11*attributes.get("Dribbling")+0.08*attributes.get("Reactions")+0.06*attributes.get("Long Shots")+0.05*attributes.get("Finishing")+0.05*attributes.get("Shot Power")
    	+0.04*attributes.get("Acceleration")+0.04*attributes.get("Agility"));
    	if(cam>99)cam=99;
    	cm = (int) (0.15*attributes.get("Short Passing")+0.13*attributes.get("Long Passing")+0.12*attributes.get("Vision")+0.1*attributes.get("Ball Control")+0.09*attributes.get("Dribbling")
    	+0.08*attributes.get("Reactions")+0.08*attributes.get("Interceptions")+0.08*attributes.get("Attacking Positioning")+0.06*attributes.get("Stand Tackle")+0.06*attributes.get("Stamina")
    	+0.05*attributes.get("Long Shots"));
    	if(cm>99)cm=99;
    	wm = (int)(0.14*attributes.get("Crossing")+0.14*attributes.get("Dribbling")+0.12*attributes.get("Short Passing")+0.12*attributes.get("Ball Control")+0.08*attributes.get("Long Passing")+0.08*attributes.get("Vision")
    	+0.07*attributes.get("Reactions")+0.07*attributes.get("Attacking Positioning")+0.05*attributes.get("Stamina")+0.05*attributes.get("Acceleration")+0.05*attributes.get("Sprint Speed")+0.03*attributes.get("Agility"));
    	if(wm > 99)wm =99;
    	cdm=(int)(0.13*attributes.get("Short Passing")+0.13*attributes.get("Interceptions")+0.11*attributes.get("Long Passing")+0.1*attributes.get("Marking")+0.1*attributes.get("Stand Tackle")+0.09*attributes.get("Ball Control")
    	+0.09*attributes.get("Reactions")+0.08*attributes.get("Vision")+0.06*attributes.get("Stamina")+0.06*attributes.get("Strength")+0.05*attributes.get("Aggression"));
    	if(cdm>99)cdm=99;
    	wb = (int)(0.11*attributes.get("Stand Tackle")+0.1*attributes.get("Slide Tackle")+0.1*attributes.get("Crossing")+0.1*attributes.get("Short Passing")+0.1*attributes.get("Ball Control")+0.1*attributes.get("Interceptions")
    	+0.09*attributes.get("Marking")+0.08*attributes.get("Stamina")+0.08*attributes.get("Reactions")+0.07*attributes.get("Dribbling")+0.04*attributes.get("Sprint Speed")+0.03*attributes.get("Acceleration"));
    	if (wb>99)wb=99;
    	rb = (int)(0.13*attributes.get("Slide Tackle")+0.12*attributes.get("Stand Tackle")+0.12*attributes.get("Interceptions")+0.1*attributes.get("Marking")+0.08*attributes.get("Stamina")+0.08*attributes.get("Reactions")
    	+0.07*attributes.get("Crossing")+0.07*attributes.get("Heading Accuracy")+0.07*attributes.get("Ball Control")+0.06*attributes.get("Short Passing")+0.05*attributes.get("Sprint Speed")+0.05*attributes.get("Aggression"));
    	if(rb>99)rb=99;
    	cb = (int)(0.15*attributes.get("Defensive Awareness")+0.15*attributes.get("Stand Tackle")+0.15*attributes.get("Slide Tackle")+0.1*attributes.get("Heading Accuracy")+0.1*attributes.get("Strength")
    	+0.08*attributes.get("Aggression")+0.08*attributes.get("Interceptions")+0.05*attributes.get("Short Passing")+0.05*attributes.get("Ball Control")+0.05*attributes.get("Reactions")+0.04*attributes.get("Jumping"));
    	if(cb>99)cb=99;
    	
    	Overalls.put("ST", st);
    	Overalls.put("RW", wing);
    	Overalls.put("LW", wing);
    	Overalls.put("CAM", cam);
    	Overalls.put("CM", cm);
    	Overalls.put("RM", wm);
    	Overalls.put("LM", wm);
    	Overalls.put("CDM", cdm);
    	Overalls.put("RWB", wb);
    	Overalls.put("LWB", wb);
    	Overalls.put("RB", rb);
    	Overalls.put("LB", rb);
    	Overalls.put("CB", cb);
    
    	return Overalls;
    }
    public Map<String, Double> conversions(Map<String, Double> attributes) {
    	
    	Map<String,Double> FIFAattributes = new HashMap<>();
    	
    	double crossing = ((0.16*(-(Math.pow(((attributes.get("Crossing")*0.5)+(attributes.get("Technique")*0.2)+(attributes.get("Composure")*0.2) +(attributes.get("Passing")*0.1))-25,2)))+103)*(0.9+(0.005*20)));
    	FIFAattributes.put("Crossing", crossing);
    	double Finishing = ((0.16*(-(Math.pow(((attributes.get("Finishing")*0.4)+(attributes.get("Technique")*0.1)+(attributes.get("Composure")*0.4) +(attributes.get("Passing")*0.1))-25,2)))+103)*(0.9+(0.005*20)));
    	FIFAattributes.put("Finishing", Finishing);
    	double headingacc =((0.16*(-Math.pow(((attributes.get("Heading")*0.5)+(attributes.get("Composure")*0.1)+(attributes.get("Passing")*0.1) +(attributes.get("Bravery")*0.3))-25,2)))+103)*(0.9+(0.005*20));
    	FIFAattributes.put("Heading Accuracy", headingacc);
    	double shortpass = ((0.16*(-Math.pow(((attributes.get("Passing")*0.5)+(attributes.get("Vision")*0.25)+(attributes.get("Composure")*0.25) +(attributes.get("Passing")*0.1))-25,2)))+103)*(0.9+(0.005*20));
    	FIFAattributes.put("Short Passing", shortpass);
    	double volleys = ((0.16*(-Math.pow(((attributes.get("Finishing")*0.2)+(attributes.get("Technique")*0.4)+(attributes.get("Composure")*0.2) +(attributes.get("Passing")*0.1)+(attributes.get("LongShots") *0.1))-25,2)))+103)*(0.9+(0.005*20));
    	FIFAattributes.put("Volleys", volleys);
    	double acceleration = (0.16*(-Math.pow((attributes.get("Acceleration")-25),2)))+103;
    	FIFAattributes.put("Acceleration", acceleration);
    	double agility = (0.16*(-Math.pow((attributes.get("Agility")-25),2)))+103;
    	FIFAattributes.put("Agility", agility);
    	double balance = (0.16*(-Math.pow((attributes.get("Balance")-25),2)))+103;
    	FIFAattributes.put("Balance", balance);
    	double reactions = (0.16*(-Math.pow((attributes.get("Anticipation")-25),2)))+103*(0.9+(0.005*20));
    	FIFAattributes.put("Reactions", reactions);
    	double sprintspeed = (0.16*(-Math.pow((attributes.get("Pace")-25),2)))+103;
    	FIFAattributes.put("Sprint Speed", sprintspeed);
    	double ballcontrol =(0.16*(-Math.pow((attributes.get("FirstTouch")-25),2)))+103*(0.9+(0.005*20));
    	FIFAattributes.put("Ball Control", ballcontrol);
    	double curve = (0.16*(-Math.pow((attributes.get("Technique")-25),2)))+103*(0.9+(0.005*20));
    	FIFAattributes.put("Curve", curve);
    	double dribbling = (0.16*(-Math.pow((attributes.get("Dribbling")-25),2)))+103*(0.9+(0.005*20));
    	FIFAattributes.put("Dribbling", dribbling);
    	double fka = ((0.16*(-(Math.pow((attributes.get("FreeKickTaking")*0.4)+(attributes.get("Vision")*0.2)+(attributes.get("Composure")*0.2) +(attributes.get("Passing")*0.2)-25,2)))+103)*(0.9+(0.005*20)));
    	FIFAattributes.put("Free Kick Accuracy", fka);
    	double longpassing = ((0.16*(-(Math.pow((attributes.get("Passing")*0.3)+(attributes.get("Technique")*0.3)+(attributes.get("Composure")*0.1) +(attributes.get("Vision")*0.3)-25,2)))+103)*(0.9+(0.005*20)));
    	FIFAattributes.put("Long Passing", longpassing);
    	double marking = ((0.16*(-(Math.pow((attributes.get("Positioning")*0.3)+(attributes.get("Concentration")*0.2)+(attributes.get("Marking")*0.5)-25,2)))+103)*(0.9+(0.005*20)));
    	FIFAattributes.put("Marking", marking);
    	double slidetackle = ((0.16*(-(Math.pow((attributes.get("Bravery")*0.15)+(attributes.get("Passing")*0.15)+(attributes.get("Aggression")*0.1) +(attributes.get("Tackling")*0.5)+(attributes.get("Concentration") *0.1)-25,2)))+103)*(0.9+(0.005*20)));
    	FIFAattributes.put("Slide Tackle", slidetackle);
    	double standtackle = ((0.16*(-(Math.pow((attributes.get("Bravery")*0.2)+(attributes.get("Tackling")*0.5)+(attributes.get("Concentration")*0.1) +(attributes.get("Passing")*0.2)-25,2)))+103)*(0.9+(0.005*20)));
    	FIFAattributes.put("Stand Tackle", standtackle);
    	double aggression = (0.16*(-Math.pow((attributes.get("Aggression")-25),2)))+103*(0.9+(0.005*20));
    	FIFAattributes.put("Aggression", aggression);
    	double penalties =((0.16*(-(Math.pow((attributes.get("Finishing")*0.2)+(attributes.get("PenaltyTaking")*0.5)+(attributes.get("Composure")*0.3)-25,2)))+103)*(0.9+(0.005*20)));
    	FIFAattributes.put("Penalties", penalties);
    	double attpositioning=((0.16*(-(Math.pow((attributes.get("Concentration")*0.25)+(attributes.get("OffTheBall")*0.5)+(attributes.get("Anticipation")*0.25)-25,2)))+103)*(0.9+(0.005*20)));
		FIFAattributes.put("Attacking Positioning", attpositioning);
    	double interceptions =((0.16*(-(Math.pow((attributes.get("Anticipation")*0.15)+(attributes.get("Positioning")*0.7)+(attributes.get("Concentration")*0.15)-25,2))))+103)*(0.9+(0.005*20));
    	FIFAattributes.put("Interceptions", interceptions);
    	double vision = ((0.16*(-(Math.pow((attributes.get("Passing")*0.3)+(attributes.get("Vision")*0.7)-25,2))))+103)*(0.9+(0.005*20));
    	FIFAattributes.put("Vision", vision);
    	double jumping = (0.16*(-Math.pow((attributes.get("JumpingReach")-25),2)))+103;
    	FIFAattributes.put("Jumping", jumping);
    	double longshots = ((0.16*(-(Math.pow((attributes.get("LongShots")*0.4)+(attributes.get("Technique")*0.25)+(attributes.get("Composure")*0.25) +(attributes.get("Passing")*0.1)-25,2)))+103)*(0.9+(0.005*20)));
    	FIFAattributes.put("Long Shots", longshots);
    	double shotpower = (((attributes.get("Technique")+attributes.get("Strength"))/2)*5.5)+5;
    	FIFAattributes.put("Shot Power", shotpower);
    	double stamina = ((0.16*(-(Math.pow((attributes.get("Stamina")*0.55)+(attributes.get("NaturalFitness")*0.45)-25,2))))+103);
    	FIFAattributes.put("Stamina", stamina);
    	double strength	=(0.16*(-Math.pow(attributes.get("Strength")-25,2)))+103;
    	FIFAattributes.put("Strength", strength);
    	double defaware	=(0.16*(-Math.pow(attributes.get("Positioning")-25,2)))+103;
    	FIFAattributes.put("Defensive Awareness", defaware);
    	double composure = (0.16*(-Math.pow(attributes.get("Composure")-25,2)))+103;
    	FIFAattributes.put("Composure", composure);
    	return FIFAattributes;
    }
    
  
    
}
