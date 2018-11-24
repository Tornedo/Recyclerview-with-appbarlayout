package app.zalora.com.zaloraassignment

import app.zalora.com.zalora.utils.SplitException
import app.zalora.com.zalora.utils.StringUtils
import org.junit.Assert
import org.junit.Test


class StringUtilsTest {

    @Test
    fun splitMessageGeneralTest() {
        val message1 = "Small Message"
        val split1 = StringUtils.splitMessage(message1)
        Assert.assertEquals(split1[0],message1)

        val message2 = "Message with length exact 50. Some padding added.."
        val split2 = StringUtils.splitMessage(message2)
        Assert.assertEquals( split2[0],message2)
    }

    @Test
    fun splitMessageLargeTest() {
        val message1 = "Testing split. This is the part one message and this is the part two message"
        val split1 = StringUtils.splitMessage(message1)

        Assert.assertEquals(
                listOf("1/2 Testing split. This is the part one message and", "2/2 this is the part two message"),
                split1
        )
    }

    @Test(expected = SplitException::class)
    fun splitMessageErrorTest() {
        val message = "habijabi.unsplitable.large.message.this.should.thow.exception"
        StringUtils.splitMessage(message)
    }
}
