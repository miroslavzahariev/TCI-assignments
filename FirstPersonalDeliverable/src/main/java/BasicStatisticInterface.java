/**
 * This utility interface is used for doing statistics calculations
 * The interface has 2 responsibilities:
 * -collecting data to do statistics calculations on
 * -doing the statistics calculations
 *
 * Data items are Double objects.
 */

public interface BasicStatisticInterface {

    /**
     * @param valueToAdd value which will be added.
     */
    void addDoubleToData(Double valueToAdd);

    /**
     * clear all data items
     */
    void clearData();

    /**
     * this method returns the number of data items.
	 *
     * @return number of data items.
     */
    int numberOfDataItems();

    /**
     * this method returns the sum of all collected data items
	 *
     * @return the sum of the data items, or 0 when no data items are present
     */
    Double sum();


}
