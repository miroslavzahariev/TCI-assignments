import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicStatisticTest {

    @Test
    public void BasicStatistic_ObjectHasNoDataWhenCreated_Successfull(){

        // Arrange
        int expectedNumberOfItems = 0;

        // Act
        BasicStatistic statistic = new BasicStatistic();

        // Assert
        Assert.assertEquals( expectedNumberOfItems ,statistic.getData().size());
    }

    @Test
    public void AddDoubleToData_Successfull(){

        // Arrange
        double numberToAdd = 1.1;
        int expectedNumberOfItems = 1;
        BasicStatistic statistic = new BasicStatistic();

        // Act
        statistic.addDoubleToData(numberToAdd);

        // Assert
        Assert.assertEquals(expectedNumberOfItems, statistic.getData().size());
    }

    @Test
    public void ClearData_Successfull(){

        // Arrange
        BasicStatistic statistic = new BasicStatistic();
        statistic.addDoubleToData(2.2);
        statistic.addDoubleToData(3.3);
        int expectedNumberOfItems = 0;

        // Act
        statistic.clearData();

        // Assert
        Assert.assertEquals(expectedNumberOfItems, statistic.getData().size());
    }

    @Test
    public void AddDoubleToData_WhenAddingMultipleValuesAtOnce_Successfull(){

        // Arrange
        double firstValueToAdd = 2.4;
        double secondValueToAdd = 4.4;
        double thirdValueToAdd = 5.5;
        int expectedNumberOfItems = 3;

        BasicStatistic statistic = new BasicStatistic();

        // Act
        statistic.addDoubleToData(firstValueToAdd);
        statistic.addDoubleToData(secondValueToAdd);
        statistic.addDoubleToData(thirdValueToAdd);

        // Assert
        Assert.assertEquals(expectedNumberOfItems, statistic.getData().size());
    }

    // sum succesfull
    // sum when null is passed

    @Test
    public void Sum_ReturnsSumOfNumbersInList_WhenListIsNotEmpty(){

        // Arrange
        double firstNumberInTheList = 1.1;
        double secondNumberInTheList = 2.2;
        double expectedResult = 3.3;
        BasicStatistic statistic = new BasicStatistic();
        statistic.addDoubleToData(firstNumberInTheList);
        statistic.addDoubleToData(secondNumberInTheList);

        // Act
        double result = statistic.sum();

        // Assert
        Assert.assertEquals(expectedResult, result, 1);
    }

    @Test
    public void Sum_ReturnsZero_WhenTheListOfItemsIsEmpty(){

        //Arrange
        double expectedResult = 0;
        BasicStatistic statistic = new BasicStatistic();

        //Act
        double result = statistic.sum();

        // Assert
        Assert.assertEquals(expectedResult, result, 0);
    }
}