public class MyFirstClass {

    private int _age;
    private int _name;

    public void set_age(int _age) {
        this._age = _age;
    }

    public void set_name(int _name) {
        this._name = _name;
    }

    public int get_age() {
        return _age;
    }

    public int get_name() {
        return _name;
    }

    public MyFirstClass(int _age, int _name) {
        this._age = _age;
        this._name = _name;
    }
}
