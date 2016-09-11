

public class Country {

    private String abbreviation;
    private String name;

    public Country(String abbrev, String name){
        this.abbreviation = abbrev;
        this.name = name;

    }

    public String getAbbreviation() {

        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {

        this.abbreviation = abbreviation;
    }

    public String getName() {

        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Abbreviation : %s | Country : %s \n", abbreviation, name);
    }

}
