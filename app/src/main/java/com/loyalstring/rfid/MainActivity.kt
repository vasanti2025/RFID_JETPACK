package com.loyalstring.rfid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.loyalstring.rfid.ui.screens.AppDrawer
import com.loyalstring.rfid.ui.theme.SparkleRFIDTheme


class MainActivity  : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SparkleRFIDTheme {
                AppDrawer()
            }
        }
    }
}