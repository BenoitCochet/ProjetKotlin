package ProjetKotlin.main

import ProjetKotlin.models.MemoDAO
import ProjetKotlin.di.DIApplication

import javax.inject.Inject

class MainRepository
{
    @Inject
    lateinit var memoDAO: MemoDAO

    fun getLiveDataMemo(): List<MemoDTO>
    {
        return memoDAO.getListeMemos()
    }

    fun addMemo(memo: MemoDTO)
    {
        memoDAO.insert(memo)
    }

    fun deleteMemo(memo: MemoDTO)
    {
        memoDAO.delete(memo)
    }

    init
    {
        DIApplication.getAppComponent()?.inject(this)
    }
}