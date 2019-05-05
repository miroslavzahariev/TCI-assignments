
public class Chapter implements Comparable<Chapter> {

    private String Name;
    private String Number;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getNumber() {
        return Number;
    }

    public Chapter(String name, String number) {
        if (name == null){
            throw new IllegalArgumentException("Cannot create a chapter without a name");
        }
        if (!NumberIsValid(number)) {
            throw new IllegalArgumentException("Cannot create a chapter with number longer than two sections");
        }

        Name = name;
        Number = number;
    }

    private Boolean NumberIsValid(String number){
        int counter = 0;

        for(int i = 0; i < number.length() ; i++){
            if (number.charAt(i) == '.'){
               counter ++;
            }
        }

        if(counter > 1){
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(Chapter o) {
        return this.getNumber().compareTo(o.getNumber());
    }
}
