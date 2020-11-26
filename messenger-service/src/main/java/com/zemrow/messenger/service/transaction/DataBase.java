package com.zemrow.messenger.service.transaction;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import java.io.Closeable;
import java.sql.SQLException;

/**
 * Хранилище данных
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class DataBase implements Closeable{
  private final HikariDataSource hikariDataSource;

  /**
   * TODO
   *
   * @param url      Адрес БД
   * @param user     Логин пользователя к БД
   * @param password Пароль пользователя к БД
   */
  public DataBase(String url, String user, String password){
    final PGSimpleDataSource dataSource = new PGSimpleDataSource();
    dataSource.setUrl(url);
    dataSource.setUser(user);
    dataSource.setPassword(password);
    final HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setDataSource(dataSource);
    //TODO
    //            hikariConfig.setConnectionTimeout(connectionTimeout);
    //            hikariConfig.setIdleTimeout(idleTimeout);
    //            hikariConfig.setMaximumPoolSize(maxPoolSize);
    //            hikariConfig.setMaxLifetime(maxLifeTime);
    //            hikariConfig.setMinimumIdle(minIdleConnections);
    hikariDataSource = new HikariDataSource(hikariConfig);
  }

  /**
   * Начать новую транзакцию.
   *
   * @return Транзакция.
   */
  public Transaction transaction() throws SQLException{
    return new Transaction(hikariDataSource.getConnection());
  }

  //TODO
  public ReadOnly readOnly() throws SQLException{
    return new ReadOnly(hikariDataSource.getConnection());
  }

  @Override
  public void close(){
    hikariDataSource.close();
  }
}
