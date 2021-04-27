package com.piappstudio.offlineexam.model.pojo

import com.google.gson.Gson
import com.google.gson.JsonObject
import junit.framework.TestCase
import org.junit.Test

class PageTest : TestCase() {

    @Test
    fun testParsing() {
        val response = "{\"page\":{\"cards\":[{\"card_type\":\"text\",\"card\":{\"value\":\"Hello, Welcome to App!\",\"attributes\":{\"text_color\":\"#262626\",\"font\":{\"size\":30}}}},{\"card_type\":\"title_description\",\"card\":{\"title\":{\"value\":\"Check out our App every week for exciting offers.\",\"attributes\":{\"text_color\":\"#262626\",\"font\":{\"size\":24}}},\"description\":{\"value\":\"Offers available every week!\",\"attributes\":{\"text_color\":\"#262626\",\"font\":{\"size\":18}}}}},{\"card_type\":\"image_title_description\",\"card\":{\"image\":{\"url\":\"https://qaevolution.blob.core.windows.net/assets/ios/3x/Featured@4.76x.png\",\"size\":{\"width\":1170,\"height\":1498}},\"title\":{\"value\":\"Movie ticket to Dark Phoenix!\",\"attributes\":{\"text_color\":\"#FFFFFF\",\"font\":{\"size\":18}}},\"description\":{\"value\":\"Tap to see offer dates and rescriptions.\",\"attributes\":{\"text_color\":\"#FFFFFF\",\"font\":{\"size\":12}}}}},{\"card_type\":\"title_description\",\"card\":{\"title\":{\"value\":\"This is a sample text title v1\",\"attributes\":{\"text_color\":\"#262626\",\"font\":{\"size\":20}}},\"description\":{\"value\":\"This is a sample text description v1\",\"attributes\":{\"text_color\":\"#262626\",\"font\":{\"size\":12}}}}},{\"card_type\":\"image_title_description\",\"card\":{\"image\":{\"url\":\"https://qaevolution.blob.core.windows.net/assets/ios/3x/Tuesday2@4.76x.png\",\"size\":{\"width\":1170,\"height\":1170}},\"title\":{\"value\":\"25% off merch at t-mobile.com\",\"attributes\":{\"text_color\":\"#FFFFFF\",\"font\":{\"size\":20}}},\"description\":{\"value\":\"Tap to see offer dates and rescriptions.\",\"attributes\":{\"text_color\":\"#FFFFFF\",\"font\":{\"size\":13}}}}},{\"card_type\":\"title_description\",\"card\":{\"title\":{\"value\":\"This is a sample text title v2\",\"attributes\":{\"text_color\":\"#262626\",\"font\":{\"size\":20}}},\"description\":{\"value\":\"This is a sample text description v2\",\"attributes\":{\"text_color\":\"#262626\",\"font\":{\"size\":14}}}}}]}}"
        val element = Gson().fromJson(response, JsonObject::class.java)
        val page = Gson().fromJson(element.get("page"), Page::class.java)
        assertTrue(page!=null)
    }
}