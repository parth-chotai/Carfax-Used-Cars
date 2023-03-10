package com.carfax.usedcars.ui.views

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.carfax.usedcars.R
import com.carfax.usedcars.data.model.Listings
import com.carfax.usedcars.extensions.callDealer
import com.carfax.usedcars.extensions.numberTruncation
import com.carfax.usedcars.util.BottomElevation
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import kotlinx.coroutines.launch
import java.text.DecimalFormat


@OptIn(ExperimentalCoilApi::class, ExperimentalPermissionsApi::class)
@Composable
fun CarDetailsScreen(
    car: Listings,
    pop: () -> Unit,
) {
    BackHandler {
        pop()
    }
    val context = LocalContext.current
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
    val exteriorColor = car.exteriorColor!!
    val interiorColor = car.interiorColor!!
    val driveType = car.drivetype!!
    val transmission = car.transmission!!
    val bodyStyle = car.bodytype!!
    val engine = car.engine!!
    val displacement = car.displacement!!
    val fuel = car.fuel!!
    val phone = car.dealer?.phone!!
    val vehicleInfoMap = mapOf(
        stringResource(R.string.location) to "$city, $state",
        stringResource(R.string.exterior_color) to exteriorColor,
        stringResource(R.string.interior_color) to interiorColor,
        stringResource(R.string.drive_type) to driveType,
        stringResource(R.string.transmission) to transmission,
        stringResource(R.string.body_style) to bodyStyle,
        stringResource(R.string.engine) to "$engine $displacement",
        stringResource(R.string.fuel) to fuel
    )
    val permissionState = rememberPermissionState(Manifest.permission.CALL_PHONE)
    val scaffoldState = rememberScaffoldState()
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { wasGranted ->
            if (wasGranted) {
                phone.callDealer(context)
            }
        }
    val scope = rememberCoroutineScope()
    val snackbarHostState = scaffoldState.snackbarHostState

    Scaffold(scaffoldState = scaffoldState)
    {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState()))
            {
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.aspectRatio(1.77f)
                )
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(text = stringResource(R.string.year_make_model_trim,
                        year,
                        make,
                        model,
                        trim),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(0.7f)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.price_mileage,
                            price,
                            mileage.numberTruncation()),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider(color = Color.LightGray.copy(0.4f))
                Column(modifier = Modifier.padding(start = 24.dp)) {
                    Spacer(Modifier.height(8.dp))
                    Text(text = stringResource(R.string.vehicle_info),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(Modifier.height(24.dp))
                    vehicleInfoMap.forEach { (attribute, value) ->
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = attribute,
                                color = Color.Gray,
                                modifier = Modifier.weight(1f))
                            Text(text = value,
                                modifier = Modifier.weight(1f))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                BottomElevation(alpha = 0.3f, height = 6.dp)
            }
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF3777bc))
                    .clickable {
                        //region Permissions
                        when (permissionState.status) {
                            PermissionStatus.Granted -> {
                                phone.callDealer(context)
                            }
                            else -> {
                                if (permissionState.status.shouldShowRationale) {
                                    scope.launch {
                                        val result =
                                            snackbarHostState.showSnackbar(
                                                message = context.getString(R.string.permission_required),
                                                actionLabel = context.getString(R.string.go_to_settings)
                                            )
                                        if (result == SnackbarResult.ActionPerformed) {
                                            val intent = Intent(
                                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                                Uri.fromParts("package", context.packageName, null)
                                            )
                                            context.startActivity(intent)
                                        }
                                    }
                                } else {
                                    launcher.launch(Manifest.permission.CALL_PHONE)
                                }
                            }
                        }
                        //endregion
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.call_dealer),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}