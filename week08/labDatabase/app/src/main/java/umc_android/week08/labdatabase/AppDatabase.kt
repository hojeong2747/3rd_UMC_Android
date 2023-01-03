package umc_android.week08.labdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    // 전역적으로 사용하는 함수, 변수 담을 수 있음
    companion object {
        private var appDatabase: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if(appDatabase == null) {
                synchronized(AppDatabase::class.java) {
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                    ).allowMainThreadQueries().build()
                    // RoomDB 객체를 만듦
                }
            }
            return appDatabase
        }
    }
}