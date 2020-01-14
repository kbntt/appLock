package es.kr.applock.com;

import android.provider.BaseColumns;

public class DataBase {
    public static final class CreateAppLockTable implements BaseColumns{
        public static final String APP_NAME = "app_name";
        public static final String PACKAGE_NAME = "packageName";
        public static final String TABLE_NAME = "app_lock";
        public static final String CREATE_SQL = "create table " +TABLE_NAME+"(" +
                "" +PACKAGE_NAME+" text PRIMARY KEY, "+
                "" +APP_NAME+" text not null "+
                ")";
    }
}
