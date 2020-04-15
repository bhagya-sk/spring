package com.reactiveworks.stocktrade.dao;

import java.util.List;

import com.reactiveworks.stocktrade.db.exceptions.DBOperationFailureException;
import com.reactiveworks.stocktrade.db.exceptions.DataBaseAccessException;
import com.reactiveworks.stocktrade.db.exceptions.InvalidDBRecordFormatException;
import com.reactiveworks.stocktrade.db.exceptions.OperationNotSupportedException;
import com.reactiveworks.stocktrade.model.StockTrade;

/**
 * Interface for StockTradeDao implementation.
 */
public interface IStockTradeDao {

	/**
	 * Creates the stockTrade record in the database.
	 * 
	 * @param stockTradeObj stockTrade object which has to be inserted into the
	 *                      database.
	 * @throws DataBaseAccessException        when there is problem in accessing the
	 *                                        database.
	 * @throws DBOperationFailureException    when there is problem while operating
	 *                                        on the database.
	 * @throws OperationNotSupportedException when the operation is not supported by
	 *                                        the database.
	 */
	public void createStockTradeRecord(StockTrade stockTradeObj)
			throws DataBaseAccessException, DBOperationFailureException, OperationNotSupportedException;

	/**
	 * gets the stockTrade information from the database and creates a list of
	 * stockTrade objects.
	 * 
	 * @return the list of stockTrade objects.
	 * @throws DataBaseAccessException        when there is problem in accessing
	 *                                        database.
	 * @throws InvalidDBRecordFormatException when the format of the database record
	 *                                        is invalid.
	 */
	public List<StockTrade> getStockTradeRecords() throws DataBaseAccessException, InvalidDBRecordFormatException, DBOperationFailureException;

	/**
	 * Finds the StockTrade object from the database and returns the StockTrade
	 * object.
	 * 
	 * @return the StockTrade object with the given stockTradeId.
	 * @throws DataBaseAccessException        when there is problem in accessing
	 *                                        database.
	 * @throws InvalidDBRecordFormatException when the format of the database record
	 *                                        is invalid.
	 */
	public StockTrade getStockTradeRecord(int stockTradeId)
			throws DataBaseAccessException, InvalidDBRecordFormatException,DBOperationFailureException;

	/**
	 * Updates the stocktrade record in the database.
	 * 
	 * @param stockTradeId the id of the stocktrade record whose fields should be
	 *                     updated.
	 * @param volume       the new value of volume field in the database.
	 * @throws DataBaseAccessException        when there is problem in accessing the
	 *                                        database.
	 * @throws DBOperationFailureException    when there is problem in reading the
	 *                                        property file.
	 * @throws OperationNotSupportedException when the operation is not supported by
	 *                                        the database.
	 */
	public void updateStockTradeRecord(int stockTradeId, double volume)
			throws DataBaseAccessException, DBOperationFailureException, OperationNotSupportedException;

	/**
	 * Deletes the stockTrade record from the database.
	 * 
	 * @throws DataBaseAccessException        when there is problem in accessing the
	 *                                        database.
	 * @throws DBOperationFailureException    when there is problem in reading the
	 *                                        property file.
	 * @throws OperationNotSupportedException when the operation is not supported by
	 *                                        the database.
	 */
	public void deleteStockTradeRecord(int stockTradeId)
			throws DataBaseAccessException, DBOperationFailureException, OperationNotSupportedException;

}
