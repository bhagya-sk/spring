package com.reactiveworks.stocktrade.dao.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.reactiveworks.stocktrade.dao.IStockTradeDao;
import com.reactiveworks.stocktrade.db.DBUtil;
import com.reactiveworks.stocktrade.db.exceptions.DBOperationFailureException;
import com.reactiveworks.stocktrade.db.exceptions.DataBaseAccessException;
import com.reactiveworks.stocktrade.db.exceptions.InvalidDBRecordFormatException;
import com.reactiveworks.stocktrade.model.StockTrade;

/**
 * Mysql implementation of StockTradeDao interface.
 */
public class StockTradeMysqlDaoImpl implements IStockTradeDao {
	private static Logger LOGGER_OBJ = Logger.getLogger("StockTradeMysqlDaoImpl.class");
	private static final String INSERT_QUERY = "INSERT INTO stocktrade(security,date,open,high,low,close,volume,adj_close) VALUES(?,?,?,?,?,?,?,?);";
	private static final String GET_QUERY = "SELECT * FROM stocktrade WHERE stocktrade_id = ?;";
	private static final String DELETE_QUERY = "DELETE FROM stocktrade WHERE stocktrade_id = ?;";
	private static final String UPDATE_QUERY = "UPDATE stocktrade SET volume = ? WHERE stocktrade_id = ?;";
	private static final String FILE_NAME = "CISCO.txt";

	/**
	 * Reads the information from the CSV file and creates the list of stockTrade
	 * objects.
	 * 
	 * @return the list of stockTrade objects.
	 * @throws DataBaseAccessException        when there is problem in accessing the
	 *                                        CSV file.
	 * @throws InvalidDBRecordFormatException when the format of the CSV record is
	 *                                        invalid.
	 * @throws DBOperationFailureException    when operation on csv file fails.
	 */
	@Override
	public List<StockTrade> getStockTradeRecords()
			throws DataBaseAccessException, InvalidDBRecordFormatException, DBOperationFailureException {
		LOGGER_OBJ.debug("execution of getStockTradeRecords() method started.");
		File file = new File(getClass().getClassLoader().getResource("CISCO.txt").getFile());

		List<StockTrade> stockTrdList = new ArrayList<StockTrade>();
		try {

			BufferedReader buffReader = new BufferedReader(new FileReader(file));
			String lineStr;

			buffReader.readLine();

			while ((lineStr = buffReader.readLine()) != null) {

				stockTrdList.add(parseStockCSVLine(lineStr));

			}
			buffReader.close();

		} catch (FileNotFoundException fnexp) {
			LOGGER_OBJ.error(FILE_NAME + " file is not found");
			throw new DataBaseAccessException(FILE_NAME + " file is not found", fnexp);
		} catch (IOException ioexp) {
			LOGGER_OBJ.error("not able to read the file " + FILE_NAME);
			throw new DBOperationFailureException("not able to read the file " + FILE_NAME, ioexp);
		}
		LOGGER_OBJ.debug("getStockTradeRecords() method execution completed.");
		return stockTrdList;
	}

	/**
	 * converts one line in csv file to the stockTrade object.
	 * 
	 * @param strLine string in each line of the csv file.
	 * @return the stockTrade object.
	 * @throws InvalidDBRecordFormatException when the format of the stockTrade is
	 *                                        invalid.
	 */
	private StockTrade parseStockCSVLine(String strLine) throws InvalidDBRecordFormatException {
		LOGGER_OBJ.debug("execution of parseStockCSVLine() method started.");
		StockTrade stockTrade = new StockTrade();
		String stockInfo[] = strLine.split(",");
		stockTrade.setSecurity(stockInfo[0]);

		Date date;
		try {
			date = new SimpleDateFormat("MM/dd/yyyy").parse(stockInfo[1]);
			stockTrade.setDate(date);
			stockTrade.setOpen(Double.parseDouble(stockInfo[2]));
			stockTrade.setHigh(Double.parseDouble(stockInfo[3]));
			stockTrade.setLow(Double.parseDouble(stockInfo[4]));
			stockTrade.setClose(Double.parseDouble(stockInfo[5]));
			stockTrade.setVolume(Double.parseDouble(stockInfo[6]));
			stockTrade.setAdjClose(Double.parseDouble(stockInfo[7]));
		} catch (ParseException pexp) {
			LOGGER_OBJ.error("date format of the stocktrade is invalid.");
			throw new InvalidDBRecordFormatException("invalid date format.", pexp);
		} catch (NumberFormatException nfexp) {
			LOGGER_OBJ.error("number format of the stocktrade field is invalid.");
			throw new InvalidDBRecordFormatException("invalid number format.", nfexp);
		}
		LOGGER_OBJ.debug("parseStockCSVLine() method execution completed.");
		return stockTrade;

	}

