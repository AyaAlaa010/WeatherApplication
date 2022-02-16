package com.example.weatherapplication.data.local.current;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CurrentDataBase_Impl extends CurrentDataBase {
  private volatile CurrentDao _currentDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `myCurrent` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `key` INTEGER NOT NULL, `currentAddress` TEXT NOT NULL, `currentDate` TEXT NOT NULL, `currentDescription` TEXT NOT NULL, `currentTemp` TEXT NOT NULL, `currentPressure` INTEGER NOT NULL, `currentHumedity` INTEGER NOT NULL, `currentWind` TEXT NOT NULL, `currentCloud` INTEGER NOT NULL, `currentIcon` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3521c0ab3073df7a23361ba15966bfc1')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `myCurrent`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMyCurrent = new HashMap<String, TableInfo.Column>(11);
        _columnsMyCurrent.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("key", new TableInfo.Column("key", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("currentAddress", new TableInfo.Column("currentAddress", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("currentDate", new TableInfo.Column("currentDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("currentDescription", new TableInfo.Column("currentDescription", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("currentTemp", new TableInfo.Column("currentTemp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("currentPressure", new TableInfo.Column("currentPressure", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("currentHumedity", new TableInfo.Column("currentHumedity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("currentWind", new TableInfo.Column("currentWind", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("currentCloud", new TableInfo.Column("currentCloud", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCurrent.put("currentIcon", new TableInfo.Column("currentIcon", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMyCurrent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMyCurrent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMyCurrent = new TableInfo("myCurrent", _columnsMyCurrent, _foreignKeysMyCurrent, _indicesMyCurrent);
        final TableInfo _existingMyCurrent = TableInfo.read(_db, "myCurrent");
        if (! _infoMyCurrent.equals(_existingMyCurrent)) {
          return new RoomOpenHelper.ValidationResult(false, "myCurrent(com.example.weatherapplication.data.local.current.CurrentEntity).\n"
                  + " Expected:\n" + _infoMyCurrent + "\n"
                  + " Found:\n" + _existingMyCurrent);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "3521c0ab3073df7a23361ba15966bfc1", "dcb8807a0e475acd07fa8b634fa94e41");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "myCurrent");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `myCurrent`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CurrentDao.class, CurrentDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public CurrentDao currentDao() {
    if (_currentDao != null) {
      return _currentDao;
    } else {
      synchronized(this) {
        if(_currentDao == null) {
          _currentDao = new CurrentDao_Impl(this);
        }
        return _currentDao;
      }
    }
  }
}
