package com.funnit.foodrecipe

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.funnit.foodrecipe.ui.theme.FoodRecipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RecipeScreen()
                }
            }
        }
    }
}

@Composable
fun RecipeScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextFunc(stringResource(id = R.string.app_name))
                }, backgroundColor = colorResource(id = R.color.deep_orange)
            )

        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.yemekresim),
                    contentDescription = "Food Image"
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { Log.e("Like", "Liked") },
                        modifier = Modifier.weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.light_deep_orange)
                        )
                    ) {
                        TextFunc(content = stringResource(id = R.string.like_button_text))
                    }
                    Button(
                        onClick = { Log.e("Comment", "Commented") },
                        modifier = Modifier.weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.dark_deep_orange)
                        )
                    ) {
                        TextFunc(content = stringResource(id = R.string.comment_button_text))
                    }
                }
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.food_name),
                        color = colorResource(
                            id = R.color.primary_color
                        ),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        TextFunc(content = stringResource(id = R.string.food_type_title))
                        TextFunc(content = stringResource(id = R.string.date_text))
                    }

                    Text(
                        text = "As an applied field of Translation Studies, gastronomic translation is a particular subject of study which includes its own translation procedures, patterns, and strategies. Gastronomic texts do not only contain cooking recipes or restaurant menus, but also cooking blogs, websites, food magazines, local and international cuisines, culinary news, food marketing, and other relevant text groups about cookery and food.",
                        modifier = Modifier.padding(10.dp),
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.secondary_text),
                        fontFamily = FontFamily.Monospace
                    )
                }
            }

        }
    )
}

@Composable
fun TextFunc(content: String) {
    Text(text = content)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodRecipeTheme {
        RecipeScreen()
    }
}