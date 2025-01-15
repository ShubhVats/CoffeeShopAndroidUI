package com.example.androidcoffeeshopapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidcoffeeshopapp.R
import com.example.androidcoffeeshopapp.components.AppIconComponent
import com.example.androidcoffeeshopapp.components.IconComponent
import com.example.androidcoffeeshopapp.components.LogoComponent
import com.example.androidcoffeeshopapp.ui.theme.StarBucksGreen

@Composable
fun ProductDetailsScreen(navhostController: NavHostController) {
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
            ProductHeader() { navhostController.navigateUp() }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    ShowProduct()
                    ProductDescription()
                }
            }
        }
        ButtonComponent(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun ProductDescription(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 20.dp)
) {
    Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceAround) {
        Text(
            text = stringResource(R.string.coffee), style = TextStyle(
                color = StarBucksGreen, fontSize = 18.sp, fontWeight = FontWeight.W400
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.chocolate_cappuccino).replace("\n", " "),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W500,
                ),
            )
            Row() {
                IconComponent(
                    icon = R.drawable.star,
                    size = 20.dp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(R.string._4_5), style = TextStyle(
                        color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.W500
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_etiam_at_mi_vitae_augue_feugiat_scelerisque_in_a_eros),
            style = TextStyle(
                color = Color.DarkGray, fontSize = 16.sp, fontWeight = FontWeight.W400
            ),
        )
    }
}

@Composable
fun ShowProduct() {

    var counter by remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(Color.LightGray, RoundedCornerShape(14.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = "",
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.background(Color.White, RoundedCornerShape(40.dp))) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AppIconComponent(icon = R.drawable.plus, background = StarBucksGreen, modifier = Modifier.size(40.dp)) {
                        counter++
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = counter.toString(), style = TextStyle(
                            color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.W500
                        ),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    AppIconComponent(icon = R.drawable.minus, background = StarBucksGreen,modifier = Modifier.size(40.dp)) {
                        if (counter != 0) {
                            counter--
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ButtonComponent(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White, containerColor = StarBucksGreen
        ),
        shape = RoundedCornerShape(37.dp),
        contentPadding = PaddingValues(vertical = 15.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {
        Text(
            text = stringResource(R.string.add_to_bag), style = TextStyle(
                fontSize = 20.sp, fontWeight = FontWeight.W600
            )
        )
    }
}

@Composable
private fun ProductHeader(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppIconComponent(icon = R.drawable.back) {
            onClick()
        }
        LogoComponent(size = 55.dp)
        AppIconComponent(icon = R.drawable.love, tint = StarBucksGreen)

    }
}