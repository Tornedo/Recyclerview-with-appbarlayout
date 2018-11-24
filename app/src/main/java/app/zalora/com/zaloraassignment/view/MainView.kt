package app.zalora.com.zaloraassignment.view

import app.zalora.com.zaloraassignment.model.TweetEntity
import java.util.ArrayList

interface MainView {

    fun showProgress()

    fun hideProgress()

    fun setItems(tweetList: ArrayList<TweetEntity>)

    fun showMessage(message: String)
}