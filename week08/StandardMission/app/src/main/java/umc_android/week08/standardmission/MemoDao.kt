package umc_android.week08.standardmission

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDao {
    @Insert
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)

    @Query("SELECT * FROM Memo")
    fun selectAll(): List<Memo>

    @Query("SELECT * FROM Memo WHERE memoId = :memoId")
    fun selectByUserId(memoId: Int): Memo

    @Query("SELECT * FROM Memo WHERE memo = :memo")
    fun selectByUserName(memo: String): List<Memo>

    @Query("UPDATE Memo SET memo = :memo WHERE memoId = :memoId")
    fun updateNameByUserId(memoId: Int, memo: String)
}