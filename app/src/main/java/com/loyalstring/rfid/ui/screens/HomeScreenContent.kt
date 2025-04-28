package com.loyalstring.rfid.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loyalstring.rfid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Brush.linearGradient(listOf(Color(0xFF0077D4), Color(0xFF004F8C)))),
                color = Color.Transparent,
                shadowElevation = 4.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp) // Standard AppBar height
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
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(horizontal = 10.dp) // Apply padding only horizontally
        ) {
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
                contentPadding = PaddingValues(5.dp), modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f) // Ensures the grid fills 90% of the available height
                    .padding(top = 0.dp) // Removes top padding explicitly
                ,

                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(items) { item ->
                    HomeGridItem(item = item)
                }
            }

            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth() // Ensures the Box takes up the full width
                    .padding(start = 8.dp, top = 5.dp, bottom = 8.dp) // Adds padding to the Box
                    .height(30.dp) // Optional: You can set a specific height or remove this if you want it to adjust to the image's size
            ) {
                Image(
                    painter = painterResource(id = R.drawable.drawer_icon), // Replace with your actual image name
                    contentDescription = "Sparkle RFID Logo",
                    modifier = Modifier
                        .align(Alignment.Center) // Centers the image within the Box
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
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF0077D4), // Start Blue
                            Color(0xFFD60000)  // End Red
                        ),
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
