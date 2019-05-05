import java.util.ArrayList;
import java.util.List;

public class BasicStatistic implements BasicStatisticInterface {

    private List<Double> Data;

    public BasicStatistic() {
        this.Data = new ArrayList<>();
    }

    public void setData(List<Double> data) {
        Data = data;
    }

    public List<Double> getData() {
        return Data;
    }

    @Override
    public void addDoubleToData(Double valueToAdd){
        Data.add(valueToAdd);
    }

    @Override
    public void clearData(){
        this.Data.clear();
    };
	
    @Override
    public int numberOfDataItems(){
        int rv = 0;
        return rv;
    }

    @Override
    public Double sum(){
        if (this.getData().size() == 0){
            return 0.0;
        }

        double result = 0.0;

        for(double number : this.getData()){
            result += number;
        }

        return result;
    }

}
