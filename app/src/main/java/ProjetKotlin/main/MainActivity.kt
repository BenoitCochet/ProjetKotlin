package ProjetKotlin.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import ProjetKotlin.R
import ProjetKotlin.helpers.ItemTouchHelperCallback
import ProjetKotlin.models.MemoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import ProjetKotlin.models.MemoAdapter

class MainActivity : AppCompatActivity()
{

    private lateinit var memoViewModel: MemoViewModel
    private lateinit var memoAdapter: MemoAdapter
    private var listeMemos: MutableList<MemoDTO>? = ArrayList()
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ViewModel
        memoViewModel = ViewModelProvider(this).get(MemoViewModel::class.java)
        memoViewModel.init(MainRepository())
        listeMemos = memoViewModel.getLiveDataMemo()?.toMutableList()
        //Adapter
        memoAdapter = MemoAdapter(listeMemos!!, this)
        //Recycler view
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(memoAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerview)
        recyclerview.adapter = memoAdapter
    }

    fun ajouterMemo(v: View)
    {
        val nouveauMemo = MemoDTO(inputMemo!!.text.toString())
        listeMemos?.add(nouveauMemo)
        memoViewModel.insertMemo(nouveauMemo)
        recyclerview.adapter?.notifyDataSetChanged()
        inputMemo.text.clear()
    }
}
