package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_pattern),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .alpha(0.1f),
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 30.dp,
                    bottom = 30.dp,
                    start = 15.dp,
                    end = 15.dp
                ),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.width(50.dp))
            Row {
                BusinessCardMain()
            }
            Row {
                BusinessCardContact()
            }
        }
    }
}

@Composable
private fun BusinessCardMain() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.card_logo),
            contentDescription = "Card Logo",
            modifier = Modifier.width(80.dp)
        )
        Text(
            text = stringResource(id = R.string.full_name),
            fontSize = 40.sp,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Text(
            text = stringResource(id = R.string.job),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun BusinessCardContact() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactItem(
            iconPainter = painterResource(id = R.drawable.mobile),
            text = stringResource(id = R.string.mobile_number)
        )
        ContactItem(
            iconPainter = painterResource(id = R.drawable.email),
            text = stringResource(id = R.string.email)
        )
        ContactItem(
            iconPainter = painterResource(id = R.drawable.website),
            text = stringResource(id = R.string.website)
        )
    }
}

@Composable
private fun ContactItem(
    iconPainter: Painter,
    text: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp)
            .padding(top = 12.dp, bottom = 12.dp)
    ) {
        ContactIcon(
            iconPainter = iconPainter,
        )
        ContactText(text = text)
    }
}

@Composable
private fun ContactIcon(
    iconPainter: Painter,
) {
    Icon(
        painter = iconPainter,
        contentDescription = "Interface Icon",
        tint = Color(0xFF244575),
        modifier = Modifier.size(30.dp)
    )
}

@Composable
private fun ContactText(
    text: String,
) {
    Text(
        text = text,
        fontSize = 18.sp,
        modifier = Modifier.padding(start = 30.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}