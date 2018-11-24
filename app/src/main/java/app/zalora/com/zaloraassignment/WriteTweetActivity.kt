package app.zalora.com.zalora

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import app.zalora.com.zaloraassignment.R

class WriteTweetActivity : AppCompatActivity() {

    internal var inputText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_tweet_main)
        inputText = findViewById(R.id.tweetContentEditTExt)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()!!.setDisplayShowHomeEnabled(true);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_write_tweet, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_done -> {
                doneClick()
                return true;
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun doneClick() {
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("tweet-data", inputText!!.text.toString())
        Log.e("data ", inputText!!.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
