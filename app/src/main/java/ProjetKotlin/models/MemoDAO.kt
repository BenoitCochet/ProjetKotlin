package ProjetKotlin.models

import androidx.room.*
import ProjetKotlin.main.MemoDTO

@Dao
abstract class MemoDAO
{
    @Query("SELECT * FROM memo")
    abstract fun getListeMemos(): MutableList<MemoDTO>

    @Insert
    abstract fun insert(vararg memo: MemoDTO)

    @Update
    abstract fun update(vararg memo: MemoDTO)

    @Delete
    abstract fun delete(vararg memo: MemoDTO)
}