	/**
	 * Creates the stockTrade record in the database.
	 * 
	 * @param stockTradeObj stockTrade object which has to be inserted into the
	 *                      database.
	 * @throws DataBaseAccessException     when there is problem in accessing the
	 *                                     database.
	 * @throws DBOperationFailureException when operation on database fails.
	 */
	public void createStockTradeRecord(StockTrade stockTradeObj)
			throws DataBaseAccessException, DBOperationFailureException {
		LOGGER_OBJ.debug("execution of createStockTradeRecord() method started.");
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getdbconnection();
			statement = connection.prepareStatement(INSERT_QUERY);
			statement.setString(1, stockTradeObj.getSecurity());
			java.sql.Date date = new java.sql.Date(stockTradeObj.getDate().getTime());
			statement.setDate(2, date);
			statement.setDouble(3, stockTradeObj.getOpen());
			statement.setDouble(4, stockTradeObj.getHigh());
			statement.setDouble(5, stockTradeObj.getLow());
			statement.setDouble(6, stockTradeObj.getClose());
			statement.setDouble(7, stockTradeObj.getVolume());
			statement.setDouble(8, stockTradeObj.getAdjClose());
			statement.executeUpdate();

		} catch (SQLException exp) {
			LOGGER_OBJ.error("unable to access stocktrade database");
			throw new DataBaseAccessException("unable to access stocktrade database" + exp);
		} finally {

			DBUtil.cleanupdbresources(resultSet, statement, connection);

		}

		LOGGER_OBJ.debug("createStockTradeRecord() method execution completed.");
	}
	
//	public void createDBRecords() throws DataBaseAccessException, InvalidDBRecordFormatException, DBOperationFailureException {
//	List<StockTrade> stockTradeObjList=	getStockTradeRecords();
//	
//	
//	}

