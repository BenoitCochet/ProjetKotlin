package ProjetKotlin.models

import androidx.lifecycle.ViewModel
import ProjetKotlin.main.MemoDTO
import ProjetKotlin.main.MainRepository

class MemoViewModel : ViewModel()
{
    private lateinit var mainRepository: MainRepository

    fun init(mainRepository: MainRepository)
    {
        this.mainRepository = mainRepository
    }

    fun getLiveDataMemo(): List<MemoDTO>?
    {
        return mainRepository.getLiveDataMemo()
    }

    fun insertMemo(memo: MemoDTO)
    {
        mainRepository.addMemo(memo)
    }
}