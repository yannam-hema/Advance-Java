package SerializationAndDeserialization;

import java.io.Serializable;

public class Cricketer implements Serializable{
String name;
String country;
int matches;
transient int wickets;
public Cricketer(String name, String country, int matches, int wickets) {
	super();
	this.name = name;
	this.country = country;
	this.matches = matches;
	this.wickets = wickets;
}
public String toString() {
return name+"->"+country+"-->"+matches+"--"+wickets;
}
}
