package app.zalora.com.zaloraassignment.presenter

import app.zalora.com.zalora.utils.SplitException
import app.zalora.com.zalora.utils.StringUtils
import app.zalora.com.zaloraassignment.model.TweetEntity
import app.zalora.com.zaloraassignment.view.MainView
import java.util.*

internal class MainPresenter(private var mainView: MainView?) {

    fun processTweetData(tweet: String) {
        try {
            val dataList = ArrayList<TweetEntity>()
            val result = StringUtils.splitMessage(tweet)

            for (i in result) {
                dataList.add(TweetEntity(i))
            }
            //transfer the splited list to the main activity to show in list
            mainView?.apply {
                setItems(dataList)
            }
        } catch (e: SplitException) {
            //show the exception if split can't happen
            mainView?.apply {
                showMessage(e.message!!)
            }
        }
    }
}