//	/**
//	 * gets the stockTrade information from the database and creates a list of
//	 * stockTrade objects.
//	 * 
//	 * @return the list of stockTrade objects.
//	 * @throws DataBaseAccessException        when there is problem in accessing the
//	 *                                        database.
//	 * @throws InvalidDBRecordFormatException when the format of the database record
//	 *                                        is invalid.
//	 * @throws DBOperationFailureException    when operation on the database fails.
//	 */
//	public List<StockTrade> getStockTradeRecords()
//			throws DataBaseAccessException, InvalidDBRecordFormatException, DBOperationFailureException {
//		LOGGER_OBJ.debug("execution of getStockTradeRecords() method started.");
//		List<StockTrade> stockTradeList = new ArrayList<StockTrade>();
//		ResultSet res = null;
//		Connection connection = null;
//		PreparedStatement statement = null;
//		try {
//
//			connection = DBUtil.getdbconnection();
//			statement = connection.prepareStatement(SELECT_QUERY);
//			res = statement.executeQuery(SELECT_QUERY);
//			while (res.next()) {
//				StockTrade stockObj = new StockTrade();
//				stockObj.setSecurity(res.getString(2));
//				stockObj.setDate(res.getDate(3));
//				stockObj.setOpen(res.getDouble(4));
//				stockObj.setHigh(res.getDouble(5));
//				stockObj.setLow(res.getDouble(6));
//				stockObj.setClose(res.getDouble(7));
//				stockObj.setVolume(res.getDouble(8));
//				stockObj.setAdjClose(res.getDouble(9));
//				stockTradeList.add(stockObj);
//			}
//		} catch (SQLException exp) {
//			LOGGER_OBJ.error("unable to access stocktrade database");
//			throw new DataBaseAccessException("unable to access stocktrade database" + exp);
//		} finally {
//
//			DBUtil.cleanupdbresources(res, statement, connection);
//
//		}
//		LOGGER_OBJ.debug("getStockTradeRecords() method execution completed.");
//		return stockTradeList;
//	}

	/**
	 * Finds the StockTrade object from the database and returns the StockTrade
	 * object.
	 * 
	 * @return the StockTrade object with the given stockTradeId.
	 * @throws DataBaseAccessException        when there is problem in accessing the
	 *                                        database.
	 * @throws InvalidDBRecordFormatException when the format of the database record
	 *                                        is invalid.
	 * @throws DBOperationFailureException    when operation on the database fails.
	 */
	@Override
	public StockTrade getStockTradeRecord(int stockTradeId)
			throws DataBaseAccessException, InvalidDBRecordFormatException, DBOperationFailureException {

		LOGGER_OBJ.debug("execution of getStockTradeRecord() method started.");
		StockTrade stockTradeObj = new StockTrade();
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DBUtil.getdbconnection();
			statement = connection.prepareStatement(GET_QUERY);
			statement.setInt(1, stockTradeId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {

				stockTradeObj.setSecurity(resultSet.getString(2));
				stockTradeObj.setDate(resultSet.getDate(3));
				stockTradeObj.setOpen(resultSet.getDouble(4));
				stockTradeObj.setHigh(resultSet.getDouble(5));
				stockTradeObj.setLow(resultSet.getDouble(6));
				stockTradeObj.setClose(resultSet.getDouble(7));
				stockTradeObj.setVolume(resultSet.getDouble(8));
				stockTradeObj.setAdjClose(resultSet.getDouble(9));

			}

		} catch (SQLException exp) {
			LOGGER_OBJ.error("unable to access stocktrade database");
			throw new DataBaseAccessException("unable to access stocktrade database" + exp);
		} finally {
			DBUtil.cleanupdbresources(resultSet, statement, connection);
		}
		LOGGER_OBJ.debug("getStockTradeRecord() method execution completed.");
		return stockTradeObj;
	}

	/**
	 * Updates the stocktrade record in the database.
	 * 
	 * @param stockTradeId the id of the stocktrade record whose fields should be
	 *                     updated.
	 * @param volume       the new value of volume field in the database.
	 * @throws DataBaseAccessException     when there is problem in accessing the
	 *                                     database.
	 * @throws DBOperationFailureException when the operation on the database fails.
	 */
	public void updateStockTradeRecord(int stockTradeId, double volume)
			throws DataBaseAccessException, DBOperationFailureException {

		LOGGER_OBJ.debug("execution of updateStockTradeRecord() method started.");
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getdbconnection();
			statement = connection.prepareStatement(UPDATE_QUERY);
			statement.setDouble(1, volume);
			statement.setInt(2, stockTradeId);
			statement.executeUpdate();
		} catch (SQLException exp) {
			LOGGER_OBJ.error("unable to access stocktrade database");
			throw new DataBaseAccessException("unable to access stocktrade database" + exp);
		} finally {

			DBUtil.cleanupdbresources(resultSet, statement, connection);

		}

		LOGGER_OBJ.debug("updateStockTradeRecord() method execution completed.");

	}

	/**
	 * Deletes the stockTrade record from the database.
	 * 
	 * @throws DataBaseAccessException     when there is problem in accessing the
	 *                                     database.
	 * @throws DBOperationFailureException when the operation on the database fails.
	 */
	@Override
	public void deleteStockTradeRecord(int stockTradeId) throws DataBaseAccessException, DBOperationFailureException {

		LOGGER_OBJ.debug("execution of deleteStockTradeRecord() method started.");
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DBUtil.getdbconnection();
			statement = connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1, stockTradeId);
			LOGGER_OBJ.debug(statement.executeUpdate());

		} catch (SQLException exp) {
			LOGGER_OBJ.error("unable to access stocktrade database");
			throw new DataBaseAccessException("unable to access stocktrade database" + exp);
		} finally {
			DBUtil.cleanupdbresources(resultSet, statement, connection);
		}
		LOGGER_OBJ.debug("deleteStockTradeRecord() method execution completed.");
	}

	

	
	
}