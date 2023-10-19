package com.example.composeuiforprofiles

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composeuiforprofiles.model.BottomNavItem
import com.example.composeuiforprofiles.model.Userdata

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Explore(context: Context , userlist : List<Userdata>,bottomNavItems:List<BottomNavItem>) {
    val text = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row {
                    Column(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .weight(0.8F)
                    ) {
                        Text(text = "Explore")
                        Row {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "Location"
                            )
                            Text(
                                text = "San Fransisco, California",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.1F)) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "notification"
                        )
                    }
                }
            }, navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Nav Icon",
                    modifier = Modifier.size(30.dp)
                )
            }, colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color(0xFF002c3d),
                scrolledContainerColor = Color(0xFF002c3d),
                navigationIconContentColor = MaterialTheme.colorScheme.surface,
                titleContentColor = MaterialTheme.colorScheme.surface,
                actionIconContentColor = MaterialTheme.colorScheme.surface
            )
            )
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.fillMaxWidth()) {
                NavigationBar(containerColor = Color.White) {
                    bottomNavItems.forEach { item ->
                        NavigationBarItem(selected = item.selected,
                            onClick = {
                                Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
                                item.selected = !item.selected
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = "Icon",
                                    tint = Color(0xFF002c3d)
                                )
                            })
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = "",
                onValueChange = { text.value = it },
                placeholder = { Text("Search", style = MaterialTheme.typography.bodyMedium) },
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth(0.8F)
                    .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(50))
                    .height(45.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    containerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(userlist) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .width(350.dp)
                            .height(200.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ),
                    ) {
                        Column {

                            Row(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                                    .height(110.dp)
                                    .weight(0.6F)
                            ) {
                                Image(
                                    painter = painterResource(id = it.image),
                                    modifier = Modifier
                                        .size(100.dp, 100.dp)
                                        .fillMaxWidth(0.4F)
                                        .clip(RoundedCornerShape(16.dp)),
                                    contentDescription = "profile",
                                    contentScale = ContentScale.Crop
                                )
                                Column(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .fillMaxHeight()
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Bottom
                                    ) {
                                        Text(
                                            text = it.name,
                                            style = MaterialTheme.typography.titleMedium,
                                            modifier = Modifier.weight(0.6F)
                                        )
                                        TextButton(onClick = {
                                            Toast.makeText(
                                                context,
                                                "Sending Invitation...",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }, modifier = Modifier.weight(0.4F)) {
                                            Text(text = "+ invite")
                                        }
                                    }
                                    Text(text = it.address)
                                }
                            }
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = it.things, style = MaterialTheme.typography.titleSmall)
                                Text(text = it.community)
                            }
                        }
                    }
                }
            }
        }
    }
}


