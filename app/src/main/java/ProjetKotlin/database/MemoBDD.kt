package ProjetKotlin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ProjetKotlin.models.MemoDAO
import ProjetKotlin.main.MemoDTO

@Database(entities=[MemoDTO::class], version=1)
abstract class MemoBDD : RoomDatabase()
{
    abstract fun memoDAO(): MemoDAO
}