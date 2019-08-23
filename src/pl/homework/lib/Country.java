package pl.homework.lib;

public class Country {
    private String code;
    private String name;
    private int citizens;

    public Country(String code, String name, int citizens) {
        this.code = code;
        this.name = name;
        this.citizens = citizens;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCitizens() {
        return citizens;
    }

    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return " Kraj : " + name + " (" + code + ") " + ", liczba ludności " + citizens + "\n";
    }
}
