package inexture.com.simpledemo

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import inexture.com.simpledemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.btnViewactivity.setOnClickListener {
            val i = Intent(this@MainActivity, PersistentBottomSheetActivity::class.java)
            startActivity(i)
        }
        binding.btnFragementactivity.setOnClickListener {
            val i = Intent(this@MainActivity, ModelBottomSheetActivity::class.java)
            startActivity(i)
        }

        binding.btnListactivity.setOnClickListener {
            val i = Intent(this@MainActivity, ModelBottomSheetWithListActivity::class.java)
            startActivity(i)
        }

    }


}
