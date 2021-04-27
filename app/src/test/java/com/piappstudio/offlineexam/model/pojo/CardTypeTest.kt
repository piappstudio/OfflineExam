package com.piappstudio.offlineexam.model.pojo

import junit.framework.TestCase
import org.junit.Test

class CardTypeTest : TestCase() {

    // To test the enum
    @Test
    fun testCardType() {
        var cardType = CardType.IMAGE_TITLE_DESCRIPTION
        assertTrue(cardType.type === "image_title_description")
        cardType = CardType.from("text")
        assertTrue(cardType === CardType.TEXT)
        cardType = CardType.from("text_item")
        assertTrue(cardType == CardType.NONE)
    }
}