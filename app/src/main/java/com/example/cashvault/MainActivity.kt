package com.example.cashvault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cashvault.presentation.components.DashboardScreen
import com.example.cashvault.ui.theme.CashVaultTheme
import com.example.cashvault.ui.theme.darkBlue
import com.example.cashvault.ui.theme.darkGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CashVaultTheme {
                Box(
                    modifier = Modifier
                        .background(color = darkBlue)
                        .fillMaxSize()
                ) {
  DashboardScreen()
                }
            }
        }
    }
}
