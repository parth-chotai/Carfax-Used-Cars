package com.carfax.usedcars.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.carfax.usedcars.R
import com.carfax.usedcars.data.model.Listings
import com.carfax.usedcars.extensions.callDealer
import com.carfax.usedcars.extensions.numberTruncation
import java.text.DecimalFormat


@OptIn(ExperimentalCoilApi::class)
@Composable
fun Car(
    car: Listings,
    navigate: (car: Listings) -> Unit,
) {
    val painter = rememberImagePainter(
        data = car.images?.firstPhoto?.large,
        builder = {
            error(R.drawable.placeholder)
        }
    )
    val decimalFormatter = DecimalFormat("#,###,###")
    val year = car.year!!
    val make = car.make!!
    val model = car.model!!
    val trim = car.trim!!
    val price = decimalFormatter.format(car.currentPrice!!)
    val mileage = car.mileage!!
    val city = car.dealer?.city!!
    val state = car.dealer?.state!!
    val phone = car.dealer?.phone!!
    val context = LocalContext.current

    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column {
            Column(
                modifier = Modifier.clickable {
                    navigate(car)
                }
            ) {
                Box {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.aspectRatio(1.77f)
                    )
                    if (painter.state is ImagePainter.State.Loading) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center),
                            color = Color.White)
                    }
                }
                Column(modifier = Modifier.padding(
                    top = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                ))
                {
                    Text(
                        text = stringResource(R.string.year_make_model_trim,
                            year,
                            make,
                            model,
                            trim),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.price_mileage,
                            price,
                            mileage.numberTruncation())
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.city_state, city, state)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(color = Color.LightGray.copy(0.6f))
                }
            }
            Text(
                text = stringResource(R.string.call_dealer),
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3777bc),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        phone.callDealer(context)
                    }
            )
        }
    }
}

@Composable
fun UsedCarsListings(
    cars: List<Listings>,
    navigate: (car: Listings) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFf5f5f5))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF3777bc)),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.carfax),
                color = Color.White,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 40.dp, top = 24.dp, bottom = 24.dp)
            )
        }
        LazyColumn(
            contentPadding = PaddingValues(top = 24.dp, start = 4.dp, end = 4.dp, bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.weight(1f, fill = false)
        ) {
            items(cars) { car ->
                Car(car, navigate)
            }
        }
    }
}