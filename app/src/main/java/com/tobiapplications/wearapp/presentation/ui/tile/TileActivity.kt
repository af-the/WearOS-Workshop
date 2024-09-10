package com.tobiapplications.wearapp.presentation.ui.tile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import com.tobiapplications.wearapp.presentation.theme.WearAppTheme

class TileActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WearAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = when (intent.getStringExtra(EXTRA_JOURNEY)) {
                                EXTRA_JOURNEY_CONVERSATION -> {
                                    val contact = intent.getStringExtra(EXTRA_CONVERSATION_CONTACT)
                                    "Conversation: $contact"
                                }
                                EXTRA_JOURNEY_NEW -> "New conversation"
                                EXTRA_JOURNEY_SEARCH -> "Search for a conversation"
                                else -> "Opened from app launcher"
                            }, modifier = Modifier
                                .padding(all = 8.dp)
                                .align(Alignment.Center),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

    companion object {
        internal const val EXTRA_JOURNEY = "journey"
        internal const val EXTRA_JOURNEY_CONVERSATION = "journey:conversation"
        internal const val EXTRA_CONVERSATION_CONTACT = "conversation:contact"
        internal const val EXTRA_JOURNEY_NEW = "journey:new"
        internal const val EXTRA_JOURNEY_SEARCH = "journey:search"
    }
}