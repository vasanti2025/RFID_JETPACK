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
import com.loyalstring.rfid.ui.utils.BackgroundGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContentNew(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BackgroundGradient),
                color = Color.Transparent,
                shadowElevation = 4.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp) // Standard AppBar height
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
                GridItem1("Product", painterResource(id = R.drawable.product_gr_svg)),
                GridItem1("Inventory", painterResource(id = R.drawable.inventory_gr_svg)),
                GridItem1("Order", painterResource(id = R.drawable.order_gr_svg)),
                GridItem1("Search", painterResource(id = R.drawable.search_gr_svg)),
                GridItem1("Stock Transfer", painterResource(id = R.drawable.stock_tr_gr_svg)),
                GridItem1("All Report", painterResource(id = R.drawable.report_gr_svg)),
                GridItem1("Quotations", painterResource(id = R.drawable.quotation_gr_svg)),
                GridItem1("Estimate", painterResource(id = R.drawable.estimate_gr_svg)),
                GridItem1("Invoice", painterResource(id = R.drawable.inventory_gr_svg)),
                GridItem1("Sample In", painterResource(id = R.drawable.sample_in_gr_svg)),
                GridItem1("Sample Out", painterResource(id = R.drawable.sample_out_gr_svg)),
                GridItem1("Settings", painterResource(id = R.drawable.setting_gr_svg))
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
                    HomeGridItem1(item = item)
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
fun HomeGridItem1(item: GridItem1) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White // Changed to White background
        ),
        elevation = CardDefaults.cardElevation(4.dp) // Optional: add slight elevation if you want a slight shadow
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = item.icon,
                    contentDescription = item.label,
                    tint = Color.Unspecified,
                  //  tint = Color(0xFF0B37B9), // Optional: you can set icon color if you want (blue)
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.label,
                    color = Color.Black, // Text color changed to Black for visibility
                    fontSize = 12.sp,
                    maxLines = 1
                )
            }
        }
    }
}


data class GridItem1(val label: String, val icon: Painter)
