package com.reactiveworks.stocktrade;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.reactiveworks.stocktrade.dao.IStockTradeDao;
import com.reactiveworks.stocktrade.dao.StockTradeDaoFactory;
import com.reactiveworks.stocktrade.model.StockTrade;
import com.reactiveworks.stocktrade.service.InsertionJob;

public class StockTradeApplication {

	public static void main(String[] args)
			throws Exception {
		
		ExecutorService service=Executors.newFixedThreadPool(10);
		StockTradeDaoFactory stockTradeFactoryObj=new StockTradeDaoFactory();
		IStockTradeDao stockTradeDaoObj=stockTradeFactoryObj.getStockTradeDaoInstance();
		List<StockTrade> stockTradeObjList=stockTradeDaoObj.getStockTradeRecords();
		InsertionJob insertionjobs[]=new InsertionJob[stockTradeObjList.size()];
		
		for(int index=0;index<stockTradeObjList.size();index++) {
			InsertionJob job=new InsertionJob(stockTradeObjList.get(index));
			insertionjobs[index]=job;
		}
		
		for(InsertionJob job:insertionjobs) {
			service.submit(job);
		}
		
		service.shutdown();
		
	}
}