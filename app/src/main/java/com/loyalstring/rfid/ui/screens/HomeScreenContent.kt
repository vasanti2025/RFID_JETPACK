package com.loyalstring.rfid.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loyalstring.rfid.R
import com.loyalstring.rfid.ui.utils.BackgroundGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    var showSearchField by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        BackgroundGradient
                    ),
                color = Color.Transparent,
                shadowElevation = 4.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp) // Standard AppBar height
                ) {
                    // Left: Menu and Home Text
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 8.dp)
                    ) {
                        IconButton(onClick = { /* Handle menu click */ }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }

                        Text(
                            text = "Home",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    // Right: Search Box
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color.Transparent,
                        border = BorderStroke(1.dp, Color.White),
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 8.dp)
                            .height(40.dp)
                            .width(200.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Search...",
                                color = Color.White.copy(alpha = 0.5f),
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 16.dp)
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Grid Items
            val items = listOf(
                GridItem("Product", painterResource(id = R.drawable.home_svg)),
                GridItem("Inventory", painterResource(id = R.drawable.inventory_svg)),
                GridItem("Order", painterResource(id = R.drawable.order_svg)),
                GridItem("Search", painterResource(id = R.drawable.search_svg)),
                GridItem("Stock Transfer", painterResource(id = R.drawable.stock_transfer_svg)),
                GridItem("All Report", painterResource(id = R.drawable.report_svg)),
                GridItem("Quotations", painterResource(id = R.drawable.quotation_svg)),
                GridItem("Estimate", painterResource(id = R.drawable.estimate_svg)),
                GridItem("Invoice", painterResource(id = R.drawable.invoice_svg)),
                GridItem("Sample In", painterResource(id = R.drawable.samplein_svg)),
                GridItem("Sample Out", painterResource(id = R.drawable.sampleout_svg)),
                GridItem("Settings", painterResource(id = R.drawable.setting_svg_rfid))
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxHeight(0.9f),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items) { item ->
                    HomeGridItem(item = item)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Sparkle RFID",
                    fontSize = 18.sp,
                    color = Color(0xFF0077D4),
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
fun HomeGridItem(item: GridItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.0f to Color(0xFF0077D4), // Start Blue
                            0.45f to Color(0xFFD60000), // Red at 45%
                            0.45f to Color(0xFFD60000), // Continue Red
                            1.0f to Color(0xFFD60000)   // End Red
                        )
                    )
                )
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = item.icon,   // ✅ Correct: painter not imageVector
                    contentDescription = item.label,
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.label,
                    color = Color.White,
                    fontSize = 12.sp,
                    maxLines = 1
                )
            }
        }
    }
}

data class GridItem(val label: String, val icon: Painter)
