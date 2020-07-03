package ProjetKotlin.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ProjetKotlin.R
import org.parceler.Parcels
import ProjetKotlin.main.MemoDTO

class DetailActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val memo = Parcels.unwrap<MemoDTO>(intent.getParcelableExtra("memo"))
        val fragment = DetailFragment()
        val bundle = Bundle()
        bundle.putString("contenu", memo.contenu)
        fragment.arguments = bundle
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view_tag, fragment, "transactionFragment")
        fragmentTransaction.commit()
    }
}
