package com.example.androidcoffeeshopapp.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppIconComponent(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,
    background: Color = Color.LightGray,
    onClick: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .background(background, CircleShape)
            .size(46.dp),
        contentAlignment = Alignment.Center
    ) {
        IconComponent(icon = icon, tint = tint)
    }
}

@Composable
fun IconComponent(
    @DrawableRes icon: Int,
    tint: Color = Color.Unspecified,
    modifier: Modifier = Modifier,
    size: Dp = 20.dp
) {

    Icon(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = modifier.size(size),
        tint = tint
    )
}