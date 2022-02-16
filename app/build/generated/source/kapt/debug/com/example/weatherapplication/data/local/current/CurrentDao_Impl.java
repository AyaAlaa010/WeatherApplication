package com.example.weatherapplication.data.local.current;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CurrentDao_Impl implements CurrentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CurrentEntity> __insertionAdapterOfCurrentEntity;

  private final EntityDeletionOrUpdateAdapter<CurrentEntity> __updateAdapterOfCurrentEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CurrentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCurrentEntity = new EntityInsertionAdapter<CurrentEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `myCurrent` (`id`,`key`,`currentAddress`,`currentDate`,`currentDescription`,`currentTemp`,`currentPressure`,`currentHumedity`,`currentWind`,`currentCloud`,`currentIcon`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CurrentEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getKey());
        if (value.currentAddress == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.currentAddress);
        }
        if (value.currentDate == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.currentDate);
        }
        if (value.currentDescription == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.currentDescription);
        }
        if (value.currentTemp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.currentTemp);
        }
        stmt.bindLong(7, value.getCurrentPressure());
        stmt.bindLong(8, value.getCurrentHumedity());
        if (value.currentWind == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.currentWind);
        }
        stmt.bindLong(10, value.getCurrentCloud());
        if (value.currentIcon == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.currentIcon);
        }
      }
    };
    this.__updateAdapterOfCurrentEntity = new EntityDeletionOrUpdateAdapter<CurrentEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `myCurrent` SET `id` = ?,`key` = ?,`currentAddress` = ?,`currentDate` = ?,`currentDescription` = ?,`currentTemp` = ?,`currentPressure` = ?,`currentHumedity` = ?,`currentWind` = ?,`currentCloud` = ?,`currentIcon` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CurrentEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getKey());
        if (value.currentAddress == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.currentAddress);
        }
        if (value.currentDate == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.currentDate);
        }
        if (value.currentDescription == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.currentDescription);
        }
        if (value.currentTemp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.currentTemp);
        }
        stmt.bindLong(7, value.getCurrentPressure());
        stmt.bindLong(8, value.getCurrentHumedity());
        if (value.currentWind == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.currentWind);
        }
        stmt.bindLong(10, value.getCurrentCloud());
        if (value.currentIcon == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.currentIcon);
        }
        stmt.bindLong(12, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM myCurrent";
        return _query;
      }
    };
  }

  @Override
  public void addLocation(final CurrentEntity currentEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCurrentEntity.insert(currentEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCurrentLocation(final CurrentEntity currentEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCurrentEntity.handle(currentEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<CurrentEntity> getCurrentLocation() {
    final String _sql = "SELECT * FROM myCurrent";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
      final int _cursorIndexOfCurrentAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "currentAddress");
      final int _cursorIndexOfCurrentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "currentDate");
      final int _cursorIndexOfCurrentDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "currentDescription");
      final int _cursorIndexOfCurrentTemp = CursorUtil.getColumnIndexOrThrow(_cursor, "currentTemp");
      final int _cursorIndexOfCurrentPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "currentPressure");
      final int _cursorIndexOfCurrentHumedity = CursorUtil.getColumnIndexOrThrow(_cursor, "currentHumedity");
      final int _cursorIndexOfCurrentWind = CursorUtil.getColumnIndexOrThrow(_cursor, "currentWind");
      final int _cursorIndexOfCurrentCloud = CursorUtil.getColumnIndexOrThrow(_cursor, "currentCloud");
      final int _cursorIndexOfCurrentIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "currentIcon");
      final List<CurrentEntity> _result = new ArrayList<CurrentEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CurrentEntity _item;
        _item = new CurrentEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpKey;
        _tmpKey = _cursor.getInt(_cursorIndexOfKey);
        _item.setKey(_tmpKey);
        if (_cursor.isNull(_cursorIndexOfCurrentAddress)) {
          _item.currentAddress = null;
        } else {
          _item.currentAddress = _cursor.getString(_cursorIndexOfCurrentAddress);
        }
        if (_cursor.isNull(_cursorIndexOfCurrentDate)) {
          _item.currentDate = null;
        } else {
          _item.currentDate = _cursor.getString(_cursorIndexOfCurrentDate);
        }
        if (_cursor.isNull(_cursorIndexOfCurrentDescription)) {
          _item.currentDescription = null;
        } else {
          _item.currentDescription = _cursor.getString(_cursorIndexOfCurrentDescription);
        }
        if (_cursor.isNull(_cursorIndexOfCurrentTemp)) {
          _item.currentTemp = null;
        } else {
          _item.currentTemp = _cursor.getString(_cursorIndexOfCurrentTemp);
        }
        final int _tmpCurrentPressure;
        _tmpCurrentPressure = _cursor.getInt(_cursorIndexOfCurrentPressure);
        _item.setCurrentPressure(_tmpCurrentPressure);
        final int _tmpCurrentHumedity;
        _tmpCurrentHumedity = _cursor.getInt(_cursorIndexOfCurrentHumedity);
        _item.setCurrentHumedity(_tmpCurrentHumedity);
        if (_cursor.isNull(_cursorIndexOfCurrentWind)) {
          _item.currentWind = null;
        } else {
          _item.currentWind = _cursor.getString(_cursorIndexOfCurrentWind);
        }
        final int _tmpCurrentCloud;
        _tmpCurrentCloud = _cursor.getInt(_cursorIndexOfCurrentCloud);
        _item.setCurrentCloud(_tmpCurrentCloud);
        if (_cursor.isNull(_cursorIndexOfCurrentIcon)) {
          _item.currentIcon = null;
        } else {
          _item.currentIcon = _cursor.getString(_cursorIndexOfCurrentIcon);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
