package app.zalora.com.zalora

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.Log.e
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

import butterknife.BindView
import com.mathi.recyclerviewsample.CustomAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import android.support.v4.app.NavUtils
import app.zalora.com.zaloraassignment.R
import app.zalora.com.zaloraassignment.TweetEntity


class MainActivity : AppCompatActivity()  {

    internal var dataList: ArrayList<TweetEntity>? = null
    internal var customAdapter: CustomAdapter? = null
    internal var RESULT_CODE = 5;
    @BindView(R.id.recycler_view) @JvmField var androidRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            var intent = Intent(this, WriteTweetActivity::class.java)
            startActivityForResult(intent, RESULT_CODE)
        }
        dataList = ArrayList<TweetEntity>()
    }

    private fun setupAdaptar() {
        customAdapter = CustomAdapter(this@MainActivity, dataList!!)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        androidRecyclerView?.layoutManager = mLayoutManager;
       androidRecyclerView!!.layoutManager = mLayoutManager
        androidRecyclerView?.adapter = customAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            android.R.id.home -> {
               finish()
                return true
            }
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == RESULT_CODE) {
                var resultString: String = data!!.getStringExtra("tweet-data")
                e("message ",resultString);
            }
        }
    }



}
