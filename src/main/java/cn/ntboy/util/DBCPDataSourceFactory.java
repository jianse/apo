package cn.ntboy.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCPDataSourceFactory extends UnpooledDataSourceFactory {

    public DBCPDataSourceFactory() {
        this.dataSource = new XBasicDataSource();
    }

    class XBasicDataSource extends BasicDataSource{

        @Override
        public synchronized void close() throws SQLException {
            DriverManager.deregisterDriver(DriverManager.getDriver(getUrl()));
            super.close();
        }
    }
}
