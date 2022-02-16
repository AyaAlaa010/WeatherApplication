package com.example.weatherapplication.data.local.favouriteroom;

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
public final class FavouriteDao_Impl implements FavouriteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavouriteEntity> __insertionAdapterOfFavouriteEntity;

  private final EntityDeletionOrUpdateAdapter<FavouriteEntity> __deletionAdapterOfFavouriteEntity;

  private final EntityDeletionOrUpdateAdapter<FavouriteEntity> __updateAdapterOfFavouriteEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public FavouriteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavouriteEntity = new EntityInsertionAdapter<FavouriteEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `favourite` (`id`,`favouriteLatLon`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouriteEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getFavouriteLatLon() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFavouriteLatLon());
        }
      }
    };
    this.__deletionAdapterOfFavouriteEntity = new EntityDeletionOrUpdateAdapter<FavouriteEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `favourite` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouriteEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfFavouriteEntity = new EntityDeletionOrUpdateAdapter<FavouriteEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `favourite` SET `id` = ?,`favouriteLatLon` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouriteEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getFavouriteLatLon() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFavouriteLatLon());
        }
        stmt.bindLong(3, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM favourite";
        return _query;
      }
    };
  }

  @Override
  public void addLocation(final FavouriteEntity favEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavouriteEntity.insert(favEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteLocation(final FavouriteEntity favEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFavouriteEntity.handle(favEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateLocation(final FavouriteEntity favEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfFavouriteEntity.handle(favEntity);
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
  public List<FavouriteEntity> getFavouriteLocation() {
    final String _sql = "SELECT * FROM favourite";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFavouriteLatLon = CursorUtil.getColumnIndexOrThrow(_cursor, "favouriteLatLon");
      final List<FavouriteEntity> _result = new ArrayList<FavouriteEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final FavouriteEntity _item;
        final String _tmpFavouriteLatLon;
        if (_cursor.isNull(_cursorIndexOfFavouriteLatLon)) {
          _tmpFavouriteLatLon = null;
        } else {
          _tmpFavouriteLatLon = _cursor.getString(_cursorIndexOfFavouriteLatLon);
        }
        _item = new FavouriteEntity(_tmpFavouriteLatLon);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
