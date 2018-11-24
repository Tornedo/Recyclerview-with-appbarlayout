package app.zalora.com.zalora.utils

import java.text.MessageFormat
import java.util.*

class StringUtils {

    companion object {

        private const val MAX_MESSAGE_SIZE = 50

        @Throws(SplitException::class)
        fun splitMessage(message: String): List<String> {
            val chars = message.toCharArray()
            val indexList = messageSplitIndexList(chars, 0)
            val total = indexList.size

            if (total == 1) {
                return listOf(message)
            }

            var fromIndex = 0
            val result = ArrayList<String>()

            for (part in 0 until total) {
                val splitIndex = indexList[part]
                val subMessage = message.substring(fromIndex, splitIndex).trim { it <= ' ' }
                fromIndex = splitIndex
                result.add(MessageFormat.format("{0}/{1} {2}", part + 1, total, subMessage))
            }

            return result
        }

        /*
        this function retutn the index where the string will be splited
         */
        @Throws(SplitException::class)
        private fun messageSplitIndexList(message: CharArray, fromIndex: Int): List<Int> {
            val result = ArrayList<Int>()

            if (message.size - fromIndex <= MAX_MESSAGE_SIZE) {
                result.add(message.size)
                return result
            }

            var splitIndex = fromIndex + MAX_MESSAGE_SIZE

            while (splitIndex > fromIndex && !Character.isWhitespace(message[splitIndex])) {
                splitIndex--
            }

            if (splitIndex > fromIndex) {
                result.add(splitIndex)
                result.addAll(messageSplitIndexList(message, splitIndex + 1))
            } else {

                /*
                if the legth of non whitespace char sequence is greater then  MAX_MESSAGE_SIZE then it will throw
                the following exception
                 */

                throw SplitException("Can't split message")
            }

            return result
        }
    }


}