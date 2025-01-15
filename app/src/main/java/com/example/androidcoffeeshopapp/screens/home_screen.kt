package com.example.androidcoffeeshopapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidcoffeeshopapp.R
import com.example.androidcoffeeshopapp.components.AppIconComponent
import com.example.androidcoffeeshopapp.components.IconComponent
import com.example.androidcoffeeshopapp.components.LogoComponent
import com.example.androidcoffeeshopapp.navigation.Menu
import com.example.androidcoffeeshopapp.navigation.menuList
import com.example.androidcoffeeshopapp.navigation.product_details
import com.example.androidcoffeeshopapp.ui.theme.StarBucksGreen

@Composable
fun HomeScreen(navhostController: NavHostController) {

    var search by remember {
        mutableStateOf("")
    }

    var selected by remember {
        mutableStateOf(1)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Header()
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    TextDescription()
                    Box {
                        SearchBarScreen(text = search, onValueChange = {
                            search = it
                        })
                        AppIconComponent(
                            icon = R.drawable.filter,
                            background = StarBucksGreen,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(55.dp)
                        )
                    }
                    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
                        items(menuList, key = { it.id }) {
                            CustomChipScreen(menu = it,
                                selected = it.id == selected,
                                onValueChange = { data -> selected = data })
                        }
                    }
                    Popular(onClick = {
                        navhostController.navigate(product_details)
                    })
                }
            }
        }
    }
}

@Composable
private fun Popular(
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = stringResource(id = R.string.popular), style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.W500, color = Color.Black
                )
            )
            Text(
                text = stringResource(id = R.string.see_all), style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.W500, color = Color.Black
                )
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        LazyRow {
            items(5) {
                ItemEachRow { onClick() }
            }
        }
    }
}

@Composable
fun ItemEachRow(onClick: () -> Unit) {

    var selected by rememberSaveable { mutableStateOf(false) }

    Card(shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .width(220.dp)
            .padding(end = 10.dp, top = 5.dp)
            .clickable { onClick() }) {

        Column(modifier = Modifier.background(Color.LightGray)) {
            Box(
                modifier = Modifier
                    .background(
                        Color.LightGray,
                        RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp),
                    )
                    .fillMaxWidth()
                    .height(300.dp), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.image),
                    contentDescription = "",
                    modifier = Modifier
                        .height(150.dp)
                        .width(100.dp)
                )
            }
            Column(
                modifier = Modifier.padding(15.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.chocolate_cappuccino), style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Italic
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string._20_00), style = TextStyle(
                            color = StarBucksGreen, fontSize = 18.sp, fontWeight = FontWeight.W500
                        )
                    )
                    IconButton(
                        onClick = { selected = !selected }, modifier = Modifier.size(24.dp)
                    ) {
                        IconComponent(
                            icon = R.drawable.love,
                            tint = if (selected) Color.Red else Color.Unspecified
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomChipScreen(
    menu: Menu, selected: Boolean, onValueChange: (Int) -> Unit, modifier: Modifier = Modifier
) {
    TextButton(
        onClick = { onValueChange(menu.id) },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = if (selected) StarBucksGreen else Color.Gray,
            contentColor = if (selected) Color.White else Color.White
        ),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 10.dp),
        modifier = Modifier.padding(end = 10.dp)
    ) {
        Text(
            text = menu.title, style = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight.W600
            )
        )
    }
}

@Composable
fun SearchBarScreen(text: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = stringResource(id = R.string.search), style = TextStyle(
                    color = Color.DarkGray, fontSize = 16.sp, fontWeight = FontWeight.W600
                )
            )
        },
        leadingIcon = {
            IconComponent(icon = R.drawable.search)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        shape = RoundedCornerShape(25.5.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = StarBucksGreen
        )
    )
}

@Composable
fun TextDescription() {
    Text(
        text = stringResource(id = R.string.our_way_of_loving_you_back),
        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.W600, color = Color.Black),
        modifier = Modifier.padding(vertical = 30.dp)
    )
}

@Composable
private fun Header() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppIconComponent(icon = R.drawable.menu)
        LogoComponent(size = 55.dp)
        AppIconComponent(icon = R.drawable.bag)
    }
}

