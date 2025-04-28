package com.loyalstring.rfid.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loyalstring.rfid.R
import com.loyalstring.rfid.ui.utils.BackgroundGradient
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Surface(
                tonalElevation = 8.dp,
                shape = RoundedCornerShape(topEnd = 24.dp, bottomEnd = 24.dp),
                modifier = Modifier
                    .width(280.dp)
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()) // ✅ Make entire Drawer scrollable
                ) {
                    Text(
                        text = "Sparkle RFID",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Red,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                    )

                    Divider()

                    DrawerItemList()

                    Divider()

                    LogoutButton()
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Home", color = Color.White) },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier.background(BackgroundGradient)
                )
            }
        ) { padding ->
            HomeScreenContent(modifier = Modifier.padding(padding))
        }
    }
}

@Composable
fun DrawerItemList() {
    val items = listOf(
        DrawerItem("Home", painterResource(id = R.drawable.home_svg)),
        DrawerItem("Product", painterResource(id = R.drawable.product_svg)),
        DrawerItem("Inventory", painterResource(id = R.drawable.inventory_svg)),
        DrawerItem("Order", painterResource(id = R.drawable.order_svg)),
        DrawerItem("Search", painterResource(id = R.drawable.search_svg)),
        DrawerItem("Stock Transfer", painterResource(id = R.drawable.stock_transfer_svg)),
        DrawerItem("Report", painterResource(id = R.drawable.report_svg)),
        DrawerItem("Quotations", painterResource(id = R.drawable.quotation_svg)),
        DrawerItem("Estimate", painterResource(id = R.drawable.estimate_svg)),
        DrawerItem("Invoice", painterResource(id = R.drawable.invoice_svg)),
        DrawerItem("Sample In", painterResource(id = R.drawable.samplein_svg)),
        DrawerItem("Sample Out", painterResource(id = R.drawable.sampleout_svg)),
        DrawerItem("Settings", painterResource(id = R.drawable.setting_svg_rfid)),
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        items.forEach { item ->
            NavigationDrawerItem(
                label = {
                    Text(
                        text = item.label,
                        fontSize = 14.sp,
                        maxLines = 1
                    )
                },
                selected = false,
                onClick = { /* Handle click for each item */ },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(20.dp)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 4.dp)
            )
        }
    }
}


@Composable
fun LogoutButton() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Button(
            onClick = { /* Handle logout */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    BackgroundGradient,
                    shape = RoundedCornerShape(8.dp)
                )
                .height(44.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Icon(
                painterResource(id = R.drawable.logout),
                contentDescription = "Logout",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text("Logout", color = Color.White, fontSize = 14.sp)
        }
    }
}

data class DrawerItem(
    val label: String,
    val icon: Painter
)
