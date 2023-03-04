package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class FacetCountMap(

    @SerializedName("bedType")
    var bedType: BedType? = BedType(),

    @SerializedName("bodyStyle")
    var bodyStyle: BodyStyle? = BodyStyle(),

    @SerializedName("cabType")
    var cabType: CabType? = CabType(),

    @SerializedName("dealerIndustry")
    var dealerIndustry: DealerIndustry? = DealerIndustry(),

    @SerializedName("driveType")
    var driveType: DriveType? = DriveType(),

    @SerializedName("engines")
    var engines: Engines? = Engines(),

    @SerializedName("exteriorColor")
    var exteriorColor: ExteriorColor? = ExteriorColor(),

    @SerializedName("fuelType")
    var fuelType: FuelType? = FuelType(),

    @SerializedName("interiorColor")
    var interiorColor: InteriorColor? = InteriorColor(),

    @SerializedName("make")
    var make: Make? = Make(),

    @SerializedName("mileageRange")
    var mileageRange: MileageRange? = MileageRange(),

    @SerializedName("model")
    var model: Model? = Model(),

    @SerializedName("noAccidents")
    var noAccidents: NoAccidents? = NoAccidents(),

    @SerializedName("oneOwner")
    var oneOwner: OneOwner? = OneOwner(),

    @SerializedName("options")
    var options: Options? = Options(),

    @SerializedName("percentilePrices")
    var percentilePrices: PercentilePrices? = PercentilePrices(),

    @SerializedName("personalUse")
    var personalUse: PersonalUse? = PersonalUse(),

    @SerializedName("pillarCombos")
    var pillarCombos: PillarCombos? = PillarCombos(),

    @SerializedName("popularOptions")
    var popularOptions: PopularOptions? = PopularOptions(),

    @SerializedName("price")
    var price: Price? = Price(),

    @SerializedName("recordType")
    var recordType: RecordType? = RecordType(),

    @SerializedName("serviceRecords")
    var serviceRecords: ServiceRecords? = ServiceRecords(),

    @SerializedName("transmission")
    var transmission: Transmission? = Transmission(),

    @SerializedName("trim")
    var trim: Trim? = Trim(),

    @SerializedName("yearRange")
    var yearRange: YearRange? = YearRange(),
)